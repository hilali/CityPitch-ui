package com.bsabbath.intuicity.model.helper;

public enum MetricEnum {
	
	//Mapped with the database on table BUILD_STATUS
	
	EDUCATION("EDU","Education","�ducation"),
	SAFETY("SAF","Safety","S�curit�"),
	HEALTH("HLT","Health","Sant�");
	 
	 private final String code;
	 private final String englishName;
	 private final String frenchName;
	 
	 private MetricEnum(String code,String englishName,String frenchName) {
	   this.code = code;
	   this.englishName = englishName;
	   this.frenchName = frenchName;
	 }

	public String getCode() {
		return code;
	}

	public String getEnglishName() {
		return englishName;
	}

	public String getFrenchName() {
		return frenchName;
	}	 
}
