package com.hb.test.vue.ms.model;

import java.util.List;

public class MSAnswer {
    private String id;
    private String content;

    private List<MSMarker> markers;

    public MSAnswer(){

    }

    public MSAnswer(String id, String content, List<MSMarker> markers) {
        this.id = id;
        this.content = content;
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
