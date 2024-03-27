public class iAuthTokenDAO {
    public void logout(AuthToken authToken) throws Exception; // Deletes the authToken associated with the user.
    public AuthToken login(User user); // what do we pass here??
    public boolean checkAuthToken(AuthToken authToken) throws Exception; // returns true if the authToken is still viable.
    public AuthTokenObject getAuthTokenUser(AuthToken authToken) throws Exception;
}
