package Arrays.path_finder_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PathFinderOneTest {

    @Test
    public void sampleTests() {

        String a = ".W.\n"+
                ".W.\n"+
                "...",

                b = ".W.\n"+
                        ".W.\n"+
                        "W..",

                c = "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        "......",

                d = "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        ".....W\n"+
                        "....W.";

        assertTrue(PathFinderOne.pathFinder(a));
        assertFalse(PathFinderOne.pathFinder(b));
        assertTrue(PathFinderOne.pathFinder(c));
        assertFalse(PathFinderOne.pathFinder(d));
    }

}
