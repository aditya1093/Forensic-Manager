package com.dts.project.model;

public class CaseLawyerModel {
	private int caseid;
	private int lawyerid;
	private String laweraccepteddate;
	private String lawerenddate;
	private String laweractivestate;
	public int getCaseid() {
		return caseid;
	}
	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}
	public int getLawyerid() {
		return lawyerid;
	}
	public void setLawyerid(int lawyerid) {
		this.lawyerid = lawyerid;
	}
	public String getLaweraccepteddate() {
		return laweraccepteddate;
	}
	public void setLaweraccepteddate(String laweraccepteddate) {
		this.laweraccepteddate = laweraccepteddate;
	}
	public String getLawerenddate() {
		return lawerenddate;
	}
	public void setLawerenddate(String lawerenddate) {
		this.lawerenddate = lawerenddate;
	}
	public String getLaweractivestate() {
		return laweractivestate;
	}
	public void setLaweractivestate(String laweractivestate) {
		this.laweractivestate = laweractivestate;
	}
}
