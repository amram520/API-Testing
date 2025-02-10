package org.matcher;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import lombok.SneakyThrows;
import org.assertj.core.api.Fail;

import java.io.File;
import java.io.InputStream;
import java.util.Set;

import static org.matcher.JsonValidator.inputStreamFromClasspath;

public class SchemaValidator {
    @SneakyThrows
    public static void schemaValidate(String response, String payloadName) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonResponse = mapper.readTree(response);

        // Load the JSON schema
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);


        InputStream schemaStream = inputStreamFromClasspath("payload" + File.separator + payloadName + ".json");
        JsonNode json = mapper.readTree(response);
        // get schema from the schemaStream and store it into JsonSchema
        JsonSchema schema = schemaFactory.getSchema(schemaStream);

        // create set of validation message and store result in it
        Set<ValidationMessage> validationResult = schema.validate(json);

        // show the validation errors
        if (validationResult.isEmpty()) {
            // show custom message if there is no validation error
            System.out.println("There is no validation errors");

        } else {
            // show all the validation error
            validationResult.forEach(vm -> System.out.println(vm.getMessage()));
            Fail.fail("the response doesn't match the schema");
        }
    }

    @SneakyThrows
    public void validate(String response, String payloadName){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response);
//        InputStream schemaStream = inputStreamFromClasspath("payload" + File.separator + payloadName + ".json");
//        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);
        JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(getClass().getResourceAsStream("petSchema.json"));
        Set<ValidationMessage> validationResult = schema.validate(json);
        if (validationResult.isEmpty()) {
            // show custom message if there is no validation error
            System.out.println("There is no validation errors");

        } else {
            // show all the validation error
            validationResult.forEach(vm -> System.out.println(vm.getMessage()));
            Fail.fail("the response doesn't match the schema");
        }


    }
}
