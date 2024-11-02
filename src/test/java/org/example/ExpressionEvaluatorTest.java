package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    private ExpressionEvaluator evaluator;

    @BeforeEach
    void setup() {
        evaluator = new ExpressionEvaluator();
    }

    @Test
    void testSimpleAddition() throws Exception {
        assertEquals(7.0, evaluator.evaluate("3+4"), "Ошибка при сложении");
    }

    @Test
    void testSimpleSubtraction() throws Exception {
        assertEquals(-1.0, evaluator.evaluate("3-4"), "Ошибка при вычитании");
    }

    @Test
    void testSimpleMultiplication() throws Exception {
        assertEquals(12.0, evaluator.evaluate("3*4"), "Ошибка при умножении");
    }

    @Test
    void testSimpleDivision() throws Exception {
        assertEquals(0.75, evaluator.evaluate("3/4"), "Ошибка при делении");
    }

    @Test
    void testComplexExpression() throws Exception {
        assertEquals(11.0, evaluator.evaluate("3*4-1"), "Ошибка при вычислении сложного выражения");
    }

    @Test
    void testPrecedence() throws Exception {
        assertEquals(14.0, evaluator.evaluate("3+4*3"), "Ошибка при проверке приоритета операторов");
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(Exception.class, () -> evaluator.evaluate("3/0"));
        assertTrue(exception.getMessage().contains("Деление на ноль"));
    }

    @Test
    void testUnknownOperator() {
        Exception exception = assertThrows(Exception.class, () -> evaluator.evaluate("3%4"));
        assertTrue(exception.getMessage().contains("Неизвестный оператор"));
    }

    @Test
    void testVariables() throws Exception {
        evaluator.setVariable("x", 10.0);
        evaluator.setVariable("y", 20.0);
        assertEquals(30.0, evaluator.evaluate("x+y"), "Ошибка при использовании переменных");
    }

    @Test
    void testUnknownVariable() {
        Exception exception = assertThrows(Exception.class, () -> evaluator.evaluate("z"));
        assertTrue(exception.getMessage().contains("Неизвестная переменная"));
    }
}
