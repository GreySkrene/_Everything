public class AuthenticatedRequest {
    protected AuthToken authToken;

    // for json
    private AuthenticatedRequest() {}

    public AuthenticatedRequest(AuthToken authToken) {
        this.authToken = authToken;
    }

    public AuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }
}
