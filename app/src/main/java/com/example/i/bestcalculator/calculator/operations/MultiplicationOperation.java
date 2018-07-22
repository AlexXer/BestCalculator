package com.example.i.bestcalculator.calculator.operations;

public class MultiplicationOperation implements Operation {
    @Override
    public float calculate(float currentValue, float appliedValue) {
        return currentValue * appliedValue;
    }
}
