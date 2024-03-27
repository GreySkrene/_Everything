package src.main.service;

public class CRUDService {
    
    // Start with About Me
    private iAboutMeDAOFactory am_factory;
    private iVerificationDAOFactory v_factory;

    public AboutMeService(iAboutMeDAOFactory am_factory, iVerificationDAOFactory v_factory) {
        this.am_factory = am_factory;
        this.v_factory = v_factory;
    } 

    // Create an operation for each DAO. just pass the CRUD to that dao and we should be fine.
    public AchievementsResponse request_achievements(AchievementsRequest request) {
        if(request.getAuthToken() == null) {
            throw new RuntimeException("[Bad Request] Request needs to have an authToken");
        } else if(request.getOperation() == null) {
            throw new RuntimeException("[Bad Request] Request needs to have an opperation");
        } else if(request.getAchievements() == null && !operation.equals("READ")) {
            throw new RuntimeException("[Bad Request] Request needs to have achievements")
        }

        try {
            getAuthTokenDAO().checkAuthToken(request.getAuthToken());

            AuthTokenObject object = getAuthTokenDAO().getAuthTokenUser(request.getAuthToken());
            User user = new User(object.getUserFirstName(), object.getUserLastName(), object.getUserAlias());

            String alias = object.getUserAlias();
            Memory[] achievements = object.getAchievements();

            // Check what operation we want.
            String operation = request.getOperation();
            switch (operation) {
                case CrudOperation.CREATE:
                    // Handle CREATE operation
                    getAchievementsDAO().addAchievements(alias, achievements);
                    break;
                case CrudOperation.READ:
                    // Handle READ operation
                    achievements = getAchievementsDAO().getAchievements(alias);
                    return new AchievementsResponse(true, "", achievements);
                    break;
                case CrudOperation.UPDATE:
                    // Handle UPDATE operation
                    getAchievementsDAO().updateAchievements(alias, achievements);
                    break;
                case CrudOperation.DELETE:
                    // Handle DELETE operation
                    getAchievementsDAO().deleteAchievements(alias, achievements);
                    break;
                default:
                    throw new RuntimeException("[Bad Request] operation must be a CRUD operation");
            }


        } catch (Exception e) {
            return new AchievementsResponse(false, e.getMessage);
        }

        return new AchievementsResponse(true);
    }







    iAuthTokenDAO getAuthTokenDAO() {
        return v_factory.getAuthTokenDAO();
    }

    iAchievementsDAO getAchievementsDAO() {
        return am_factory.getAchievementsDAO();
    }

    iCertificatesDAO getCertificatesDAO() {
        return am_factory.getCertificatesDAO();
    }

    iEducationDAO getEducationDAO() {
        return am_factory.getEducationDAO();
    }

    iExperienceDAO getExperienceDAO() {
        return am_factory.getExperienceDAO();
    }

    iHobbiesDAO getHobbiesDAO() {
        return am_factory.getHobbiesDAO();
    }

    iPhotoDAO getPhotoDAO() {
        return am_factory.getPhotoDAO();
    }

    iResumeDAO getResumeDAO() {
        return am_factory.getResumeDAO();
    }

    iSkillsDAO getSkillsDAO() {
        return am_factory.getSkillsDAO();
    }

}
