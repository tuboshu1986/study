package com.hb.test.vue.controller;

import com.hb.test.vue.dto.QuestionDto;
import com.hb.test.vue.service.MSQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vue/question")
public class MSQuestionController {

    @Autowired
    private MSQuestionService msQuestionService;

    @GetMapping("/list")
    public Object list(List<QuestionDto> cons){
        System.out.println(cons);
        return msQuestionService.search(null);
    }
}
