package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileReaderHelper {

    public static String contentOfFile(String path) throws IOException {
        return FileUtils.readFileToString( new File( path ) );
    }

    public static String mayBeUnder(String dir) {
        return dir;
    }

    public static String contentOfFile(String path, String dir) throws IOException {
        try {
            return contentOfFile(path);
        } catch (IOException e) {
            return contentOfFile(dir + path);
        }
    }
}
