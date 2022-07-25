package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class A_13_12_ComputeASalaryThreshold {
    public static double findSalaryCup(List<Integer> currentSalaries, int targetSalary) {
        currentSalaries.sort((a, b) -> Integer.compare(b, a));
        double currentBudget = currentSalaries.stream().collect(Collectors.summingInt(Integer::intValue));
        double delta = currentBudget - targetSalary;
        int i = 1;
        double currentDelta = 0;
        double s = 0;
        while (i - 1 < currentSalaries.size() && currentDelta < delta)
        {
            currentDelta = 0;
            s += currentSalaries.get(i-1);
            for (int j = 0; j < i; ++j) {
                currentDelta += (currentSalaries.get(j) - currentSalaries.get(i));
            }
            i++;
        }

        return (s - delta)/(i-1);
    }

    public static double findSalaryCupV2(List<Integer> currentSalaries, int targetPayroll ) {
        Collections.sort(currentSalaries);
        int unadjustedSalaries = 0;
        for(int i = 0; i < currentSalaries.size(); ++i) {
            int adjustedPeople = currentSalaries.size() - i;
            if (unadjustedSalaries + currentSalaries.get(i) * (adjustedPeople) >= targetPayroll) {
                return (targetPayroll - unadjustedSalaries) / adjustedPeople;
            }
            unadjustedSalaries += currentSalaries.get(i);
        }
        return -1.0;
    }

    public static void main(String[] main) {
        List<Integer> salaries = new ArrayList<>();
        salaries.add(90);
        salaries.add(30);
        salaries.add(100);
        salaries.add(40);
        salaries.add(20);

        System.out.println(findSalaryCupV2(salaries, 210));
    }
}
