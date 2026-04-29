package jonash.group.packageone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Utilities {

    static String readFile(String fileName){
        File fi = new File(fileName);
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(fi.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(fileContent);
    }

    static void writeContentToFileToResourceFolder(String content,String filename) {
        File file = new File("./src/main/resources/" + filename);
        try (FileWriter fr = new FileWriter(file)) {
            try {
                fr.write(content);
            } catch (IOException e) {
                //e.printStackTrace();
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
