package edu.nf.food.video.dao;

import edu.nf.food.video.entity.VideoStep;

import java.util.List;

public interface VideoStepDao {
    List<VideoStep> listStep(Integer videoId);
}
