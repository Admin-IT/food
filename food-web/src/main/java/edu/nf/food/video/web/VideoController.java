package edu.nf.food.video.web;

import com.github.pagehelper.PageInfo;
import edu.nf.food.util.BaseController;
import edu.nf.food.video.entity.Video;
import edu.nf.food.video.service.VideoService;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VideoController extends BaseController {
    @Autowired
    private VideoService service;

    @GetMapping("/get_videos")
    public ResponseVO<PageInfo<Video>> getVideos(Integer pageNum, Integer pageSize) {
        List<Video> videoList = service.listVideo(pageNum, pageSize);
        PageInfo<Video> pageInfo = new PageInfo<>(videoList);
        return success(pageInfo);
    }

    @GetMapping("/get_video_msg")
    public ResponseVO<Video> getMsg(Integer id) {
        Video video = service.getVideoMsg(id);
        return success(video);
    }

    @GetMapping("/get_same_video")
    public ResponseVO<List<Video>> listSame(String classified) {
        //System.out.println(classified);
        List<Video> list = service.listSameVideo(classified);
        return success(list);
    }
}
