package edu.nf.food.video.web;

import edu.nf.food.util.BaseController;
import edu.nf.food.video.entity.VideoStep;
import edu.nf.food.video.service.VideoStepService;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoStepController extends BaseController {
    @Autowired
    private VideoStepService service;

    @GetMapping("/get_method")
    public ResponseVO<List<VideoStep>> getMethod(Integer videoId) {
        List<VideoStep> list = service.getMethod(videoId);
        return success(list);
    }
}
