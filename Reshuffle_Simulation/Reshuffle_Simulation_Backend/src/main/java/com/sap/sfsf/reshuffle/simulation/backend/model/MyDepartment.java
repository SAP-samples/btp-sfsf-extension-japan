package com.sap.sfsf.reshuffle.simulation.backend.model;

import com.sap.cloud.sdk.result.ElementName;

public class MyDepartment {
	@ElementName("externalCode")
	private String externalCode;
	@ElementName("startDate")
	private String startDate;
	@ElementName("endDate")
	private String endDate;
	@ElementName("name_ja_JP")
	private String name;
	
	@ElementName("cust_toDivision")
	private MyDivision.MyDivisionContainer division;

	public String getExternalCode() {
		return externalCode;
	}

	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDivision.MyDivisionContainer getDivision() {
		return division;
	}

	public void setDivision(MyDivision.MyDivisionContainer division) {
		this.division = division;
	}
	
	
}
