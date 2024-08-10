package Tests;

import lombok.SneakyThrows;
import org.json.JSONObject;
import org.payloadRepo.PayloadRepository;
import org.testng.annotations.Test;
import org.utils.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.payloadRepo.PayloadRepository.getPayloadAsJsonObject;

public class TestJsonObject {

    @Test
    @SneakyThrows
    public void testCreateNewJson() {
        JSONObject jo = new JSONObject();
        jo.put("name", "jon doe");
        jo.put("age", "22");
        jo.put("city", "chicago");
        System.out.println(jo);
    }



    @Test
    public void testReadJson() {
        JSONObject jo = getPayloadAsJsonObject("userRequest");
        jo.put("name","Itai");
        System.out.println(jo);
    }

}
