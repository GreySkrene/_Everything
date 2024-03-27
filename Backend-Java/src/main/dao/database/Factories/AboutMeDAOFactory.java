import src.main.ddao.database.DAOs.AcheivementsDAO;

public class AboutMeDAOFactory implements iAboutMeDAOFactory.java {
    @Override
    public iAchievementsDAO getachievementsDAO() {
        return new AchievementsDAO();
    }
}
