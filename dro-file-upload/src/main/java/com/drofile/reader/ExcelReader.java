package com.drofile.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.omg.PortableServer.Servant;

import com.drofile.model.GenericExcelDto;

public class ExcelReader {

	public static void main(String[] args) {
		
		String excelFilePath = "/home/swarup/Desktop/commands/Lupus PROs.xlsx";
		ArrayList<GenericExcelDto> dataSet = new ArrayList<GenericExcelDto>();
		String surveyName = null;
		try {
			
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheetNo = workbook.getSheetAt(4);
			Iterator<Row> iterator = sheetNo.iterator();
			
			
			while (iterator.hasNext()) {
				
				GenericExcelDto dto = new GenericExcelDto();
				
				Row nextRow = iterator.next();
				
				//System.out.println("ROW INDEX : " + nextRow.getRowNum() +" >>> >> >");
				
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				
				while (cellIterator.hasNext()) {
					
					Cell nextCell = cellIterator.next();
					
					if(nextRow.getRowNum() == 0 && nextCell.getColumnIndex() == 1) {
						surveyName = nextCell.getStringCellValue();
					}
					
					if(nextRow.getRowNum() > 3) {
					if(nextCell.getColumnIndex() <=3) {
					//System.out.print("COLUMN INDEX: " + nextCell.getColumnIndex() +" - ");
					
						//System.out.println(nextCell);
						
						if(nextCell.getColumnIndex() ==2) {
							String y = nextCell.toString();
							//System.out.println("Y - >>> >> > " + y);
							dto.setColumn2(y);
						}
						if(nextCell.getColumnIndex() == 3) {
							String x = nextCell.toString();
							if(x.equalsIgnoreCase("0.0")) {
								dto.setColumn3("0");
							}else {
								dto.setColumn3(x);
							}
							
							
							//System.out.println("z - >>> >> > " + x);
						}
						
					}
				  }
					
				}
				if(dto.getColumn2() != null) {
					dataSet.add(dto);
				}
				
			}
			
			workbook.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = jsonFormatter(surveyName, dataSet);
		System.out.println(jsonObject.toString());
	}
	
	public static JSONObject jsonFormatter(String surveyName, ArrayList<GenericExcelDto> primaryList) {

		JSONObject parentJson = new JSONObject();
		
		JSONObject choiseJson;
		
		JSONArray questionList = new JSONArray();
		
		JSONArray choiceList = null;
		
		JSONObject questionAnswerSet;// = new JSONObject();
		
		try {
			
			for(int i = 0; i < primaryList.size(); i = i+5) {
				int count = 0;
				
				
				
				GenericExcelDto dto = primaryList.get(i);
				
				questionAnswerSet = new JSONObject();
				choiceList = new JSONArray();
				while (count<4) {
					count ++;
					GenericExcelDto dto2 = primaryList.get(i+count);
					
					choiseJson = new JSONObject();
					choiseJson.put("name", dto2.getColumn2());
					choiseJson.put("score", dto2.getColumn3());
					
					
					choiceList.put(choiseJson);
					
				}
				questionAnswerSet.put("questionName", dto.getColumn2());
				questionAnswerSet.put("choice", choiceList);
				questionList.put(questionAnswerSet);
				
			}
			parentJson.put("surveyName", surveyName);
			parentJson.put("questionList", questionList);
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return parentJson;
	}
	
}
