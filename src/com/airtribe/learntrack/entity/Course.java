package com.airtribe.learntrack.entity;

public class Course
{
    private int id;
    private String cousreName;
    private String description;
    private double durationInWeeks;
    private boolean active;

    
    public Course(int id, String cousreName, String description, double durationInWeeks, boolean active) {
        this.id = id;
        this.cousreName = cousreName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getCousreName() {
        return cousreName;
    }


    public void setCousreName(String cousreName) {
        this.cousreName = cousreName;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public double getDurationInWeeks() {
        return durationInWeeks;
    }


    public void setDurationInWeeks(double durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }


    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }


    


}