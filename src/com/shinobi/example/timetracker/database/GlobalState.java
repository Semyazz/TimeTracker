package com.shinobi.example.timetracker.database;

import android.app.Application;
import android.content.SharedPreferences;
import com.shinobi.example.timetracker.database.TimerResult;
import com.shinobi.example.timetracker.settings.Settings;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 09.05.11
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class GlobalState extends Application {

    private TimerResult currentTimer = null;

    public void StartTimer(String tag) {
        this.currentTimer = new TimerResult(tag);
        long start = System.currentTimeMillis();
        this.currentTimer.setStartTime(start);
    }

    public TimerResult StopTimer() throws NullPointerException {

        long stop = System.currentTimeMillis();

        if (this.currentTimer == null) {
            throw new NullPointerException("Current Timer null");
        }
        this.currentTimer.setStopTime(stop);

        //TODO: zapisac do bazy danych wynik;
        SaveResult(currentTimer);

        return currentTimer;
    }

    private void SaveResult(TimerResult result) {
        //TODO: dodać wynik do bazy danych do SQLite

    }

    public void AddTag(String tag) {
        //TODO: dodać do bazy danych SQLite
    }

    public void RemoveTag(String tag) {
        //TODO: usuniecie taga z bazy danych
    }

    public String CurrentTag() {
        SharedPreferences settings = getSharedPreferences(Settings.PREFERENCES, 0);
        String tag = settings.getString(Settings.CURRENT_TAG, "");
        return tag;
    }

    public void SetCurrentTag(String tag) {

        SharedPreferences settings = getSharedPreferences(Settings.PREFERENCES, 0);

    }
}
