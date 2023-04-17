import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UniqWithoutCMDTest {
    UniqWithoutCMD file;
    @Test
    void UniqWithoutCMDTest() throws IOException {
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("Hello!", "abc", "abc", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!", "Goodbye!"), file.infileread());
    }
    @Test
    void taskSort() throws IOException {
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("Hello!", "abc", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!"), file.taskSort(file));
    }
}