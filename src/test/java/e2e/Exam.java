package e2e;


import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

import static payloadRepo.PayloadRepository.getPayloadAsJsonObject;


public class Exam {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    final OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
//        JSONObject userPayload = getPayloadAsJsonObject("players");
        JSONObject userPayload = getPayloadAsJsonObject("players");
        String s = userPayload.toString();
        RequestBody body = RequestBody.create(JSON, s);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }
}
