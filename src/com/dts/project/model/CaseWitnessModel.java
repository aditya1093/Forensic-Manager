package com.dts.project.model;

public class CaseWitnessModel {
	private int casewitnessid;
	private int caseid;
	private String witnessfstname;
	private String witnessmidname;
	private String witnesslstname;
	private String witnesstype;
	private int witnessseqno;
	private String address;
	private String dob;
	private String witnessrecordedstatement;
	public int getCasewitnessid() {
		return casewitnessid;
	}
	public void setCasewitnessid(int casewitnessid) {
		this.casewitnessid = casewitnessid;
	}
	public int getCaseid() {
		return caseid;
	}
	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}
	public String getWitnessfstname() {
		return witnessfstname;
	}
	public void setWitnessfstname(String witnessfstname) {
		this.witnessfstname = witnessfstname;
	}
	public String getWitnessmidname() {
		return witnessmidname;
	}
	public void setWitnessmidname(String witnessmidname) {
		this.witnessmidname = witnessmidname;
	}
	public String getWitnesslstname() {
		return witnesslstname;
	}
	public void setWitnesslstname(String witnesslstname) {
		this.witnesslstname = witnesslstname;
	}
	public String getWitnesstype() {
		return witnesstype;
	}
	public void setWitnesstype(String witnesstype) {
		this.witnesstype = witnesstype;
	}
	public int getWitnessseqno() {
		return witnessseqno;
	}
	public void setWitnessseqno(int witnessseqno) {
		this.witnessseqno = witnessseqno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getWitnessrecordedstatement() {
		return witnessrecordedstatement;
	}
	public void setWitnessrecordedstatement(String witnessrecordedstatement) {
		this.witnessrecordedstatement = witnessrecordedstatement;
	}
}
