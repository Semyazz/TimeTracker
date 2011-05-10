package com.shinobi.example.timetracker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IntelliJ IDEA.
 * User: Semy
 * Date: 10.05.11
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "db.sqlite";

    private static final int SCHEMA_VERSION = 8;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        android.util.Log.w(TAG, "Creating tables!");
        database.execSQL("CREATE TABLE time (id INTEGER PRIMARY KEY AUTOINCREMENT, starttime TEXT, endtime TEXT, tag_id INTEGER NOT NULL);");
        database.execSQL("CREATE TABLE tag (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

        android.util.Log.w("db", "Upgrading database, which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS time");
        database.execSQL("DROP TABLE IF EXISTS tag");
        onCreate(database);
    }
}
