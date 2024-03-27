public class AchievementsResponse extends Response {
    private Memory[] achievements;

    public AchievementsResponse(boolean success) {
        super(success);
    }

    public AchievementsResponse(boolean success, String message) {
        super(success, message);
    }

    public AchievementsResponse(boolean success, String message, Memory[] achievements) {
        super(success, message);
        this.achievements = achievements;
    }

    public getAchievements() {
        return this.achievements;
    }
}
