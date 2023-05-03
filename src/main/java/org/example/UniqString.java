package org.example;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UniqString {
//    @Option(name = "-i", usage = "Flag -i says that register doesn't matter")
    private boolean iFlag;
    //TODO: классы оберты боксинг анбоксин
//    @Option(name = "-u", usage = "Flag -u says that only unique strings should be written")

    private boolean uFlag;
//    @Option(name = "-s", usage = "the -s flag means that when detecting lines, the first N" +
//            " should be ignored characters of each line.")

    private boolean sFlag;
//    private int sNum;
//    @Option(name = "-c", usage = "Flag -c says tshat before strings that are duplicated should be written " +
//            "number of repeating strings")
    private boolean cFlag;

//    @Option(name = "-g", usage = "name of output file")//TODO: fix
    private String inputFile;
//    @Option(name = "-o", usage = "name of output file")
    private String outputFile;

    public UniqString(boolean iFlag, boolean uFlag, boolean sFlag, boolean cFlag, String inputFile, String outputFile) {
        this.iFlag = iFlag;
        this.uFlag = uFlag;
        this.sFlag = sFlag;
        this.cFlag = cFlag;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public boolean isiFlag() {
        return iFlag;
    }

    public void setiFlag(boolean iFlag) {
        this.iFlag = iFlag;
    }

    public boolean isuFlag() {
        return uFlag;
    }

    public void setuFlag(boolean uFlag) {
        this.uFlag = uFlag;
    }

    public boolean issFlag() {
        return sFlag;
    }

    public void setsFlag(boolean sFlag) {
        this.sFlag = sFlag;
    }

    public boolean iscFlag() {
        return cFlag;
    }

    public void setcFlag(boolean cFlag) {
        this.cFlag = cFlag;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }


    public void transform() throws IOException {
        Path outfile = Paths.get(outputFile);
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        List<String> result = new ArrayList<String>();
        boolean eq;
//        Uniqttt flagFromUniq = new Uniqttt();
//
//        Uniqttt num = new Uniqttt();
//        Integer n = num.returnNum();
        int n = 3;
        boolean uFlagEq;
        int counter = 1;
        if (flagFromUniq.sflag()) {
            for (int i = 0; i < lines.size(); i++) {
                lines.set(i, lines.get(i).substring(n));
            }
        }
        for (int i = 1; i < lines.size(); i++) {
            // -i flag beginning
            if (flagFromUniq.iflag()) {
                eq = lines.get(i).equalsIgnoreCase(lines.get(i - 1));
                if (eq) {
                    counter++;
                } else {
                    counter = 1;
                }
                if (i != lines.size() - 1) {
                    uFlagEq = !lines.get(i).equalsIgnoreCase(lines.get(i - 1)) && !lines.get(i).equalsIgnoreCase(lines.get(i + 1));
                } else {
                    uFlagEq = !lines.get(i).equalsIgnoreCase(lines.get(i - 1));
                }

            } else {
                eq = lines.get(i).equals(lines.get(i - 1));
                if (eq) {
                    counter++;
                } else {
                    counter = 1;
                }
                if (flagFromUniq.cflag()) {
                    if (i == 1 && !eq) {
                        result.add(lines.get(i - 1));
                    }
                }


                if (i != lines.size() - 1) {
                    uFlagEq = !lines.get(i).equals(lines.get(i - 1)) && !lines.get(i).equals(lines.get(i + 1));
                } else {
                    uFlagEq = !lines.get(i).equals(lines.get(i - 1));
                }
            }
            // -i flag ending
            // -u flag beginning
            if (flagFromUniq.uflag()) {
                if (i == 1 && !eq) {
                    result.add(lines.get(i - 1));
                }
                if (uFlagEq) {
                    result.add(lines.get(i));
                }
            }
            // -u flag ending
            else {
                // -c flag beginning
                if (flagFromUniq.cflag()) {
                    if (i != lines.size() - 1) {
                        System.out.println(result);
                        System.out.println(i);
                        if (flagFromUniq.iflag()) {
                            if (!lines.get(i + 1).equalsIgnoreCase(lines.get(i)) && counter != 1) {
                                result.add(counter + " " + lines.get(i));
                            } else {
                                if (!lines.get(i + 1).equalsIgnoreCase(lines.get(i))) {
                                    result.add(lines.get(i));
                                }
                            }
                        } else {
                            if (!lines.get(i + 1).equals(lines.get(i)) && counter != 1) {
                                result.add(counter + " " + lines.get(i));
                            } else {
                                if (!lines.get(i + 1).equals(lines.get(i))) {
                                    result.add(lines.get(i));
                                }
                            }
                        }

                    } else {
                        if (eq) {
                            result.add(counter + " " + lines.get(i));
                        } else {
                            result.add(lines.get(i));
                        }
                    }
                } else {
                    if (!eq) {
                        result.add(lines.get(i - 1));
                    }
                    if (eq && i == lines.size() - 1) {
                        result.add(lines.get(i));
                    }
                }


            }

        }
        Files.write(outfile, result, StandardCharsets.UTF_8);
//        return outfileread();

    }
}
