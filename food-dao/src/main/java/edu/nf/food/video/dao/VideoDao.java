package edu.nf.food.video.dao;

import edu.nf.food.video.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoDao {
    List<Video> listVideo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Video getVideoMsg(Integer id);

    List<Video> listSameVideo(String classified);
}
