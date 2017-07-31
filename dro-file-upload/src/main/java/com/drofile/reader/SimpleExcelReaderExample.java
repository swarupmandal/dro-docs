package com.drofile.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SimpleExcelReaderExample {
	
	public static void main(String[] args) throws IOException {
		String excelFilePath = "/home/swarup/Desktop/commands/Lupus PROs.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(4);
		List<String> scoreList = new ArrayList<String>(3);
		
		//ArrayList<ArrayList<String>> nodes = new ArrayList<ArrayList<String>>();
		ArrayList<String> nodeList = new ArrayList<String>();
		
	    
		Iterator<Row> iterator = firstSheet.iterator();
		
		String surveyTitle="";
		int flag=3;
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			//System.out.println(nextRow.getRowNum());
			
			if (nextRow.getRowNum() == 0) {
				surveyTitle = new SimpleExcelReaderExample().getSurveyTitle(nextRow);
			} else if (nextRow.getRowNum()> flag) {
				nodeList.add(new SimpleExcelReaderExample().getQuestionList(scoreList, nextRow));
				//questionList.add(item);
			}
			//nodes.add(nodeList);
		}
		
		
		
		
		
		System.out.println("title----"+surveyTitle);
		System.out.println("List --"+nodeList);
		System.out.println("List --"+scoreList);
		
		workbook.close();
		inputStream.close();
	}
	
	private String getSurveyTitle(Row nextRow){
		String surveyTitle ="";
		Iterator<Cell> cellIterator = nextRow.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			//System.out.println(cell.getColumnIndex());
			if (cell.getCellType() == cell.CELL_TYPE_STRING && cell.getColumnIndex() == 1) {
				//System.out.println(cell.getStringCellValue());
				surveyTitle = cell.getStringCellValue();
				//questionList.add(cell.getStringCellValue());
			}
		}
		return surveyTitle;
	}

	private String getQuestionList(List<String> scoreList, Row nextRow) {
		String questionList = "";
		Iterator<Cell> cellIterator = nextRow.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			
			//System.out.println(cell.getColumnIndex());
			if (cell.getCellType() == cell.CELL_TYPE_STRING && cell.getColumnIndex() == 2) {
				System.out.println(cell.getStringCellValue());
				questionList=cell.getStringCellValue();
			}
			
			if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getColumnIndex() == 3) {
				System.out.println(cell.getStringCellValue());
				scoreList.add(cell.getStringCellValue());
			}
		}
		return questionList;
	}
}





/*String excelPath = "/home/joydipdey/Desktop/swarup/Projects/Prorelevant/upload_folder/Result_sheet.xlsx";

FileInputStream fileInputStream = new FileInputStream(new File(excelPath));

Workbook workbook = new XSSFWorkbook(fileInputStream);

Sheet firstSheet = workbook.getSheetAt(0);

Iterator<Row> iterator = firstSheet.iterator();

while (iterator.hasNext()) {
        int count  = 1;
        Row nextRow = iterator.next();
        if(nextRow.getRowNum() >2){

        Iterator<Cell> cellIterator = nextRow.cellIterator();

        while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                count++;

                switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:

                        if(nextRow.getRowNum() ==3){
                                productList.add(cell.getStringCellValue());
                        }

                        if(nextRow.getRowNum() >3){
                                //System.out.print(cell.getStringCellValue());

                            System.out.print("product -> " + productList.get(count));
                        }
                        break;

                case Cell.CELL_TYPE_NUMERIC:
                        //System.out.print(cell.getNumericCellValue());
                        //System.out.println("CELL NO "+cell.getColumnIndex());
                        System.out.print("product -> " + productList.get(count));
                        break;

                case Cell.CELL_TYPE_BOOLEAN:
                        //System.out.print(cell.getBooleanCellValue());
                        System.out.print("product -> " + productList.get(count));
                }

                System.out.print(" - ");
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");


}

workbook.close();
fileInputStream.close();

}*/









//Iterator<Cell> cellIterator = nextRow.cellIterator();
////System.out.print("cellIterator----"+cellIterator);
//
//while (cellIterator.hasNext()) {
//	
//	System.out.print("cellIterator----"+cellIterator.hasNext());
//	Cell cell = cellIterator.next();
//	
//	switch (cell.getCellType()) {
//	case Cell.CELL_TYPE_STRING:
//		System.out.print(cell.getStringCellValue());
//		break;
//	case Cell.CELL_TYPE_BOOLEAN:
//		System.out.print(cell.getBooleanCellValue());
//		break;
//	case Cell.CELL_TYPE_NUMERIC:
//		System.out.print(cell.getNumericCellValue());
//		break;
//	}
//	System.out.print(" - ");
//}
//System.out.println();
