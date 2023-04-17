import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
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
        for (int i = 1; i < lines.size(); i++){
            eq = lines.get(i).equals(lines.get(i - 1));
            if (!eq){
                result.add(lines.get(i - 1));
            }
            if (eq && i == lines.size() - 1) {
                result.add(lines.get(i));
            }
        }
        Files.write(outfile, result, StandardCharsets.UTF_8);
        return outfileread();
    }
}
