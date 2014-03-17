package com.bsabbath.intuicity.model.helper;

public enum ProvinceEnum {
	ALBERTA("AB","ALBERTA","ALBERTA"),
	BRITISH_COLUMBIA("BC","BRITISH COLUMBIA","COLOMBIE-BRITANNIQUE"),
	MANITOBA("MB","MANITOBA","MANITOBA"),
	NEW_BRUNSWICK("NB","NEW-BRUNSWICK","NOUVEAU-BRUNSWICK"),
	NEWFOUNDLAND_AND_LABRADOR("NL","NEWFOUNDLAND AND LABRADOR","TERRE-NEUVE-ET-LABRADOR"),
	SASKATCHEWAN("SK","SASKATCHEWAN","SASKATCHEWAN"),
	QUEBEC("QC","QUEBEC","QUÉBEC"),
	NOVA_SCOTIA("NS","NOVA SCOTIA","NOUVELLE-ÉCOSSE"),
	PRINCE_EDWARD_ISLAND("PE","PRINCE EDWARD ISLAND","ÎLE-DU-PRINCE-ÉDOUARD"),
	ONTARIO("ON","ONTARIO","ONTARIO"),
	NORTHWEST_TERRITORIES("NT","NORTHWEST TERRITORIES","TERRITOIRES DU NORD-OUEST"),
	NUNAVUT("NU","NUNAVUT","NUNAVUT"),
	YUKON("YT","YUKON","YUKON");
	 
	 private final String code;
	 private final String englishName;
	 private final String frenchName;
	 
	 private ProvinceEnum(String code,String englishName,String frenchName) {
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
