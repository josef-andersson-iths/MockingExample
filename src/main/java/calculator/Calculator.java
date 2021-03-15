package calculator;

import java.util.Arrays;

public class Calculator {

    public static void main(String[] args) {
        System.out.println(add(""));
        System.out.println(add("1"));
        System.out.println(add("10,20"));
        System.out.println(add("10\n20,30"));
        System.out.println(add("1,2\n3,4"));
    }

    static int add(String numbers) {
        if (numbers.length() == 0)
            return 0;
        return Arrays.stream(numbers.split("[,\n]")).mapToInt(Integer::parseInt).reduce(Integer::sum).orElse(0);
    }

}
