package com.example.adammalej.calculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HistoryDB.db";
    public static final String HISTORIES_TABLE_NAME = "histories";
    public static final String HISTORIES_COLUMN_ID = "id";
    public static final String HISTORIES_COLUMN_EXPRESSION = "expression";
    private HashMap hashMap;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table histories" +
                "(id text primary key, expression text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS histories");
        onCreate(db);
    }
}
