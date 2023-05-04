package org.example;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class Main {
    @Option(name = "-i", usage = "Flag -i says that register doesn't matter")
    private boolean iFlag;
    //TODO: классы оберты боксинг анбоксин
    @Option(name = "-u", usage = "Flag -u says that only unique strings should be written" , forbids={"-c"})

    private boolean uFlag;
    @Option(name = "-s", usage = "the -s flag means that when detecting lines, the first N" +
            " should be ignored characters of each line.")
    private int sNum;
    @Option(name = "-c", usage = "Flag -c says tshat before strings that are duplicated should be written " +
            "number of repeating strings",
            forbids={"-u"})
    private boolean cFlag;
    @Argument
    private String inputFile;
    @Option(name = "-o", usage = "name of output file")
    private String outputFile;
    public static void main(String[] args) throws IOException, CmdLineException {
     new Main().parseArguments(args);
//        String[] strArgs = {"-i", "-s","4", "-c","-o","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1","C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1" };
//        -i -s 4 -c -o C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\output\\outtest1 C:\\Users\\LavaLens\\IdeaProjects\\UniqWithoutCMD\\input\\intest1
//        new Main().parseArguments(strArgs);
//        test1(new ArrayList<>(Arrays.asList("ab","aa","aa","aa","ab")));
    }
    public void parseArguments(String[] args) throws IOException, CmdLineException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.print("invalid input - ");
            System.err.println(e.getMessage());
            throw e;
        }
        UniqString uStr = new UniqString(iFlag, uFlag, sNum, cFlag, inputFile, outputFile);
        uStr.transform();
    }
}

