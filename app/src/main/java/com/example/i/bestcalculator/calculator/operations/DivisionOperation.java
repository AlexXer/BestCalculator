package com.example.i.bestcalculator.calculator.operations;

class DivisionOperation implements Operation {
    @Override
    public float calculate(float currentValue, float appliedValue) {
        return currentValue / appliedValue;
    }
}
