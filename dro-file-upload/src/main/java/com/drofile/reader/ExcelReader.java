package com.drofile.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
				Row nextRow = iterator.next();
				System.out.println("ROW INDEX : " + nextRow.getRowNum());
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					
					if(nextRow.getRowNum() == 0) {
						surveyName = nextCell.getStringCellValue();
					}
					
					
					System.out.print("COLUMN INDEX: " + nextCell.getColumnIndex() +" - ");
					switch (nextCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.println(nextCell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_NUMERIC:
						System.out.println(nextCell.getNumericCellValue());
						break;
						
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.println(nextCell.getBooleanCellValue());
						break;
						
					case Cell.CELL_TYPE_BLANK:
						System.out.println();
						break;
						
					}
				}
				
				
			}
			
			workbook.close();
			inputStream.close();
			System.out.println("SURVEY NAME >>> >> > " + surveyName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static JSONObject jsonFormatter(String serveyName) {

		JSONObject parentJson = new JSONObject();
		
		JSONObject choiseJson;
		
		JSONArray questionList = new JSONArray();
		
		JSONArray choiceList = new JSONArray();
		
		JSONObject questionAnswerSet = new JSONObject();
		
		try {
			
				questionAnswerSet.put("questionName", "My motivation is lower when I am fatigued");
				{

					choiseJson = new JSONObject();
					choiseJson.put("name", "option1");
					choiseJson.put("score", 1);
					choiceList.put(choiseJson);
					
					choiseJson = new JSONObject();
					choiseJson.put("name", "option2");
					choiseJson.put("score", 2);
					choiceList.put(choiseJson);
					
					choiseJson = new JSONObject();
					choiseJson.put("name", "option3");
					choiseJson.put("score", 3);
					choiceList.put(choiseJson);
					
					choiseJson = new JSONObject();
					choiseJson.put("name", "option4");
					choiseJson.put("score", 4);
					choiceList.put(choiseJson);
					
				}
			
			
			questionAnswerSet.put("choice", choiceList);
			//System.out.println(">>> >> > " + choiceList);
			questionList.put(questionAnswerSet);
			
			
			parentJson.put("surveyName", "TESTSURVEY");
			parentJson.put("questionList", questionList);
			
			System.out.println(parentJson.toString());
			
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return parentJson;
	}
	
}
