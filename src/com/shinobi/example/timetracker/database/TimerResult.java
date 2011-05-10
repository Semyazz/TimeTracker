package com.shinobi.example.timetracker.database;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 09.05.11
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public class TimerResult {

    private long startTime;
    private long stopTime;
    private String tag;
    private String diff;

    TimerResult(String tag) {
        this.tag = tag;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDiff() {
        return diff;
    }
}
