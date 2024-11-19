import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static void main(String[] args) throws IOException {

        // file chooser stuff
        File workingDirectory = new File(System.getProperty("user.dir"));
        File jfcFile = new File(workingDirectory.getPath() + "\\src\\PersonTestData.txt");
        JFileChooser jfc = new JFileChooser(jfcFile, FileSystemView.getFileSystemView());
        jfc.showOpenDialog(null);

        System.out.println(jfc.getSelectedFile().getName());

        Scanner ln = new Scanner(System.in);
        String tag = SafeInput.getNonZeroLenString(ln, "Enter the tag to find. ");
        int tag_length = tag.length();

        String file_contents = new String(Files.readAllBytes(Paths.get(jfc.getSelectedFile().getAbsolutePath())));

        String[] content = file_contents.split("\\b" + tag + "\\b");

        System.out.println(content.length-1);

    }
}