package bmt;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;


public class AppTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach

    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }


    @AfterEach

    @After

    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }


    private String getOutput() {
        return testOut.toString();
    }

    @Test
    public void testAddition() {
        provideInput("10\n5\n1\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nHasil: 15.0\n",
                getOutput());

    @Test
    public void testAddition() {
        provideInput("5\n10\n1\n");
        App.main(new String[]{});
        assertEquals("Hasil: 15.0\n", testOut.toString());

    }

    @Test
    public void testSubtraction() {
        provideInput("10\n5\n2\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nHasil: 5.0\n",
                getOutput());
        provideInput("15\n7\n2\n");
        App.main(new String[]{});
        assertEquals("Hasil: 8.0\n", testOut.toString());

    }

    @Test
    public void testMultiplication() {
        provideInput("10\n5\n3\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nHasil: 50.0\n",
                getOutput());
        provideInput("3\n6\n3\n");
        App.main(new String[]{});
        assertEquals("Hasil: 18.0\n", testOut.toString());

    }

    @Test
    public void testDivision() {
        provideInput("10\n5\n4\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nHasil: 2.0\n",
                getOutput());

        provideInput("20\n4\n4\n");
        App.main(new String[]{});
        assertEquals("Hasil: 5.0\n", testOut.toString());

    }

    @Test
    public void testInvalidInput() {
        provideInput("abc\n5\n1\n");
        App.main(new String[] {});
        assertEquals("=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nInput tidak valid!\n", getOutput());
        provideInput("Hello\n");
        App.main(new String[]{});
        assertEquals("Input tidak valid!\n", testOut.toString());

    }

    @Test
    public void testInvalidChoice() {
        provideInput("10\n5\n7\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nPilihan tidak valid!\n",
                getOutput());

        provideInput("10\n5\n5\n");
        App.main(new String[]{});
        assertEquals("Pilihan tidak valid!\n", testOut.toString());

    }
}
