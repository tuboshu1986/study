package com.hb.test.serialized.model;

import java.io.Serializable;
import java.util.List;

public class PBAInformation implements Serializable {
    private static final long serialVersionUID = -6618548686333563489L;

    private String id;
    private boolean toolFrom;
    private Float toolPrice;
    private float price;
    private List<InfoFile> files;
    private InfoFile pic;

    @Override
    public String toString() {
        return "PBAInformation{" +
                "id='" + id + '\'' +
                ", toolFrom=" + toolFrom +
                ", toolPrice=" + toolPrice +
                ", price=" + price +
                ", files=" + files +
                ", pic=" + pic +
                '}';
    }

    public InfoFile getPic() {
        return pic;
    }

    public void setPic(InfoFile pic) {
        this.pic = pic;
    }

    public List<InfoFile> getFiles() {
        return files;
    }

    public void setFiles(List<InfoFile> files) {
        this.files = files;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isToolFrom() {
        return toolFrom;
    }

    public void setToolFrom(boolean toolFrom) {
        this.toolFrom = toolFrom;
    }

    public Float getToolPrice() {
        return toolPrice;
    }

    public void setToolPrice(Float toolPrice) {
        this.toolPrice = toolPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
