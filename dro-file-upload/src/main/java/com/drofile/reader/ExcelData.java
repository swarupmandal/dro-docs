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
import org.codehaus.jettison.json.JSONObject;

import com.drofile.model.GenericExcelDto;

public class ExcelData {

	/**
	 * Disease activity Excel
	 * @param excelFilePath
	 * @param sheetno
	 * @return
	 */
	
	public static JSONObject diseaseiseaseActivityExcelReader(String excelFilePath, int sheetno) {
		ArrayList<GenericExcelDto> dataSet = new ArrayList<GenericExcelDto>();
		String surveyName = null;
		try {
			
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheetNo = workbook.getSheetAt(sheetno);
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
				if(dto.getColumn2() != null && dto.getColumn2().trim().length() >0) {
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
		
		JSONObject jsonObject = JsonFormatter.dieseaseActivityJsonFormatter(surveyName, dataSet);
		//System.out.println(jsonObject.toString());
		return jsonObject;
	}
	
	/**
	 * Fatigue 2 Excel
	 * @param excelFilePath
	 * @param sheetno
	 * @return
	 */
	public static JSONObject fatigue2ExcelReader(String excelFilePath, int sheetno) {

		ArrayList<GenericExcelDto> dataSet = new ArrayList<GenericExcelDto>();
		String surveyName = null;
		String headerText = null;
		String answerType = "1"; // radio button
		try {
			
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheetNo = workbook.getSheetAt(sheetno);
			Iterator<Row> iterator = sheetNo.iterator();
			
			
			while (iterator.hasNext()) {
				
				GenericExcelDto dto = new GenericExcelDto();
				
				Row nextRow = iterator.next();
				
				//System.out.println("ROW INDEX : " + nextRow.getRowNum() +" >>> >> >");
				
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				
				while (cellIterator.hasNext()) {
					
					Cell nextCell = cellIterator.next();
					
					if(nextRow.getRowNum() == 0 && nextCell.getColumnIndex() == 0) {
						surveyName = nextCell.getStringCellValue();
						//System.out.println("Survey Name > " + surveyName);
					}
					
					if(nextRow.getRowNum() == 2 && nextCell.getColumnIndex() == 1) {
						headerText = nextCell.getStringCellValue();
						//System.out.println("Header Text > " + headerText);
					}
					
					
					
					if(nextRow.getRowNum() > 2) {
					if(nextCell.getColumnIndex() <=2) {
					//System.out.print("COLUMN INDEX: " + nextCell.getColumnIndex() +" - ");
					
						//System.out.println(nextCell);
						
						if(nextCell.getColumnIndex() ==1) {
							String y = nextCell.toString();
							//System.out.println("Y - >>> >> > " + y);
							dto.setColumn2(y);
						}
						if(nextCell.getColumnIndex() == 2) {
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
				if(dto.getColumn2() != null && dto.getColumn2().trim().length() >0) {
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
		
		/*for(GenericExcelDto dto: dataSet) {
			System.out.println("data > " + dto.getColumn2() +" - "+ " data > " + dto.getColumn3());
		}*/
		
		
		JSONObject jsonObject =JsonFormatter.fatigue2ActivityJsonFormatter(surveyName, dataSet, answerType, headerText);// JsonFormatter.dieseaseActivityJsonFormatter(surveyName, dataSet);
		//System.out.println(jsonObject.toString());
		return jsonObject;
	
	}
	
	/**
	 * Daily Health Excel
	 * @param excelFilePath
	 * @param sheetno
	 * @return
	 */
	public static JSONObject dailyHealthExcelReader(String excelFilePath, int sheetno) {

		ArrayList<GenericExcelDto> dataSet = new ArrayList<GenericExcelDto>();
		String surveyName = null;
		String headerText = null;
		String answerType = "15"; // slider
		try {
			
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheetNo = workbook.getSheetAt(sheetno);
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
						//System.out.println("Survey Name > " + surveyName);
					}
					
					/*if(nextRow.getRowNum() == 2 && nextCell.getColumnIndex() == 1) {
						headerText = nextCell.getStringCellValue();
						//System.out.println("Header Text > " + headerText);
					}*/
					
					
					if(nextRow.getRowNum() > 1) {
						
					if(nextCell.getColumnIndex() <=2) {
					//System.out.print("COLUMN INDEX: " + nextCell.getColumnIndex() +" - ");
					
						//System.out.println(nextCell);
						
						/*if(nextCell.getColumnIndex() ==1) {
							String y = nextCell.toString();
							//System.out.println("Y - >>> >> > " + y);
							dto.setColumn2(y);
						}*/
						if(nextCell.getColumnIndex() == 2) {
							String x = nextCell.toString();
							if(x.equalsIgnoreCase("0.0")) {
								dto.setColumn2("0");
							}else if (x.equalsIgnoreCase("1.0")) {
								dto.setColumn2("1");
							}else if (x.equalsIgnoreCase("2.0")) {
								dto.setColumn2("2");
							}else if (x.equalsIgnoreCase("3.0")) {
								dto.setColumn2("3");
							}else if (x.equalsIgnoreCase("4.0")) {
								dto.setColumn2("4");
							}else if (x.equalsIgnoreCase("5.0")) {
								dto.setColumn2("5");
							}else if (x.equalsIgnoreCase("6.0")) {
								dto.setColumn2("6");
							}else if (x.equalsIgnoreCase("7.0")) {
								dto.setColumn2("7");
							}else if (x.equalsIgnoreCase("8.0")) {
								dto.setColumn2("8");
							}else if (x.equalsIgnoreCase("9.0")) {
								dto.setColumn2("9");
							}else {
								dto.setColumn2(x);
							}
							
							
							//System.out.println("z - >>> >> > " + x);
						}
						
					}
				  }
					
				}
				if(dto.getColumn2() != null && dto.getColumn2().trim().length() > 0) {
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
		
		
		JSONObject jsonObject =JsonFormatter.dailyHealthJsonFormatter(surveyName, dataSet, answerType, headerText);
		//System.out.println(jsonObject.toString());
		return jsonObject;
	
	}
	
	/**
	 * Fatigue 1 Excel
	 * @param excelFilePath
	 * @param sheetno
	 * @return
	 */
	public static JSONObject fatigue1ExcelReader(String excelFilePath, int sheetno) {

		ArrayList<GenericExcelDto> dataSet = new ArrayList<GenericExcelDto>();
		String surveyName = null;
		String headerText = null;
		String answerType = "15"; // radio button
		try {
			
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheetNo = workbook.getSheetAt(sheetno);
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
						System.out.println("Survey Name > " + surveyName);
					}
					
					if(nextRow.getRowNum() == 3 && nextCell.getColumnIndex() == 2) {
						headerText = nextCell.getStringCellValue();
						//System.out.println("Header Text > " + headerText);
					}
					
					
					
					if(nextRow.getRowNum() > 3 && nextRow.getRowNum() <= 12) {
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
				if(dto.getColumn2() != null && dto.getColumn2().trim().length() >0) {
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
		
		
		JSONObject jsonObject =JsonFormatter.fatigue1ActivityJsonFormatter(surveyName, dataSet, answerType, headerText);// JsonFormatter.dieseaseActivityJsonFormatter(surveyName, dataSet);
		//System.out.println(jsonObject.toString());
		return jsonObject;
	
	}
	
	
}
