import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Converter {

    public static void convert(File sourceFile, File destFile, String destFormat) throws IOException {
        // Opens files and converts
        try(Reader input = new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8)) {
            try(Writer output = new OutputStreamWriter(new FileOutputStream(destFile), StandardCharsets.UTF_8)) {
                convert(input, output, destFormat);
            }
        }
    }

    public static void convert(Reader input, Writer output, String destFormat) throws IOException {

        // Determines source format
        String sourceFormat;
        if(destFormat.equals("xml"))
            sourceFormat = "json";
        else if(destFormat.equals("json"))
            sourceFormat = "xml";
        else
            throw new IllegalArgumentException("Invalid destination format '" + destFormat + "'");

        // Creates object mappers
        ObjectMapper inputMapper = objectMapperFor(sourceFormat);
        ObjectMapper outputMapper = objectMapperFor(destFormat);

        // Reads from input and converts it to a POJO
        AddressBook book = inputMapper.readValue(input, AddressBook.class);
        outputMapper.writerWithDefaultPrettyPrinter().writeValue(output, book);
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
}
