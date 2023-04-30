import org.example.UniqWithoutCMD;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UniqWithoutCMDTest {
    UniqWithoutCMD file;

    @Test
    void taskSort() throws IOException {
        //при -i
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("HeLLo!", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!", "aaAAAAaad", "ALLA"), file.taskSort(file));
    }
    @Test
    void taskSort111() throws IOException {
        //при -u
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("Hello!", "HeLLo!", "abcder", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "aaAAAAaad"), file.taskSort(file));
    }
    @Test
    void taskSort2() throws IOException {
        //при -i -u
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("abcde", "arfgd", "arfga", "aeaea", "aaaaa", "aaAAAAaad"), file.taskSort(file));
    }
    @Test
    void taskSort3() throws IOException {
        //при -c
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("Hello!", "HeLLo!", "abcder", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "2 Goodbye!", "aaAAAAaad", "2 ALLA"), file.taskSort(file));
    }
    @Test
    void taskSort4() throws IOException {
        //при -i -c
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("2 HeLLo!", "2 ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "2 Goodbye!", "aaAAAAaad", "2 ALLA"), file.taskSort(file));
    }
    @Test
    void taskSort5() throws IOException {
        //при -s
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("lo!", "Lo!", "der", "DER", "de", "gd", "ga", "ea", "aa", "dbye!", "AAAaad", "A"), file.taskSort(file));
    }
    @Test
    void taskSort6() throws IOException {
        //при -s -i
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("Lo!","DER", "de", "gd", "ga", "ea", "aa", "dbye!", "AAAaad", "AH"), file.taskSort(file));
    }
    @Test
    void taskSort7() throws IOException {
        //при -s -i -u
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("de", "gd", "ga", "ea", "aa", "AAAaad"), file.taskSort(file));
    }
    @Test
    void taskSort8() throws IOException {
        //при -s -i -c
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("2 Lo!", "2 DER", "de", "gd", "ga", "ea", "aa","2 dbye!", "AAAaad", "2 A"), file.taskSort(file));
    }
}