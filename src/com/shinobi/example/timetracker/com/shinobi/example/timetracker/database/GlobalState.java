package com.shinobi.example.timetracker.com.shinobi.example.timetracker.database;

import android.app.Application;

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
    }

    public TimerResult StopTimer() {

        //TODO: Pobrac aktualna date i wstawic do TimerResult.
        //TODO: zapisac do bazy danych wynik;

        SaveResult(currentTimer);
        return currentTimer;
    }

    private void SaveResult(TimerResult result) {


    }
}
