import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;


class App {
    public static void main(String[] args) throws Exception {
        try {
            start(args);
        }
        catch(RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void start(String[] args) throws FileNotFoundException {

        // Checks/massages arguments
        if(args.length != 2)
            throw new IllegalArgumentException("Invalid number of CLI arguments. Expected 3 <source-file-name> <dest-file-name> <dest-format>");
        File sourceFile = new File(args[0]);
        File destFile = new File(args[1]);
        String destinationFormat = args[2].toLowerCase();
        validateArgs(sourceFile, destFile, destinationFormat);

        // Determines source / dest formats
        String sourceFormat;
        if(destinationFormat.equals("xml"))
            sourceFormat = "json";
        else if(destinationFormat.equals("json"))
            sourceFormat = "xml";

        // Opens files
        InputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
        OutputStream output = new BufferedOutputStream(new FileOutputStream(destFile));

        
    }

    private static ObjectMapper objectMapperFor(String format) {
        throw new RuntimeException("TODO");
    }

    private static void validateArgs(File sourceFile, File destFile, String destinationFormat) {
        if(!sourceFile.exists())
            throw new IllegalArgumentException("Could not find file '" + sourceFile.getName() + "'");
        if(!destinationFormat.equals("csv") && !destinationFormat.equals("xml"))
            throw new IllegalArgumentException("Invalid destination format '" + destinationFormat + "'. Expected xml or json.");
    }
}
