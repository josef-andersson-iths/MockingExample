package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @DisplayName("Adds numbers")
    @Test
    void addStep1() {
        assertEquals(0, calc.add(""));
        assertEquals(1, calc.add("1"));
        assertEquals(3, calc.add("1,2"));
    }

    @DisplayName("Handles unknown amount of numbers")
    @Test
    void addStep2() {
        assertEquals(15, calc.add("1,2,3,4,5"));
    }

    @DisplayName("Handles newlines")
    @Test
    void addStep3() {
        assertEquals(60, calc.add("10\n20,30"));
    }

    @DisplayName("Handles custom delimiters")
    @Test
    void addStep4() {
        assertEquals(30, calc.add("//;\n10;20"));
    }

    @DisplayName("Throws an exception on negative numbers")
    @Test
    void addStep5() {
        assertThrows(RuntimeException.class, () -> calc.add("1,2\n3,-4,-5"));
    }

    @DisplayName("Ignores numbers greater than 1000")
    @Test
    void addStep6() {
        assertEquals(6, calc.add("1,2\n3,1001"));
    }

    @DisplayName("Handles custom delimiters of any length")
    @Test
    void addStep7() {
        assertEquals(30, calc.add("//;;;\n10;;;20"));
        assertEquals(50, calc.add("//+++++\n20+++++30"));
    }

    @DisplayName("Handles multiple custom delimiters")
    @Test
    void addStep8() {
        assertEquals(12, calc.add("//[;][+]\n3+4;5"));
    }

    @DisplayName("Handles multiple custom delimiters of any lengths")
    @Test
    void addStep9() {
        assertEquals(15, calc.add("//[;;][++]\n4++5;;6"));
        assertEquals(15, calc.add("//[;;][+++]\n4;;5+++6"));
    }
}
