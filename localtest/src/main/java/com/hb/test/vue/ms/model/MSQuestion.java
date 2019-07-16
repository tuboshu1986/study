package com.hb.test.vue.ms.model;

import java.util.List;

public class MSQuestion {
    private String id;
    private String content;

    private List<MSAnswer> answers;
    private List<MSMarker> marker;

    public MSQuestion(){

    }

    public MSQuestion(String id, String content, List<MSAnswer> answers, List<MSMarker> marker) {
        this.id = id;
        this.content = content;
        this.answers = answers;
        this.marker = marker;
    }

    @Override
    public String toString() {
        return "MSQuestion{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", answers=" + answers +
                ", marker=" + marker +
                '}';
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

    public List<MSAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<MSAnswer> answers) {
        this.answers = answers;
    }

    public List<MSMarker> getMarker() {
        return marker;
    }

    public void setMarker(List<MSMarker> marker) {
        this.marker = marker;
    }
}
