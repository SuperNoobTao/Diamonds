package bean;

/**
 * Created by vito on 2016/8/17.
 */
public class TokenBean {

    public TokenBean(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String userId;
    private String token;

}
