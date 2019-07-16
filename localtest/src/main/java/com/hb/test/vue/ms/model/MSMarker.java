package com.hb.test.vue.ms.model;

public class MSMarker {
    private String id;
    private String content;

    public MSMarker() {
    }

    public MSMarker(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "MSMarker{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
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
}
