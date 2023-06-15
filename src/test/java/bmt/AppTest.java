package bmt;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testAddition() {
        String input = "5\n3\n1\n";
        String expectedOutput = "Hasil: 8.0\n";
        testAppWithInput(input, expectedOutput);
    }

    @Test
    public void testSubtraction() {
        String input = "8\n4\n2\n";
        String expectedOutput = "Hasil: 4.0\n";
        testAppWithInput(input, expectedOutput);
    }

    @Test
    public void testMultiplication() {
        String input = "6\n2\n3\n";
        String expectedOutput = "Hasil: 12.0\n";
        testAppWithInput(input, expectedOutput);
    }

    @Test
    public void testDivision() {
        String input = "10\n5\n4\n";
        String expectedOutput = "Hasil: 2.0\n";
        testAppWithInput(input, expectedOutput);
    }
}
