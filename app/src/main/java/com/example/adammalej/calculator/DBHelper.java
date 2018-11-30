package com.example.adammalej.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HistoryDB.db";
    public static final String HISTORIES_TABLE_NAME = "histories";
    public static final String HISTORIES_COLUMN_ID = "id";
    public static final String HISTORIES_COLUMN_EXPRESSION = "expression";

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

    public void insertExpression(String expression)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HISTORIES_COLUMN_EXPRESSION, expression);
        db.insert("histories", null, contentValues);
    }

    public void deleteAllRow()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + HISTORIES_TABLE_NAME);
    }

    public ArrayList<String> getAllExpressions(){
        ArrayList<String> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT expression FROM histories", null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arrayList.add(res.getString(res.getColumnIndex(HISTORIES_COLUMN_EXPRESSION)));
            res.moveToNext();
        }
        return  arrayList;
    }
}
