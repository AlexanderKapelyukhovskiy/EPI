package com.alkapa.epi.A_08_stacks_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class A_08_03_IsStringWellFormed {
    static final Map<Character, Character> ClosingParenthesis = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public static boolean isWellFormed(String expression) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i < expression.length(); ++i) {
            Character ch = expression.charAt(i);
            Character closing = ClosingParenthesis.get(ch);

            if (closing == null) {
                stack.push(ch);
            } else {
                if (closing != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void test(String expression) {
        boolean wellFormed = isWellFormed(expression);
        System.out.println(String.format("%s -> %b", expression, wellFormed));
    }

    public static void main(String[] args) {
        test("([]){()}");
        test("[()[]{()()}]");
        test("{)");
        test("{(})");
        test("([]){()");
        test("[()[]{()()");
    }
}
