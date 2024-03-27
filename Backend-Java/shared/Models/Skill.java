public class Skill {
    
    private String skillDescription;
    private String[] skillReferals;
    private String skillTitle;


    public Skill(String skillDescription, String[] skillReferals, String skillTitle) {
        this.skillDescription = skillDescription;
        this.skillReferals = skillReferals;
        this.skillTitle = skillTitle;
    }

    
	public String getSkillDescription() {
		return this.skillDescription;
	}

	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}

	public String[] getSkillReferals() {
		return this.skillReferals;
	}

	public void setSkillReferals(String[] skillReferals) {
		this.skillReferals = skillReferals;
	}

	public String getSkillTitle() {
		return this.skillTitle;
	}

	public void setSkillTitle(String skillTitle) {
		this.skillTitle = skillTitle;
	}

    public boolean equals(Object o) {
        if (o == null) {
        return false;
        } else if (o == this) {
        return true;
        } else if (o.getClass() != this.getClass()) {
        return false;
        } else {
        Education e = (Education)o;
        return e.getSkillDescription().equals(this.skillDescription) && e.getSkillReferals().equals(this.skillReferals) && e.getSkillTitle().equals(this.skillTitle);
        }
    }

}
