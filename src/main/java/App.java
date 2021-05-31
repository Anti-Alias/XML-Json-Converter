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

        // Opens files and converts
        try(Reader input = new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8)) {
            try(Writer output = new OutputStreamWriter(new FileOutputStream(destFile), StandardCharsets.UTF_8)) {
                convert(input, output, sourceFormat, destinationFormat);
            }
        }
    }

    private static void convert(Reader input, Writer output, String sourceFormat, String destinationFormat) throws IOException {

        // Creates object mappers
        ObjectMapper inputMapper = objectMapperFor(sourceFormat);
        ObjectMapper outputMapper = objectMapperFor(destinationFormat);

        // Reads from input and converts it to a POJO
        AddressBook book = inputMapper.readValue(input, AddressBook.class);
        System.out.println(book);
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
        if(!destinationFormat.equals("json") && !destinationFormat.equals("xml"))
            throw new IllegalArgumentException("Invalid destination format '" + destinationFormat + "'. Expected xml or json.");
    }
}
