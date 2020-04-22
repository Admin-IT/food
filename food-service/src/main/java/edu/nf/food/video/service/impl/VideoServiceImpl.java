package edu.nf.food.video.service.impl;

import edu.nf.food.video.dao.VideoDao;
import edu.nf.food.video.entity.Video;
import edu.nf.food.video.service.VideoService;
import edu.nf.food.video.service.exception.VideoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao dao;

    @Override
    public List<Video> listVideo(Integer pageNum, Integer pageSize) {
        try {
            return dao.listVideo(pageNum, pageSize);
        } catch (Exception e) {
            throw new VideoException("数据库异常，请稍候重试！" + e);
        }
    }

    @Override
    public Video getVideoMsg(Integer id) {
        try {
            return dao.getVideoMsg(id);
        } catch (Exception e) {
            throw new VideoException("数据库异常，请稍候重试！" + e);
        }
    }

    @Override
    public List<Video> listSameVideo(String classified) {
        try {
            return dao.listSameVideo(classified);
        } catch (Exception e) {
            throw new VideoException("数据库异常，请稍候重试！" + e);
        }
    }

}
