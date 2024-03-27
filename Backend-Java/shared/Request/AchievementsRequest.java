
public class AchievementsRequest extends AuthenticatedRequest {
    private Memory[] achievements;
    private String operation;

    public AchievementsRequest() {}

    public AchievementsRequest(AuthToken authToken) {
        super(authToken);
        String operation = "READ";
    }

    public AchievementsRequest(AuthToken authToken, Memory[] achievements, String operation) {
        super(authToken);
        this.achievements = achievements;
        this.operation = operation;
    }

    public Memory[] getAchievements() {
        return achievements;
    }

    public void setAchievements() {
        this.achievements = achievements;
    }

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
