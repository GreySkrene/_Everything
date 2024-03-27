public class iExperienceDAO {
    
    public void deleteExperience(String userAlias, Memory[] experience);
    public void addExperience(String userAlias, Memory[] experience);
    public String getExperience(String userAlias);
    public void updateExperience (String userAlias, Memory[] experience);

}
