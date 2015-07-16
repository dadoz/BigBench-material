package com.application.material.bigbench.app.models;

/**
 * Created by davide on 15/07/15.
 */
public class Setting {
    private String title;
    private String description;

    public Setting(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
