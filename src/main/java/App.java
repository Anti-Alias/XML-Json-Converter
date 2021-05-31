import java.io.*;

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

    private static void start(String[] args) throws FileNotFoundException {

        // Checks/massages arguments
        if(args.length != 3)
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
        else
            throw new IllegalArgumentException("Invalid destination format '" + destinationFormat + "'");

        // Opens files
        InputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
        OutputStream output = new BufferedOutputStream(new FileOutputStream(destFile));

        // Creates object mappers
        ObjectMapper inputOM = objectMapperFor(sourceFormat);
        ObjectMapper outputOM = objectMapperFor(destinationFormat);

        // Reads from input and converts it to a POJO
        
    }

    private static ObjectMapper objectMapperFor(String format) {
        if(format.equals("xml")) {
            return new XmlMapper();
        }
        else if(format.equals("json")) {
            return new ObjectMapper();
        }
        else throw new IllegalArgumentException("Invalid format '" + format + "'");
    }

    private static void validateArgs(File sourceFile, File destFile, String destinationFormat) {
        if(!sourceFile.exists())
            throw new IllegalArgumentException("Could not find file '" + sourceFile.getName() + "'");
        if(!destinationFormat.equals("csv") && !destinationFormat.equals("xml"))
            throw new IllegalArgumentException("Invalid destination format '" + destinationFormat + "'. Expected xml or json.");
    }
}
