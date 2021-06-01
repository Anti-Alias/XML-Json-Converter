# Address Book XML/JSON Converter

This is a CLI application that converts Address Book XML to JSON and back.
Format is: ```java -jar <jarfile> <input-file-name> <output-file-name> <destination-format>``` where
* **jarfile** is the name of the jar file.
* **input-file-name** is the name of the input file.
* **input-file-name** is the name of the output file.
* **destination-format** is the format of the output file (xml or json).

Note: If **destination-format** is "xml", the assumed input format is "json", and if **destination-format** is "json", the assumed input format is "xml".

## To build
Run command to build: ```./gradlew shadowJar```

## To convert XML file to JSON
Run the command: ```java -jar build/libs/xml-json-converter-all.jar <input-file-name> <output-file-name> json```

For example: ```java -jar build/libs/xml-json-converter-all.jar ab.xml ab.json json```

## To convert JSON file to XML
Run the command: ```java -jar build/libs/xml-json-converter-all.jar <input-file-name> <output-file-name> xml```

For example: ```java -jar build/libs/xml-json-converter-all.jar ab.json ab-new.xml xml```
