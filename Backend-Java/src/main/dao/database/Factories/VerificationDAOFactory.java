public class VerificationDAOFactory implements iVerificationDAOFactory {
    @Override
    public iAuthTokenDAO getAuthTokenDAO() {
        return new AuthTokenDAO();
    }
}