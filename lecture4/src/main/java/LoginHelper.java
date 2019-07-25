import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginHelper extends ParentHelper {
    private User user;

    public void registrate() {
        this.user = new User();
        try {
            String newUserString = mapper.writeValueAsString(user);
            HttpPost httpPost = new HttpPost("https://taschool-notes-service.herokuapp.com/v1/accounts");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            StringEntity entity = new StringEntity(newUserString);
            httpPost.setEntity(entity);
            this.client.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String login() {
        LoginAccess loginAccess = null;
        String secretKey = "";
        HttpPost httpPost = new HttpPost("https://taschool-notes-service.herokuapp.com/oauth/token");
        List formData = new ArrayList();
        formData.add(new BasicNameValuePair("grant_type", "password"));
        formData.add(new BasicNameValuePair("scope", "read write"));
        formData.add(new BasicNameValuePair("username", this.user.email));
        formData.add(new BasicNameValuePair("password", this.user.password));
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Authorization", "Basic Y2xpZW50OnNlY3JldA==");

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(formData, "UTF-8"));
            CloseableHttpResponse response = this.client.execute(httpPost);
            HttpEntity entity2 = response.getEntity();

            String responseString = EntityUtils.toString(entity2, "UTF-8");
            loginAccess = this.mapper.readValue(responseString, LoginAccess.class);
            secretKey = "Bearer " + loginAccess.access_token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return secretKey;
    }
}
