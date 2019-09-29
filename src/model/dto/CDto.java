package model.dto;

import java.sql.Timestamp;

public class CDto {

	private int cId;
	private String cName;
	private String cContent;
	private Timestamp cDate;
	private int cGroup;
	private int cGroup2;
	private int cStep;
	private int cIndent;
	
	public CDto(int cId, String cName, String cContent, Timestamp cDate, int cGroup, int cGroup2, int cStep,
			int cIndent) {
		this.cId = cId;
		this.cName = cName;
		this.cContent = cContent;
		this.cDate = cDate;
		this.cGroup = cGroup;
		this.cGroup2 = cGroup2;
		this.cStep = cStep;
		this.cIndent = cIndent;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public Timestamp getcDate() {
		return cDate;
	}

	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}

	public int getcGroup() {
		return cGroup;
	}

	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}

	public int getcGroup2() {
		return cGroup2;
	}

	public void setcGroup2(int cGroup2) {
		this.cGroup2 = cGroup2;
	}

	public int getcStep() {
		return cStep;
	}

	public void setcStep(int cStep) {
		this.cStep = cStep;
	}

	public int getcIndent() {
		return cIndent;
	}

	public void setcIndent(int cIndent) {
		this.cIndent = cIndent;
	}

	@Override
	public String toString() {
		return "CDto [cId=" + cId + ", cName=" + cName + ", cContent=" + cContent + ", cDate=" + cDate + ", cGroup="
				+ cGroup + ", cGroup2=" + cGroup2 + ", cStep=" + cStep + ", cIndent=" + cIndent + "]";
	}
	
	

}
