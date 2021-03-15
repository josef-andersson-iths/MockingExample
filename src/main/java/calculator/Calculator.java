package calculator;

import java.util.Arrays;

public class Calculator {

    public static void main(String[] args) {
        System.out.println(add(""));
        System.out.println(add("1"));
        System.out.println(add("//;\n10;20"));
        System.out.println(add("10\n20,30"));
        System.out.println(add("1,2\n3,4,5"));
        // System.out.println(add("1,2\n3,-4,-5"));
        System.out.println(add("1,2\n3,4000"));
    }

    static int add(String numbers) {
        if (numbers.length() == 0) return 0;

        String[] split;
        if (numbers.matches("\\A//.+\n.*")) {
            split = numbers.split("\n", 2);
            split = split[1].split(split[0].substring(2));
        } else split = numbers.split("[,\n]");

        int sum = 0;
        StringBuilder errors = new StringBuilder();
        for (String s : split) {
            int n = Integer.parseInt(s);
            if (n < 0)         errors.append(n).append(", ");
            else if (n <= 1000) sum += n;
        }

        if (0 < errors.length()) throw new RuntimeException("negatives not allowed: " + errors.substring(0, errors.length() - 2));
        else                     return sum;
    }

}
