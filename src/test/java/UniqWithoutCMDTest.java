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
    void UniqWithoutCMDTest() throws IOException {
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("Hello!", "abc", "abc", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!", "Goodbye!"), file.infileread());
    }
    // К КАЖДОМУ ТЕСТУ НАДО МЕНЯТЬ ФЛАГ ВРУЧНУЮ В Uniq.java ПОТОМУ ЧТО Я ПОКА НЕ ПОНЯЛ КАК СДЕЛАТЬ ТАК ЧТОБ КОМАНДНАЯ СТРОКА ЗАРАБОТАЛА
    @Test
    void taskSort() throws IOException {
        //при -i
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("HeLLo!", "ABC", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!", "aaAAAAaad", "ALLAH"), file.taskSort(file));
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
        assertEquals(Arrays.asList("Hello!", "HeLLo!", "abc", "ABC", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "2 Goodbye!", "aaAAAAaad", "2 ALLAH"), file.taskSort(file));
    }
    @Test
    void taskSort4() throws IOException {
        //при -i -c
        file = new UniqWithoutCMD("input/intest1","output/outtest1");
        assertEquals(Arrays.asList("2 HeLLo!", "2 ABC", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "2 Goodbye!", "aaAAAAaad", "2 ALLAH"), file.taskSort(file));
    }
}