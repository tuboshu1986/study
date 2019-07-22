package com.hb.test.vue.service;

import com.hb.test.vue.ms.model.MSAnswer;
import com.hb.test.vue.ms.model.MSMarker;
import com.hb.test.vue.ms.model.MSQuestion;

import java.util.List;

public interface MSQuestionService<T extends MSQuestion> {
    List<T> search(MSQuestion condition);
    List<T> searchByMame(String name);
    void save(MSQuestion obj);
    MSQuestion get(String id);
    MSAnswer addAnswer(MSAnswer answer);
    MSMarker addMarkerForQuestion(String questionId, String markerContent);
    MSMarker addMarkerForAnswer(String answerId, String markerContent);
}
