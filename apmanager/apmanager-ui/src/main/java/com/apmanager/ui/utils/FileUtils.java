package com.apmanager.ui.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static List<String> readString(String path) throws FileNotFoundException, IOException {
        
        List<String> string = new ArrayList<>();
        
        if (!path.startsWith("/") && !path.toLowerCase().startsWith("c")
                || !path.toLowerCase().startsWith("d")
                || !path.toLowerCase().startsWith("e")
                || !path.toLowerCase().startsWith("f")) {
            try {
                path = new File(".").getCanonicalPath()
                        + System.getProperty("file.separator") + path;
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }

        }
        
        FileReader file = new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        String s;
        while ((s = reader.readLine()) != null) {
            string.add(s);
        }

        return string;
    }

    public static String readText(String path) throws FileNotFoundException, FileNotFoundException, IOException, IOException {
        List<String> txt = readString(path);
        StringBuilder b = new StringBuilder();
        for (String s : txt) {
            b.append(s).append("\n");
        }
        return b.toString();
    }

    public static void copyFile(String original, String target) {
        copyFile(new File(original), new File(target));
    }

    public static void copyFile(File original, File target) {

        try {
            InputStream in = new FileInputStream(original);

            OutputStream out = new FileOutputStream(target);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            log.info("Coping file:{}", original.getCanonicalPath());
            log.info("to:{}", target.getCanonicalPath());

        } catch (FileNotFoundException ex) {
            log.error(ex.getMessage(), ex);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void writeToFile(File file, String text) throws FileNotFoundException, IOException {
        OutputStream w = new FileOutputStream(file);

        w.write(text.getBytes());
        w.close();
    }
    
    public static Properties loadProperties(String path) throws IOException, IOException{
        Properties p = new Properties();
        p.load(new FileReader(path));
        return p;
    }
}