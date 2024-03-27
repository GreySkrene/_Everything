package dao;

// CRUD Opperations.
public interface iAchievementsDAO {

    public void deleteAchievements(String userAlias, Memory[] achievements);
    public void addAchievements(String userAlias, Memory[] achievements);
    public Memory[] getAchievements(String userAlias);
    public void updateAchievements(String userAlias, Memory[] achievements);

}