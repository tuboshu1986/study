package com.hb.test.vue.controller;

import com.hb.test.vue.dto.QuestionDto;
import com.hb.test.vue.ms.model.MSAnswer;
import com.hb.test.vue.ms.model.MSMarker;
import com.hb.test.vue.ms.model.MSQuestion;
import com.hb.test.vue.service.MSQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public Object get(@PathVariable("id") String id){
        return msQuestionService.get(id);
    }

    @PostMapping
    public Object post(String question, String answer, String markers){
        try {
            MSQuestion ques = new MSQuestion(null, question, null, null);
            if(!StringUtils.isEmpty(markers)){
                List<MSMarker> ms = new ArrayList<>();
                for(String m : markers.split(","))
                    ms.add(new MSMarker(UUID.randomUUID().toString(), m));
                ques.setMarker(ms);
            }
            if(!StringUtils.isEmpty(answer)){
                MSAnswer as = new MSAnswer(UUID.randomUUID().toString(), answer, null);
                ques.setAnswers(CollectionUtils.arrayToList(new MSAnswer[]{as}));
            }
            msQuestionService.save(ques);
        }catch (Exception e){
            e.printStackTrace();
            return "失败";
        }
        return "成功";
    }

    @PostMapping("/addMarkerForQuestion")
    public Object addMarkerForQuestion(String questionId, String markerContent){
        return msQuestionService.addMarkerForQuestion(questionId, markerContent);
    }

    @PostMapping("/addMarkerForAnswer")
    public Object addMarkerForAnswer(String answerId, String markerContent){
        return msQuestionService.addMarkerForAnswer(answerId, markerContent);
    }

    @PostMapping("/addAnswerForQuestion")
    public Object addAnswerForQuestion(String questionId, String answerContent){
        MSAnswer an = new MSAnswer(null, answerContent, null);
        an.setQuestionId(questionId);
        return msQuestionService.addAnswer(an);
    }
}
