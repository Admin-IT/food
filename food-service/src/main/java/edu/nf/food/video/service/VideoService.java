package edu.nf.food.video.service;

import edu.nf.food.video.entity.Video;

import java.util.List;

public interface VideoService {
    List<Video> listVideo(Integer pageNum, Integer pageSize);

    Video getVideoMsg(Integer id);

    List<Video> listSameVideo(String classified);
}
