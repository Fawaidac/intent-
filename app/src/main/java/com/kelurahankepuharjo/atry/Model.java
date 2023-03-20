package com.kelurahankepuharjo.atry;

public class Model {
    String title;
    String subtitle;
    int imagetitle;

    public Model(String title, String subtitle, int imagetitle) {
        this.title = title;
        this.subtitle = subtitle;
        this.imagetitle = imagetitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImagetitle() {
        return imagetitle;
    }

    public void setImagetitle(int imagetitle) {
        this.imagetitle = imagetitle;
    }
}
