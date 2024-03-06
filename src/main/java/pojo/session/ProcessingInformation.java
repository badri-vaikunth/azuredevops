package pojo.session;

public class ProcessingInformation 
{
	 public String getActionList() {
	        return actionList;
	    }

	    public String getSessionType() {
	        return sessionType;
	    }

	    public void setActionList(String actionList) {
	        this.actionList = actionList;
	    }

	    public void setSessionType(String sessionType) {
	        this.sessionType = sessionType;
	    }

	    private String actionList;
	    private String sessionType;
}
