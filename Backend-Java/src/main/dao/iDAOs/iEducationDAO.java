package dao;

// CRUD Opperations.
public interface iEducationDAO {

    public void deleteEducation(String userAlias, Memory[] education);
    public void addEducation(String userAlias, Memory[] education);
    public String getEducation(String userAlias);
    public void updateEducation (String userAlias, Memory[] education);

}