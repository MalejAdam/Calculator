package com.example.adammalej.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ExpressionHistory extends Activity {
    private DBHelper dbHelper;
    TextView expression;
    int from_Where_I_Am_Coming = 0;
    int id_To_Update = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
