package bmt;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AppTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testAddition() {
        provideInput("5\n10\n1\n");
        App.main(new String[]{});
        assertEquals("Hasil: 15.0\n", testOut.toString());
    }

    @Test
    public void testSubtraction() {
        provideInput("15\n7\n2\n");
        App.main(new String[]{});
        assertEquals("Hasil: 8.0\n", testOut.toString());
    }

    @Test
    public void testMultiplication() {
        provideInput("3\n6\n3\n");
        App.main(new String[]{});
        assertEquals("Hasil: 18.0\n", testOut.toString());
    }

    @Test
    public void testDivision() {
        provideInput("20\n4\n4\n");
        App.main(new String[]{});
        assertEquals("Hasil: 5.0\n", testOut.toString());
    }

    @Test
    public void testInvalidInput() {
        provideInput("Hello\n");
        App.main(new String[]{});
        assertEquals("Input tidak valid!\n", testOut.toString());
    }

    @Test
    public void testInvalidChoice() {
        provideInput("10\n5\n5\n");
        App.main(new String[]{});
        assertEquals("Pilihan tidak valid!\n", testOut.toString());
    }
}
