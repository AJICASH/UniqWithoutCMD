import org.example.Main;
import org.example.UniqString;
import org.junit.jupiter.api.Test;
import org.kohsuke.args4j.CmdLineException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniqTest {

    @Test
    void test1() throws Exception {
        String[] strArgs = {"-i", "-o","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1"};
        Main main = new Main();
        UniqString us = main.parseArguments(strArgs);
        UniqString usExpected = new UniqString(true, false, 0,false,"C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1");
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("HeLLo!", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!", "aaAAAAaad", "ALLA"));
        System.out.println(us.transform());
        System.out.println(usExpected.transform());
        System.out.println(expectedOutput);
        boolean first = usExpected.transform().equals(us.transform());
        boolean second = usExpected.transform().equals(expectedOutput);
        System.out.println(first);
        System.out.println(second);
        assertTrue(first == second && first == true);    }
    @Test
    void test2() throws Exception {
        String[] strArgs = {"-i","-s", "3","-c", "-o","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1"};
        Main main = new Main();
        UniqString us = main.parseArguments(strArgs);
        UniqString usExpected = new UniqString(true, false, 3,true,"C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1");
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("2HeLLo!", "2ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "2Goodbye!", "aaAAAAaad", "2ALLA"));
        System.out.println(us.transform());
        System.out.println(usExpected.transform());
        System.out.println(expectedOutput);
        boolean first = usExpected.transform().equals(us.transform());
        boolean second = usExpected.transform().equals(expectedOutput);
        System.out.println(first);
        System.out.println(second);
        assertTrue(first == second && first == true);
    }
    @Test
    void test3() throws Exception {
        String[] strArgs = {"-i","-s", "3","-u", "-o","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1"};
        Main main = new Main();
        UniqString us = main.parseArguments(strArgs);
        UniqString usExpected = new UniqString(true, true, 3,false,"C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1");
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("HeLLo!", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!", "aaAAAAaad", "ALLA"));
        System.out.println(us.transform());
        System.out.println(usExpected.transform());
        System.out.println(expectedOutput);
        boolean first = usExpected.transform().equals(us.transform());
        boolean second = usExpected.transform().equals(expectedOutput);
        System.out.println(first);
        System.out.println(second);
        assertTrue(first == second && first == true);
    }
    @Test
    void test4() throws Exception {
        String[] strArgs = {"-i","-s", "3","-c","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1"};
        Main main = new Main();
        UniqString us = main.parseArguments(strArgs);
        UniqString usExpected = new UniqString(true, false, 3,true,"C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1");
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("2HeLLo!", "2ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "2Goodbye!", "aaAAAAaad", "2ALLA"));
        System.out.println("us trans " + us.transform());
        System.out.println("usEx trans " + usExpected.transform());
        System.out.println("exp " + expectedOutput);
        boolean first = usExpected.transform().equals(us.transform());
        boolean second = usExpected.transform().equals(expectedOutput);
        System.out.println(first);
        System.out.println(second);
        assertTrue(first == second && first == true);
    }
    @Test
    void test5() throws Exception {
        String[] strArgs = { "-o","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1"};
        Main main = new Main();
        UniqString us = main.parseArguments(strArgs);
        UniqString usExpected = new UniqString(false, false, 0,false,"C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1");
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("Hello!","HeLLo!","abcder", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!", "aaAAAAaad", "ALLA"));
        System.out.println(us.transform());
        System.out.println(usExpected.transform());
        System.out.println(expectedOutput);
        boolean first = usExpected.transform().equals(us.transform());
        boolean second = usExpected.transform().equals(expectedOutput);
        System.out.println(first);
        System.out.println(second);
        assertTrue(first == second && first == true);
    }

//    @Test
//    void test333() throws Exception {
//        String[] strArgs = {"-i", "-o","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1"};
//        Main main = new Main();
//        main.parseArguments(strArgs);
//
//        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList("HeLLo!", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "Goodbye!", "aaAAAAaad", "ALLA"));
//        String outputString = readFile("C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1");
//        ArrayList<String> output = new ArrayList<>(Arrays.asList(outputString.split("\n")));
//        assertEquals(expectedOutput, output);
//    }
//    @Test
//    void test2() throws Exception {
//        String[] strArgs = {"-i", "-c", "-s", "3", "-o","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1"};
//        Main main = new Main();
//        main.parseArguments(strArgs);
//
//        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList("2HeLLo!\n", "2ABCDER\n", "abcde\n", "arfgd\n", "aeaea\n", "aaaaa\n", "2Goodbye!\n", "aaAAAAaad\n", "2ALLA\n"));
//        String outputString = readFile("C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1");
//        System.out.println(outputString);
//        ArrayList<String> output = new ArrayList<>(Arrays.asList(outputString.split("\n")));
//        String exp = expectedOutput.toString();
//        String out = expectedOutput.toString();
//        exp.replaceAll("\n"," ");
//        out.replaceAll("\n"," ");
//        assertEquals(exp, out);
//    }
//    }
//    @Test
//    void taskSort111() throws IOException {
//        //при -u
//        file = new UniqWithoutCMDtttt("input/intest1","output/outtest1");
//        assertEquals(Arrays.asList("Hello!", "HeLLo!", "abcder", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "aaAAAAaad"), file.taskSort(file));
//    }
//    @Test
//    void taskSort2() throws IOException {
//        //при -i -u
//        file = new UniqWithoutCMDtttt("input/intest1","output/outtest1");
//        assertEquals(Arrays.asList("abcde", "arfgd", "arfga", "aeaea", "aaaaa", "aaAAAAaad"), file.taskSort(file));
//    }
//    @Test
//    void taskSort3() throws IOException {
//        //при -c
//        file = new UniqWithoutCMDtttt("input/intest1","output/outtest1");
//        assertEquals(Arrays.asList("Hello!", "HeLLo!", "abcder", "ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "2 Goodbye!", "aaAAAAaad", "2 ALLA"), file.taskSort(file));
//    }
//    @Test
//    void taskSort4() throws IOException {
//        //при -i -c
//        file = new UniqWithoutCMDtttt("input/intest1","output/outtest1");
//        assertEquals(Arrays.asList("2 HeLLo!", "2 ABCDER", "abcde", "arfgd", "arfga", "aeaea", "aaaaa", "2 Goodbye!", "aaAAAAaad", "2 ALLA"), file.taskSort(file));
//    }
//    @Test
//    void taskSort5() throws IOException {
//        //при -s
//        file = new UniqWithoutCMDtttt("input/intest1","output/outtest1");
//        assertEquals(Arrays.asList("lo!", "Lo!", "der", "DER", "de", "gd", "ga", "ea", "aa", "dbye!", "AAAaad", "A"), file.taskSort(file));
//    }
//    @Test
//    void taskSort6() throws IOException {
//        //при -s -i
//        file = new UniqWithoutCMDtttt("input/intest1","output/outtest1");
//        assertEquals(Arrays.asList("Lo!","DER", "de", "gd", "ga", "ea", "aa", "dbye!", "AAAaad", "A"), file.taskSort(file));
//    }
//    @Test
//    void taskSort7() throws IOException {
//        //при -s -i -u
//        file = new UniqWithoutCMDtttt("input/intest1","output/outtest1");
//        assertEquals(Arrays.asList("de", "gd", "ga", "ea", "aa", "AAAaad"), file.taskSort(file));
//    }
//    @Test
//    void taskSort8() throws IOException {
//        //при -s -i -c
//        file = new UniqWithoutCMDtttt("input/intest1","output/outtest1");
//        assertEquals(Arrays.asList("2 Lo!", "2 DER", "de", "gd", "ga", "ea", "aa","2 dbye!", "AAAaad", "2 A"), file.taskSort(file));
//    }
}