package com.dts.project.model;

public class CaseHearingModel {
	private int casehearingid;
	private int caseid;
	private String hearingdate;
	private String hearingresult;
	private String nexthearingdate;
	private String anyspecialinstruction;
	public int getCasehearingid() {
		return casehearingid;
	}
	public void setCasehearingid(int casehearingid) {
		this.casehearingid = casehearingid;
	}
	public int getCaseid() {
		return caseid;
	}
	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}
	public String getHearingdate() {
		return hearingdate;
	}
	public void setHearingdate(String hearingdate) {
		this.hearingdate = hearingdate;
	}
	public String getHearingresult() {
		return hearingresult;
	}
	public void setHearingresult(String hearingresult) {
		this.hearingresult = hearingresult;
	}
	public String getNexthearingdate() {
		return nexthearingdate;
	}
	public void setNexthearingdate(String nexthearingdate) {
		this.nexthearingdate = nexthearingdate;
	}
	public String getAnyspecialinstruction() {
		return anyspecialinstruction;
	}
	public void setAnyspecialinstruction(String anyspecialinstruction) {
		this.anyspecialinstruction = anyspecialinstruction;
	}
}
