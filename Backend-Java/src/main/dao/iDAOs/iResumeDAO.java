package dao;

// CRUD Opperations.
public interface iResumeDAO {

    public void deleteResume(String userAlias, String serializedImageData);
    public void addResume(String userAlias, String serializedImageData);
    public String getResume(String userAlias);
    public void updateResume (String userAlias, String serializedImageData);

}