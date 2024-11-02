package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionEvaluator {
    private static final Map<Character, Integer> precedence = new HashMap<>();
    private final Map<String, Double> variables = new HashMap<>();

    static {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }

    public void setVariable(String name, double value) {
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

    private double evaluateExpression(String expression) throws Exception
    {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++)
        {
            char token = expression.charAt(i);

            // Пропуск пробелов
            if (token == ' ')
            {
                continue;
            }


        if (Character.isDigit(token) || token == '.')
        {
            StringBuilder number = new StringBuilder();
            while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.'))
            {
                number.append(expression.charAt(i++));
            }
            values.push(Double.parseDouble(number.toString()));
            i--;
        }
        else if (Character.isLetter(token))
        {
            String varName = String.valueOf(token);
            if (!variables.containsKey(varName))
            {
                throw new Exception("Неизвестная переменная: " + varName);
            }
            values.push(variables.get(varName));
        }
        else if (precedence.containsKey(token))
        {
            while (!operators.isEmpty() && precedence.get(operators.peek()) >= precedence.get(token))
            {
                values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
            }
            operators.push(token);
        }
    }
    while (!operators.isEmpty())
    {
        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
    }

        return values.pop();
}
}