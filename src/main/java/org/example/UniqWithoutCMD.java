package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UniqWithoutCMD {
    private String InputFile;
    private String OutputFile;
    public UniqWithoutCMD(String InputFile, String OutputFile) {
        this.InputFile = InputFile;
        this.OutputFile = OutputFile;
    }
    public List<String> infileread() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(InputFile));
        return lines;
    }
    public List<String> outfileread() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(OutputFile));
        return lines;
    }

    public List<String> taskSort(UniqWithoutCMD file) throws IOException {
        Path outfile = Paths.get(OutputFile);
        List<String> lines = Files.readAllLines(Paths.get(InputFile));
        List<String> result = new ArrayList<String>();
        Boolean eq;
        Uniq iFlagFromUniq = new Uniq();
        Uniq uFlagFromUniq = new Uniq();
        Uniq cFlagFromUniq = new Uniq();
        Uniq numFromUniq = new Uniq();
        Boolean uFlagEq;
        Boolean stay = true;
        int counter = 1;
        for (int i = 1; i < lines.size(); i++){
            System.out.println(i);
            // -i flag beginning
            if (iFlagFromUniq.iflag()){
                eq = lines.get(i).equalsIgnoreCase(lines.get(i - 1));
                if(eq){
                    counter++;
                }
                else {
                    counter = 1;
                }
                if (i != lines.size() - 1){
                    uFlagEq = !lines.get(i).equalsIgnoreCase(lines.get(i - 1)) && !lines.get(i).equalsIgnoreCase(lines.get(i + 1));
                }
                else {
                    uFlagEq = !lines.get(i).equalsIgnoreCase(lines.get(i - 1));
                }

            }
            else{
                eq = lines.get(i).equals(lines.get(i - 1));
                if(eq){
                    counter++;
                }
                else {
                    counter = 1;
                }
                if (i == 1 && !eq){
                    result.add(lines.get(i - 1));
                }
                if (i != lines.size() - 1) {
                    uFlagEq = !lines.get(i).equals(lines.get(i - 1)) && !lines.get(i).equals(lines.get(i + 1));
                }
                else{
                    uFlagEq = !lines.get(i).equals(lines.get(i - 1));
                }
            }
            // -i flag ending
            // -u flag beginning
            if (uFlagFromUniq.uflag()){
                if(i == 1 && !eq){
                result.add(lines.get(i - 1));
            }
                if (uFlagEq){
                    result.add(lines.get(i));
                }
            }
            // -u flag ending
            else{
                // -c flag beginning
                if (cFlagFromUniq.cflag()){
                    if (i != lines.size() - 1){
                        System.out.println(result);
                        System.out.println(i);
                        if (iFlagFromUniq.iflag()){
                            if (!lines.get(i + 1).equalsIgnoreCase(lines.get(i)) && counter!= 1){
                                result.add(counter + " " + lines.get(i));
                            } else {
                                if (!lines.get(i + 1).equalsIgnoreCase(lines.get(i))){
                                    result.add(lines.get(i));
                                }
                            }
                        }
                        else {
                            if (!lines.get(i + 1).equals(lines.get(i)) && counter!= 1){
                                result.add(counter + " " + lines.get(i));
                            } else {
                                if (!lines.get(i + 1).equals(lines.get(i))){
                                    result.add(lines.get(i));
                                }
                            }
                        }

                    }
                    else {
                        if(eq){
                            result.add(counter + " " + lines.get(i));
                        } else {
                            result.add(lines.get(i));
                        }
                    }



                }
                else {
                    if (!eq){
                        result.add(lines.get(i - 1));
                    }
                    if (eq && i == lines.size() - 1) {
                        result.add(lines.get(i));
                    }
                }

            }

        }
        Files.write(outfile, result, StandardCharsets.UTF_8);
        return outfileread();
    }
}
