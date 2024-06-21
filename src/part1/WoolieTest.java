
package part1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WoolieTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testRun() throws InterruptedException {
        Woolie woolie = new Woolie("PERO", 5, Woolie.City.COURTWALD, Woolie.City.GLASSDELL);
        Thread t = new Thread(woolie);

        t.start();
        t.join(); // Wait for the thread to complete

        // Define the expected output
        String expectedOutput = "PERO has arrived at the bridge at Courtwald.\n" +
                "PERO is starting to cross.\n" +
                "\tPERO: 1 second.\n" +
                "\tPERO: 2 seconds.\n" +
                "\tPERO: 3 seconds.\n" +
                "\tPERO: 4 seconds.\n" +
                "\tPERO: 5 seconds.\n" +
                "PERO arrives at Glassdell.\n";

        String actualOutput = outContent.toString().replaceAll("\r\n", "\n");

        // Trim both outputs to ignore trailing whitespaces and compare
        assertEquals(expectedOutput.trim(), actualOutput.toString().trim());
    }
}
