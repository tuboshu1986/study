package com.hb.test.vue.controller;

import com.hb.test.vue.ms.model.MSQuestion;
import com.hb.test.vue.service.MSQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class MSQuestionController {

    @Autowired
    private MSQuestionService msQuestionService;

    @GetMapping("/list")
    public Object list(){
        return msQuestionService.search(null);
    }
}
