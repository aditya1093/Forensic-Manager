package com.dts.project.model;

public class CaseEvidenceModel {
	private int caseevedenceid;
	private int caseid;
	private String evidenceregdate;
	private int evidencetypeid;
	private String evidencedesc;
	private String evidenceImage;
	private String evidencevideo;
	private String evidenceaudio;
	private String evidencetypename;
	
	public String getEvidencetypename() {
		return evidencetypename;
	}
	public void setEvidencetypename(String evidencetypename) {
		this.evidencetypename = evidencetypename;
	}
	public int getCaseevedenceid() {
		return caseevedenceid;
	}
	public void setCaseevedenceid(int caseevedenceid) {
		this.caseevedenceid = caseevedenceid;
	}
	public int getCaseid() {
		return caseid;
	}
	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}
	public String getEvidenceregdate() {
		return evidenceregdate;
	}
	public void setEvidenceregdate(String evidenceregdate) {
		this.evidenceregdate = evidenceregdate;
	}
	public int getEvidencetypeid() {
		return evidencetypeid;
	}
	public void setEvidencetypeid(int evidencetypeid) {
		this.evidencetypeid = evidencetypeid;
	}
	public String getEvidencedesc() {
		return evidencedesc;
	}
	public void setEvidencedesc(String evidencedesc) {
		this.evidencedesc = evidencedesc;
	}
	public String getEvidenceImage() {
		return evidenceImage;
	}
	public void setEvidenceImage(String evidenceImage) {
		this.evidenceImage = evidenceImage;
	}
	public String getEvidencevideo() {
		return evidencevideo;
	}
	public void setEvidencevideo(String evidencevideo) {
		this.evidencevideo = evidencevideo;
	}
	public String getEvidenceaudio() {
		return evidenceaudio;
	}
	public void setEvidenceaudio(String evidenceaudio) {
		this.evidenceaudio = evidenceaudio;
	}

}
