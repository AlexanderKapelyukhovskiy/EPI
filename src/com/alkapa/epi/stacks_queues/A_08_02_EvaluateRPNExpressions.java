package com.alkapa.epi.stacks_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class A_08_02_EvaluateRPNExpressions {
    static final String DELIMITER = ",";
    static final Map<String, ToIntBiFunction<Integer, Integer>> OPERATORS = Map.of(
            "+", (y,x) -> x+y,
            "-", (y,x) -> x-y,
            "*", (y,x) -> x*y,
            "/", (y,x) -> x/y
    );
    public static int evaluate(String expression) {
        Deque<Integer> intermediateResults = new ArrayDeque<Integer>();

        for(String token : expression.split(DELIMITER)) {
            if (OPERATORS.get(token) != null) {
                intermediateResults.addFirst(
                        OPERATORS.get(token)
                                .applyAsInt(
                                        intermediateResults.removeFirst(),
                                        intermediateResults.removeFirst()));
            } else {
                intermediateResults.addFirst(Integer.parseInt(token));
            }
        }
        return intermediateResults.removeFirst();
    }

    public static void test(String expression) {
        int val = evaluate(expression);
        System.out.println(String.format("%s -> %d", expression, val));
    }

    public static void main(String[] args) {
        test("3,5,+");
        test("3,4,+,2,*,1,+");
    }
}
