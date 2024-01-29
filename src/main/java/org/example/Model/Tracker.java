package org.example.Model;

import java.sql.Timestamp;


public class Tracker {

    private String name;

    private String details;

    private int distance;

    private Timestamp timeAdded;

    public Tracker(String name, String details, int distance, Timestamp timeAdded){
        this.name = name;
        this.details = details;
        this.distance = distance;
        this.timeAdded = timeAdded;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Timestamp getTimeAdded() {
        return this.timeAdded;
    }

    public void setTimeAdded(Timestamp timeAdded) {
        this.timeAdded = timeAdded;
    }

    public int getDistance(){
        return this.distance;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", distance=" + distance +
                ", timeAdded=" + timeAdded +
                '}';
    }
}

