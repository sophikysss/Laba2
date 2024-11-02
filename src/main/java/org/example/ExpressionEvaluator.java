package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionEvaluator
{
    private static final Map<Character, Integer> precedence = new HashMap<>();
    private final Map<String, Double> variables = new HashMap<>();
    static
    {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }
    public void setVariable(String name, double value)
    {
        variables.put(name, value);
    }

    private double applyOperator(char operator, double b, double a) throws Exception {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new Exception("Деление на ноль");
                return a / b;
            default:
                throw new Exception("Неизвестный оператор: " + operator);
        }
    }
}
