package entity;
/**
 * 评价实体类
 * @author Administrator
 *
 */
public class Assessment {
	private int assessmentId;
	private int assessmentTicket;
	private String assessmentTime;
	private String assessmentContent;
	private double assessmentScore;
	public Assessment() {
		super();
	}
	public Assessment(int assessmentTicket, String assessmentTime, String assessmentContent,
			double assessmentScore) {
		super();
		this.assessmentTicket = assessmentTicket;
		this.assessmentTime = assessmentTime;
		this.assessmentContent = assessmentContent;
		this.assessmentScore = assessmentScore;
	}
	public int getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}
	public int getAssessmentTicket() {
		return assessmentTicket;
	}
	public void setAssessmentTicket(int assessmentTicket) {
		this.assessmentTicket = assessmentTicket;
	}
	public String getAssessmentTime() {
		return assessmentTime;
	}
	public void setAssessmentTime(String assessmentTime) {
		this.assessmentTime = assessmentTime;
	}
	public String getAssessmentContent() {
		return assessmentContent;
	}
	public void setAssessmentContent(String assessmentContent) {
		this.assessmentContent = assessmentContent;
	}
	public double getAssessmentScore() {
		return assessmentScore;
	}
	public void setAssessmentScore(double assessmentScore) {
		this.assessmentScore = assessmentScore;
	}
	@Override
	public String toString() {
		return "Assessment [assessmentId=" + assessmentId + ", assessmentTicket=" + assessmentTicket
				+ ", assessmentTime=" + assessmentTime + ", assessmentContent=" + assessmentContent
				+ ", assessmentScore=" + assessmentScore + "]";
	}
	
	
}
