package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class VKTest {
    private static final String LINK = "https://api.vk.com/method/wall.";
    private static final String OWNER_ID = "70178554";
    private static final String ACCESS_TOKEN = "5c6e752fd15faebd0a4f29246a7266b8d9866d52097ff033e519810eaf1a74b1d6844eaeb03480f4b4911";
    private static final String VERSION = "5.103";

    private URIBuilder buildLink(String type) {
        try {
            URIBuilder builder = new URIBuilder(LINK + type + "?");
            builder.setParameter("access_token", ACCESS_TOKEN)
                    .setParameter("owner_id", OWNER_ID)
                    .setParameter("v", VERSION);
            return builder;
        } catch (URISyntaxException ex) {
            ex.getMessage();
        }
        return null;
    }

    @Test
    public void testVK() throws URISyntaxException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = buildLink("post")
                .setParameter("message", "test message1112222");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        String postId = EntityUtils.toString(response.getEntity()).replaceAll("\\D", "");
        Obj result = objectMapper.readValue(postId, Obj.class);

        Assert.assertTrue(postId.matches("\\d+"));

        URIBuilder builder1 = buildLink("edit")
                .setParameter("post_id", postId)
                .setParameter("message", "new text message");
        request = new HttpGet(builder1.build());
        HttpResponse response1 = client.execute(request);
        String responseEdit = EntityUtils.toString(response1.getEntity()).replaceAll("\\D", "");
        Assert.assertEquals(postId, responseEdit);

        URIBuilder builder2 = buildLink("delete")
                .setParameter("post_id", postId);
        request = new HttpGet(builder2.build());
        HttpResponse response2 = client.execute(request);
        String responseDelete = EntityUtils.toString(response2.getEntity()).replaceAll("\\D", "");
        Assert.assertEquals(responseDelete, "1");
    }

}
