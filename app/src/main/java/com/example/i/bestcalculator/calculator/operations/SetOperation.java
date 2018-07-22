package com.example.i.bestcalculator.calculator.operations;

public class SetOperation implements Operation {
    @Override
    public float calculate(float currentValue, float appliedValue) {
        return currentValue * 10 + appliedValue;
    }
}
