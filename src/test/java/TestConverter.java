import org.junit.jupiter.api.Test;

import java.io.*;

public class TestConverter {

    @Test
    public void testConvertXMLToJson() throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try(Reader input = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("ab.xml"))) {
            try(Writer output = new OutputStreamWriter(bytes)) {
                Converter.convert(input, output, "json");
                // TODO: Code that validates output is correct
            }
        }
    }
}
