package dao;

// CRUD Opperations.
public interface iCertificateDAO {

    public void deleteCertificates(String userAlias, Memory[] certificate);
    public void addCertificates(String userAlias, Memory[] certificate);
    public String getCertificates(String userAlias);
    public void updateCertificates(String userAlias, Memory[] certificate);

}