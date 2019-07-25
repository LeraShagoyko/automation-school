public class LoginAccess {
    public String access_token;
    public String token_type;
    public int expires_in;
    public String scope;

    public String toString() {
        return this.access_token;
    }
}
