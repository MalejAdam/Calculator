package com.example.adammalej.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class display_history extends AppCompatActivity {

    ListView listView;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);
        dbHelper = new DBHelper(this);
        ArrayList<String> arrayList = dbHelper.getAllExpressions();
        listView = (ListView) findViewById(R.id.expressionList);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        clearHistory();
    }

    private void clearHistory()
    {
        findViewById(R.id.btnClearHistory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteAllRow();
            }
        });
    }


}
