import java.io.*;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


class App {
    public static void main(String[] args) throws Exception {
        try {
            start(args);
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void start(String[] args) throws IOException {

        // Checks/massages arguments
        if (args.length != 3)
            throw new IllegalArgumentException("Invalid number of CLI arguments. Expected 3 <source-file-name> <dest-file-name> <dest-format>");
        File sourceFile = new File(args[0]);
        File destFile = new File(args[1]);
        String destFormat = args[2].toLowerCase();
        validateArgs(sourceFile, destFile, destFormat);

        // Does conversion
        Converter.convert(sourceFile, destFile, destFormat);
    }

    private static void validateArgs(File sourceFile, File destFile, String destinationFormat) {
        if(!sourceFile.exists())
            throw new IllegalArgumentException("Could not find file '" + sourceFile.getName() + "'");
        if(!destinationFormat.equals("json") && !destinationFormat.equals("xml"))
            throw new IllegalArgumentException("Invalid destination format '" + destinationFormat + "'. Expected xml or json.");
    }
}
