package com.example.adammalej.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {


    Button onClickedButton;
    TextView textView;
    View.OnClickListener listener;
    int[] numberButtons = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    int[] operatorButtons = {R.id.btnAdd, R.id.btnEqual, R.id.btnSub, R.id.btnDiv, R.id.btnMul};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOnClick();
        operatorOnClick();
        clearTextViewField();
        deleteLastCharacter();
    }

    private void numberOnClick(){
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression(v);
            }
        };

        listenersForNumberButtons();
    }

    private void operatorOnClick(){
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpression(v);
            }
        };

        listenersForOperatorButtons();

        findViewById(R.id.btnEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.txtvExpression);
                String score = equalClick();
                textView.setText(score);
            }
        });
    }

    private void setExpression(View v)
    {
        textView = findViewById(R.id.txtvExpression);
        onClickedButton = (Button) v;
        textView.append(onClickedButton.getText());
    }

    private String equalClick()
    {
        textView = findViewById(R.id.txtvExpression);
        String text = textView.getText().toString();
        Expression expression = new ExpressionBuilder(text).build();
        double result = expression.evaluate();
        return  Double.toString(result);
    }

    private void clearTextViewField(){
        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = findViewById(R.id.txtvExpression);
                textView.setText("");
            }
        });
    }

    private void deleteLastCharacter()
    {
        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView = findViewById(R.id.txtvExpression);
                String expression = textView.getText().toString();
                if(expression != null && !expression.isEmpty()) {
                    expression = expression.substring(0, expression.length()-1);
                    textView.setText(expression);
                }
            }
        });
    }

    private void listenersForNumberButtons()
    {
        for (int id : numberButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void listenersForOperatorButtons()
    {
        for (int id : operatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }
}
