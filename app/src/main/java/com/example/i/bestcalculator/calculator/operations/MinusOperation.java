package com.example.i.bestcalculator.calculator.operations;

public class MinusOperation implements Operation {
    @Override
    public float calculate(float currentValue, float appliedValue) {
        return currentValue - appliedValue;
    }
}
