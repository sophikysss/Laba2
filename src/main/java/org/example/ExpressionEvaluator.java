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
}
