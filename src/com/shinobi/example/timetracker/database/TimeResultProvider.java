package com.shinobi.example.timetracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 10.05.11
 * Time: 21:27
 * To change this template use File | Settings | File Templates.
 */
public class TimeResultProvider {

    private static final String TAG = "TimeResultProvider";

    public static TimerResult[] GetAllTimeResults(Context ctx) throws Exception {

        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        try {

            String[] s = {};
            Cursor result = db.rawQuery("SELECT * FROM time t JOIN tag ta ON t.tag_id == ta.id", s);

            ArrayList<TimerResult> timerResults = new ArrayList<TimerResult>();

            if (result.getCount() == 0) {
                return (TimerResult[]) timerResults.toArray();
            } else {

                result.moveToFirst();
                TimerResult timerResult = new TimerResult(result.getString(5));
                long startTime = Long.parseLong(result.getString(2));
                long endTime = Long.parseLong(result.getString(3));

                timerResult.setStartTime(startTime);
                timerResult.setStopTime(endTime);

                timerResults.add(timerResult);

                while (result.moveToNext()) {

                    timerResult = new TimerResult(result.getString(5));
                    startTime = Long.parseLong(result.getString(2));
                    endTime = Long.parseLong(result.getString(3));

                    timerResult.setStartTime(startTime);
                    timerResult.setStopTime(endTime);

                    timerResults.add(timerResult);
                }

                return (TimerResult[]) timerResults.toArray();
            }

        } catch (Exception exc) {

            throw exc;
        } finally {

            db.close();
            dbHelper.close();
        }
    }

    public static void AddTimerResult(Context ctx, TimerResult result) throws Exception {

        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Tag tag = TagsProvider.GetTag(ctx, result.getTag());

        ContentValues newValues = new ContentValues(1);
        newValues.put("starttime", String.valueOf(result.getStartTime()));
        newValues.put("stoptime", String.valueOf(result.getStopTime()));
        newValues.put("tag_id", tag.getId());

        if (db.insert("time", "id", newValues) != 1) {
            Log.d(TAG, "Added timerResult");
        } else {
            Log.e(TAG, "Error dodawania timerResult");
        }

        db.close();
        dbHelper.close();
    }
}
