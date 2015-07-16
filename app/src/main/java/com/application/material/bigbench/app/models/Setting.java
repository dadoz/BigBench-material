package com.application.material.bigbench.app.models;

/**
 * Created by davide on 15/07/15.
 */
public class Setting {
    private String title;
    private String description;

    /**
     *
     * @param title
     * @param description
     */
    public Setting(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
