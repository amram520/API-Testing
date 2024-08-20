package payloadRepo;

import org.json.JSONObject;
import utils.ResourceUtils;

import java.io.File;

public class PayloadRepository {

    public static String getPayloadAsString(String payloadName){
        return ResourceUtils.resourceToString("payload" + File.separator + payloadName + ".json");
    }

    public static JSONObject getPayloadAsJsonObject(String payloadName){
        return new JSONObject(getPayloadAsString(payloadName));
    }


}
