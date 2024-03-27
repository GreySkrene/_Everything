package src.main.lambda;

public abstract class AbstractHandler {
    protected iDAOFactory aboutMefactory = new AboutMeDAOFactory();

    protected iDAOFactory getAboutMeDAOFactory() {
        return aboutMefactory;
    }
}
