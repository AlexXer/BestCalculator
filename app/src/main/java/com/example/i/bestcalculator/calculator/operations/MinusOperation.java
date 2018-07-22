package com.example.i.bestcalculator.calculator.operations;

class MinusOperation implements Operation {
    @Override
    public float calculate(float currentValue, float appliedValue) {
        return currentValue - appliedValue;
    }
}
