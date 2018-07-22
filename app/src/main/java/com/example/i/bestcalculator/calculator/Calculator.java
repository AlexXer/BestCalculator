package com.example.i.bestcalculator.calculator;

import com.example.i.bestcalculator.calculator.operations.DivisionOperation;
import com.example.i.bestcalculator.calculator.operations.MinusOperation;
import com.example.i.bestcalculator.calculator.operations.MultiplicationOperation;
import com.example.i.bestcalculator.calculator.operations.Operation;
import com.example.i.bestcalculator.calculator.operations.PlusOperation;
import com.example.i.bestcalculator.calculator.operations.SetOperation;

public class Calculator {
    private float currentValue, appliedValue, calculatedValue;
    private OperationType operationType = OperationType.Set;
    private Operation operationForAppliedValue = new SetOperation();
    private Operation operationForCalculatedValue = new SetOperation();
    private CalculatorListener calculatorListener;

    public Calculator(CalculatorListener calculatorListener) {
        this.calculatorListener = calculatorListener;
    }

    public float getCurrentValue() {
        return currentValue;
    }

    public float getAppliedValue() {
        return appliedValue;
    }

    public float getCalculatedValue() {
        return calculatedValue;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void addDigit(int digit) {
        appliedValue = operationForAppliedValue.calculate(appliedValue, digit);
        calculatedValue = operationForCalculatedValue.calculate(currentValue, appliedValue);
        updated();
    }

    public void setOperation(OperationType type) {
        if (operationType == type) return;
        appliedValue = 0;
        currentValue = calculatedValue;
        operationType = type;
        switch (operationType) {
            case Plus:
                operationForCalculatedValue = new PlusOperation();
                break;
            case Minus:
                operationForCalculatedValue = new MinusOperation();
                break;
            case Multiplication:
                operationForCalculatedValue = new MultiplicationOperation();
                break;
            case Division:
                operationForCalculatedValue = new DivisionOperation();
                break;
            default:
            case Set:
                operationForCalculatedValue = new SetOperation();
        }
        updated();
    }

    private void updated() {
        if (calculatorListener != null) calculatorListener.onCalculatorUpdated();
    }

    public enum OperationType {
        Set, Plus, Minus, Multiplication, Division;

        @Override
        public String toString() {
            switch (this) {
                case Plus:
                    return "+";
                case Minus:
                    return "-";
                case Multiplication:
                    return "*";
                case Division:
                    return "/";
                default:
                case Set:
                    return "";
            }
        }
    }

    public interface CalculatorListener {
        void onCalculatorUpdated();
    }
}
