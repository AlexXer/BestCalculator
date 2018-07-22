package com.example.i.bestcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.i.bestcalculator.calculator.Calculator;

public class MainActivity extends AppCompatActivity implements Calculator.CalculatorListener {
    private Calculator calculator;
    private TextView currentValueText, operationText, appliedValueText, calculatedValueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        calculator = new Calculator(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentValueText = findViewById(R.id.textView4);
        appliedValueText = findViewById(R.id.textView2);
        operationText = findViewById(R.id.textView3);
        calculatedValueText = findViewById(R.id.textView);

        findViewById(R.id.num0).setOnClickListener((view) -> calculator.addDigit(0));
        findViewById(R.id.num1).setOnClickListener((view) -> calculator.addDigit(1));
        findViewById(R.id.num2).setOnClickListener((view) -> calculator.addDigit(2));
        findViewById(R.id.num3).setOnClickListener((view) -> calculator.addDigit(3));
        findViewById(R.id.num4).setOnClickListener((view) -> calculator.addDigit(4));
        findViewById(R.id.num5).setOnClickListener((view) -> calculator.addDigit(5));
        findViewById(R.id.num6).setOnClickListener((view) -> calculator.addDigit(6));
        findViewById(R.id.num7).setOnClickListener((view) -> calculator.addDigit(7));
        findViewById(R.id.num8).setOnClickListener((view) -> calculator.addDigit(8));
        findViewById(R.id.num9).setOnClickListener((view) -> calculator.addDigit(9));

        findViewById(R.id.plus).setOnClickListener((view) -> calculator.setOperation(Calculator.OperationType.Plus));
        findViewById(R.id.minus).setOnClickListener((view) -> calculator.setOperation(Calculator.OperationType.Minus));
        findViewById(R.id.divide).setOnClickListener((view) -> calculator.setOperation(Calculator.OperationType.Division));
        findViewById(R.id.multiply).setOnClickListener((view) -> calculator.setOperation(Calculator.OperationType.Multiplication));
        findViewById(R.id.equals).setOnClickListener((view) -> calculator.setOperation(Calculator.OperationType.Set));
    }

    @Override
    public void onCalculatorUpdated() {
        currentValueText.setText(Float.toString(calculator.getCurrentValue()));
        operationText.setText(calculator.getOperationType().toString());
        appliedValueText.setText(Float.toString(calculator.getAppliedValue()));
        calculatedValueText.setText("= " + Float.toString(calculator.getCalculatedValue()));
    }
}
