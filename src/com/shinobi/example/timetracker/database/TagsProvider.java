package com.shinobi.example.timetracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 10.05.11
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class TagsProvider {

    private static final String TAG = "TagsProvider";

    public static boolean TagExists(Context ctx, String name) {

        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] args = {name};
        Cursor result = db.rawQuery("SELECT * FROM tag WHERE id = ?", args);

        if (result.getCount() == 0) return false;

        return true;
    }

    public static String[] GetAllTags(Context ctx) throws Exception {

        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        try {

            String[] s = {};
            Cursor result = db.rawQuery("SELECT name FROM tag", s);

            ArrayList<String> tags = new ArrayList<String>();

            if (result.getCount() == 0) {
                return s;
            } else {

                result.moveToFirst();
                tags.add(result.getString(2));

                while (result.moveToNext()) {
                    tags.add(result.getString(2));
                }

                return (String[]) tags.toArray();
            }

        } catch (Exception exc) {

            throw exc;
        } finally {

            db.close();
            dbHelper.close();
        }
    }

    public static Tag GetTag(Context ctx, String name) throws Exception {

        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        try {
            String[] s = {name};

            Cursor result = db.rawQuery("SELECT name FROM tag WHERE name = ?", s);

            if (result.getCount() > 0) {
                Tag tag = new Tag();
                tag.setId(result.getInt(1));
                tag.setName(result.getString(2));

                return tag;
            } else {
                return null;
            }

        } catch (Exception exc) {

            throw exc;
        } finally {
            db.close();
            dbHelper.close();
        }
    }

    public static void AddTag(Context ctx, String tag) {

        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues newValues = new ContentValues(1);
        newValues.put("name", tag);

        if (db.insert("tag", "id", newValues) != 1) {
            Log.d(TAG, "Added tag: " + tag);
        } else {
            Log.e(TAG, "Error dodawania taga: " + tag);
        }

        db.close();
        dbHelper.close();
    }
}
