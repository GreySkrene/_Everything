public class Memory {
    
    private String memoryTitle;
    private String memoryYears;
    private String memoryNotes;
    private String memoryID;

    public Memory(String memoryTitle, String memoryYears, String memoryNotes, String memoryID) {
        this.memoryTitle = memoryTitle;
        this.memoryYears = memoryYears;
        this.memoryNotes = memoryNotes;
        this.memoryID = memoryID;
    }

	public String getMemoryTitle() {
		return this.memoryTitle;
	}

	public void setMemoryTitle(String memoryTitle) {
		this.memoryTitle = memoryTitle;
	}

	public String getMemoryYears() {
		return this.memoryYears;
	}

	public void setMemoryYears(String memoryYears) {
		this.memoryYears = memoryYears;
	}

	public String getMemoryNotes() {
		return this.memoryNotes;
	}

	public void setMemoryNotes(String memoryNotes) {
		this.memoryNotes = memoryNotes;
	}    

	public String getMemoryID() {
		return this.memoryID;
	}

	public void setMemoryID(String memoryID) {
		this.memoryID = memoryID;
	}

    public boolean equals(Object o) {
        if (o == null) {
        return false;
        } else if (o == this) {
        return true;
        } else if (o.getClass() != this.getClass()) {
        return false;
        } else {
        Experience e = (Experience)o;
        return e.getMemoryTitle().equals(this.memoryTitle) && e.getMemoryYears().equals(this.memoryYears) && e.getMemoryNotes().equals(this.memoryNotes) && e.getMemoryID().equals(this.memoryID);
        }
    }

}
