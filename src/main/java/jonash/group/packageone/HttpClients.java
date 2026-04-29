package jonash.group.packageone;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.StatusLine;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpClients {

    public String getSomeInfoFromWebsiteUsingApacheHTTPClient(String url){
        final Result result;
        try (CloseableHttpClient httpclient = org.apache.hc.client5.http.impl.classic.HttpClients.createDefault()){
            HttpGet httpget = new HttpGet(url);
            result = httpclient.execute(httpget, response -> {
                System.out.println(httpget + "->" + new StatusLine(response));
                return new Result(response.getCode(), EntityUtils.toString(response.getEntity()));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.content;

    }

    static class Result {

        final int status;
        final String content;

        Result(final int status, final String content) {
            this.status = status;
            this.content = content;
        }

    }
}
