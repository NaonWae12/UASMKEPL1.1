package bmt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }

    @Test
    public void testSubtraction() {
        provideInput("10\n5\n2\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nHasil: 5.0\n",
                getOutput());
    }

    @Test
    public void testMultiplication() {
        provideInput("10\n5\n3\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nHasil: 50.0\n",
                getOutput());
    }

    @Test
    public void testDivision() {
        provideInput("10\n5\n4\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nHasil: 2.0\n",
                getOutput());
    }

    @Test
    public void testInvalidInput() {
        provideInput("abc\n5\n1\n");
        App.main(new String[] {});
        assertEquals("=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nInput tidak valid!\n", getOutput());
    }

    @Test
    public void testInvalidChoice() {
        provideInput("10\n5\n7\n");
        App.main(new String[] {});
        assertEquals(
                "=== Kalkulator Sederhana ===\nMasukkan angka pertama:\nMasukkan angka kedua:\nPilih operasi matematika:\nPilihan tidak valid!\n",
                getOutput());
    }
}
