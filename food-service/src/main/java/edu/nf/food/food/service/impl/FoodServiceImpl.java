package edu.nf.food.food.service.impl;

import com.alibaba.fastjson.JSON;
import edu.nf.food.food.dao.FoodDao;
import edu.nf.food.food.entity.Content;
import edu.nf.food.food.entity.Food;
import edu.nf.food.food.service.FoodService;
import edu.nf.food.food.service.exception.FoodException;
import edu.nf.food.utils.HtmlPareUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author ethan
 * @Classname FoodServiceImpl
 * @Description TODO
 * @Date 2020/3/25 13:50
 * 菜谱
 */

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;


    /**
     * 获取菜谱列表
     * @return
     */
    @Override
    public List<Food> listFood() {
       try{
           List<Food> list = foodDao.listFood();
           return list;
       }catch (Exception e){
           throw new FoodException("获取菜谱异常：" + e);
       }
    }

    /**
     * 删除菜谱
     * @param food
     */
    @Override
    public void delFoodById(Food food) {
        try{
            foodDao.delFoodById(food);
        }catch (Exception e){
            throw new FoodException("删除菜谱异常：" + e);
        }
    }

    /**
     * 修改菜谱
     * @param food
     */
    @Override
    public void upFoodById(Food food) {
        try{
            foodDao.upFoodById(food);
        }catch (Exception e){
            throw new FoodException("修改菜谱异常：" + e);
        }
    }

    /**
     * 添加菜谱
     * @param food
     */
    @Override
    public void addFood(Food food) {
        try {
            foodDao.addFood(food);
        } catch (Exception e) {
            throw new FoodException("添加菜谱异常：" + e);
        }
    }


    /**
     * 注入配置类
     */
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public Boolean parseContent(String keywords) throws Exception {
        //  第一次  通过mysql 所有数据  mybatis 插入es


        // 从网页中 查询数据放入到集合
        List<Content> contents = new HtmlPareUtil().parseJD(keywords);


        // 把查询到的数据放入到 es中
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");
        for (int i = 0; i < contents.size(); i++) {
//            System.out.println(JSON.toJSONString(contents.get(i)));
            bulkRequest.add(
                    new IndexRequest("food")
                            .source(JSON.toJSONString(contents.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();
    }


    @Override
    public List<Map<String, Object>> searchPageHighlighter(String keyword, int pageNo, int pageSize) throws Exception {
        if (pageNo <= 1) {
            pageNo = 1;
        }

        // 条件搜索  使用索引  使用哪个数据库
        SearchRequest searchRequest = new SearchRequest("food");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 分页搜索
        sourceBuilder.from(pageNo);
        sourceBuilder.size(pageSize);
        System.out.println(keyword);
        // 精准匹配 term  先搜索再分词 中文不行
        //TermQueryBuilder termQueryBuilder = QueryBuilders.matchQuery("title,keyword");
        //使用match 先分词再搜索  可进行中文
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", keyword);
        sourceBuilder.query(matchQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //解析 结果
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }


        return list;
    }
}
