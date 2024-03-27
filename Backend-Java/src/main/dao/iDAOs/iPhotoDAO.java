package dao;

// CRUD Opperations.
public interface iPhotoDAO {

    public void deletePhoto(String userAlias, String serializedImageData);
    public void addPhoto(String userAlias, String serializedImageData);
    public String getPhoto(String userAlias);
    public void updatePhoto (String userAlias, String serializedImageData);

}