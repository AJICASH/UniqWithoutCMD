package org.example;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
//    static UniqString uStr;

    @Option(name = "-i", usage = "Flag -i says that register doesn't matter")
    private boolean iFlag;
    //TODO: классы оберты боксинг анбоксин
    @Option(name = "-u", usage = "Flag -u says that only unique strings should be written")

    private boolean uFlag;
    @Option(name = "-s", usage = "the -s flag means that when detecting lines, the first N" +
            " should be ignored characters of each line.")

    private boolean sFlag;
    @Option(name = "-c", usage = "Flag -c says tshat before strings that are duplicated should be written " +
            "number of repeating strings")
    private boolean cFlag;

    @Option(name = "-g", usage = "name of output file")//TODO: fix
    private String inputFile;
    @Option(name = "-o", usage = "name of output file")
    private String outputFile;
    public static void main(String[] args) throws IOException, CmdLineException {
//        new Uniqttt().doMain(args);

        String[] strArgs = {"-u"};
//     new Main().parseArguments(args);
        new Main().parseArguments(strArgs);


//        System.out.printf(uStr.isiFlag()?"true":"false");


//        uStr = new UniqString(false, false, false, false, "input/intest1", "output/outtest1");
//        UniqString uStr = new UniqString(iFlag, uFlag, sFlag, cFlag, inputFile, outputFile);

//         uStr.parseObj();
    }

    private  void parseArguments(String[] args) throws IOException, CmdLineException {
//        CmdLineParser parser = new CmdLineParser(this);
//        CmdLineParser parser = new CmdLineParser(UniqString.class);
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.print("invalid input - ");
            System.err.println(e.getMessage());
            throw e;
        }
        System.out.printf(uFlag?"true":"false");

//        UniqString uStr = new UniqString(iFlag, uFlag, sFlag, cFlag, inputFile, outputFile);

//        uStr.transform();

    }


}

