package e2e.tests;

import lombok.SneakyThrows;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static payloadRepo.PayloadRepository.getPayloadAsJsonObject;

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
