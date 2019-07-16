package com.hb.test.vue.service;

import com.hb.test.vue.ms.model.MSQuestion;

import java.util.List;

public interface MSQuestionService<T extends MSQuestion> {
    List<T> search(MSQuestion condition);
}
