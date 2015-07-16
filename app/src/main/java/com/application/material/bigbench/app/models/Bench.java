package com.application.material.bigbench.app.models;

/**
 * Created by davide on 13/07/15.
 */
public class Bench {
    private int id;
    private int longitude;
    private int latitute;
    private String name;

    /**
     *
     * @param id
     * @param longitude
     * @param latitute
     * @param name
     */
    public Bench(int id, int longitude, int latitute, String name) {
        this.id = id;
        this.longitude = longitude;
        this.latitute = latitute;
        this.name = name;
    }
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     */
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     */
    public int getLatitute() {
        return latitute;
    }

    /**
     *
     * @param latitute
     */
    public void setLatitute(int latitute) {
        this.latitute = latitute;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
