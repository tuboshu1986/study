package com.hb.test.vue.ms.model;

import java.util.ArrayList;
import java.util.List;

public class MSAnswer {
    private String id;
    private String content;

    private String questionId;

    private List<MSMarker> markers = new ArrayList<>();

    public MSAnswer(){

    }

    public MSAnswer(List<MSMarker> markers){
        this.markers = markers;
    }

    public MSAnswer(String id, String content, List<MSMarker> markers) {
        this.id = id;
        this.content = content;
        if(markers != null)
            this.markers = markers;
    }

    @Override
    public String toString() {
        return "MSAnswer{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", markers=" + markers +
                '}';
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<MSMarker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<MSMarker> markers) {
        this.markers = markers;
    }
}
