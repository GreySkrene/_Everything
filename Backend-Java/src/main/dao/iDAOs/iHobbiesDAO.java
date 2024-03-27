package dao;

// CRUD Opperations.
public interface iHobbiesDAO {

    public void deleteHobbies(String userAlias, Memory[] hobbies);
    public void addHobbies(String userAlias, Memory[] hobbies);
    public String getHobbies(String userAlias);
    public void updateHobbies(String userAlias, Memory[] hobbies);

}