package dao;

// This allows for easy access to all your DAOs for the About Me page.
public interface iAboutMeDAOFactory {
    // public iInfo1DAO getInfo1DAO();
    public iPhotoDAO getPhotoDAO();
    public iResumeDAO getResumeDAO();
    public iEducationDAO getEducationDAO();
    public iExperienceDAO getExperienceDAO();
    public iSkillsDAO getSkillsDAO();
    // Or Other Achievements
    public iAchievementsDAO getAchievementsDAO();
    public iCertificatesDAO getCertificatesDAO();
    public iHobbiesDAO getHobbiesDAO(); // or interests

}
