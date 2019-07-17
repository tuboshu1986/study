package com.hb.test.vue.controller;

import com.hb.test.vue.dto.QuestionDto;
import com.hb.test.vue.service.MSQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/vue/question")
public class MSQuestionController {

    @Autowired
    private MSQuestionService msQuestionService;

    @RequestMapping("/list")
    public Object list(@RequestBody(required = false) ArrayList<QuestionDto> cons){
        System.out.println(cons);
        return msQuestionService.searchByMame(cons == null ? null : cons.get(0).getQuestion());
    }
}
