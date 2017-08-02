package com.drofile.reader;

import org.codehaus.jettison.json.JSONObject;

public class ExcelReader {

	public static void main(String[] args) {
		
		String excelFilePath = "/home/swarup/Desktop/commands/Lupus PROs.xlsx";
		
		//JSONObject jsonObject = ExcelData.diseaseActivityExcelReader(excelFilePath, 4);
		//System.out.println(jsonObject.toString());
		
		//JSONObject fagigue2Json = ExcelData.fatigue2ExcelReader(excelFilePath, 3);
		//System.out.println(fagigue2Json.toString());
		
		//JSONObject dailyHealthJson = ExcelData.dailyHealthExcelReader(excelFilePath, 6);
		//System.out.println(dailyHealthJson.toString());
		
		JSONObject dailyHealthJson = ExcelData.fatigue1ExcelReader(excelFilePath, 2);
		System.out.println(dailyHealthJson.toString());
		
	}
	
}	
	
	
	
	
	
	
	
	
