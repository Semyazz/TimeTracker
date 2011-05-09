package com.shinobi.example.timetracker.com.shinobi.example.timetracker.database;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 09.05.11
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public class TimerResult {

    private String startTime;
    private String stopTime;
    private String tag;
    private String diff;

    TimerResult(String tag) {
        this.tag = tag;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

}
