

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author
 * @date 2020/10/27 23:06
 */
public class HttpClientServer {
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8801/");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity= httpResponse.getEntity();
        String result = "";
        if (httpEntity != null) {
            result = EntityUtils.toString(httpEntity,"utf-8");
        }
        httpGet.releaseConnection();
        System.out.println(result);
    }
}
