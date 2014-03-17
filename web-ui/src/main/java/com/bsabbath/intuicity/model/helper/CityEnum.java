package com.bsabbath.intuicity.model.helper;

public enum CityEnum {
	
	//Mapped with the database on table BUILD_STATUS
	
	MONTREAL("MTL",ProvinceEnum.QUEBEC.getCode(), "Montreal","Montréal"),
	QUEBEC("QC",ProvinceEnum.QUEBEC.getCode(),"Quebec","Québec"),
	TORONTO("TRT",ProvinceEnum.ONTARIO.getCode(),"Toronto","Toronto"),
	VANCOUVER("VAN",ProvinceEnum.BRITISH_COLUMBIA.getCode(),"Vancouver","Vancouver"),
	CALGARY("CLG",ProvinceEnum.ALBERTA.getCode(),"Calgary","Calgary");
	 
	 private final String code;
	 private final String province;
	 private final String englishName;
	 private final String frenchName;
	 
	 private CityEnum(String code,String province,String englishName,String frenchName) {
	   this.code = code;
	   this.province = province;
	   this.englishName = englishName;
	   this.frenchName = frenchName;
	 }

	public String getCode() {
		return code;
	}

	public String getProvince() {
		return province;
	}

	public String getEnglishName() {
		return englishName;
	}

	public String getFrenchName() {
		return frenchName;
	}	 
}
