package com.drofile.reader;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.drofile.model.GenericExcelDto;

public class JsonFormatter {

	/**
	 * Disease Activity
	 * @param surveyName
	 * @param primaryList
	 * @return
	 */
	
	public static JSONObject dieseaseActivityJsonFormatter(String surveyName, ArrayList<GenericExcelDto> primaryList) {

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
	
	
	/**
	 * Fatigue 2
	 * @param surveyName
	 * @param primaryList
	 * @return
	 */
	public static JSONObject fatigue2ActivityJsonFormatter(String surveyName, ArrayList<GenericExcelDto> primaryList, String answerType, String headerText) {

		JSONObject parentJson = new JSONObject();
		
		JSONObject choiseJson;
		
		JSONArray questionList = new JSONArray();
		
		JSONArray choiceList = null;
		
		JSONObject questionAnswerSet;// = new JSONObject();
		
		/*for(GenericExcelDto dto: primaryList) {
			System.out.println("data > " + dto.getColumn2() +" - "+ " data > " + dto.getColumn3());
		}*/
		
		try {
			
			for(int i = 0; i < primaryList.size(); i = i+6) {
				int count = 0;
				
				
				
				GenericExcelDto dto = primaryList.get(i);
				
				//System.out.println("DATA > " + dto.getColumn2());
				
				questionAnswerSet = new JSONObject();
				choiceList = new JSONArray();
				while (count<5) {
					count ++;
					System.out.println("COUNT > " + count);
					GenericExcelDto dto2 = primaryList.get(i+count);
					
					choiseJson = new JSONObject();
					choiseJson.put("name", dto2.getColumn2());
					choiseJson.put("score", dto2.getColumn3());
					//System.out.println("choice > " + dto2.getColumn2());
					//System.out.println("Score > " + dto2.getColumn3());
					
					choiceList.put(choiseJson);
					
				}
				
				//System.out.println("question > "+dto.getColumn2());
				questionAnswerSet.put("questionName", dto.getColumn2());
				questionAnswerSet.put("choice", choiceList);
				questionList.put(questionAnswerSet);
				
				//System.out.println("QUESTION LIST > " + questionList.toString());
				
			}
			parentJson.put("surveyName", surveyName);
			parentJson.put("headerText", headerText);
			parentJson.put("choiceType", answerType);
			parentJson.put("questionList", questionList);
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return parentJson;
	}

	/**
	 * Daily health
	 * @param surveyName
	 * @param primaryList
	 * @param answerType
	 * @param headerText
	 * @return
	 */
	public static JSONObject dailyHealthJsonFormatter(String surveyName, ArrayList<GenericExcelDto> primaryList, String answerType, String headerText) {

		JSONObject parentJson = new JSONObject();
		
		JSONObject choiseJson;
		
		JSONArray questionList = new JSONArray();
		
		JSONArray choiceList = null;
		
		JSONObject questionAnswerSet;// = new JSONObject();
		
		
		try {
			
			for(int i = 0; i < primaryList.size(); i = i+12) {
				int count = 0;
				
				
				
				GenericExcelDto dto = primaryList.get(i);
				
				//System.out.println("DATA > " + dto.getColumn2());
				
				questionAnswerSet = new JSONObject();
				choiceList = new JSONArray();
				while (count<11) {
					count ++;
					
					GenericExcelDto dto2 = primaryList.get(i+count);
					
					choiseJson = new JSONObject();
					choiseJson.put("name", dto2.getColumn2());
					choiseJson.put("score", "null");
					//System.out.println("choice > " + dto2.getColumn2());
					//System.out.println("Score > " + dto2.getColumn3());
					
					choiceList.put(choiseJson);
					
				}
				
				//System.out.println("question > "+dto.getColumn2());
				questionAnswerSet.put("questionName", dto.getColumn2());
				questionAnswerSet.put("choice", choiceList);
				questionList.put(questionAnswerSet);
				
				//System.out.println("QUESTION LIST > " + questionList.toString());
				
			}
			parentJson.put("surveyName", surveyName);
			//parentJson.put("headerText", headerText);
			parentJson.put("choiceType", answerType);
			parentJson.put("questionList", questionList);
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return parentJson;
	}
	
	/**
	 * Fatigue 1
	 * @param surveyName
	 * @param primaryList
	 * @param answerType
	 * @param headerText
	 * @return
	 */
	public static JSONObject fatigue1ActivityJsonFormatter(String surveyName, ArrayList<GenericExcelDto> primaryList, String answerType, String headerText) {

		//System.out.println("SURVEY NAME > " + surveyName);
		
		JSONObject parentJson = new JSONObject();
		
		JSONObject choiseJson;
		
		JSONArray questionList = new JSONArray();
		
		JSONArray choiceList = null;
		
		JSONObject questionAnswerSet;// = new JSONObject();
		
		/*for(GenericExcelDto dto: primaryList) {
			System.out.println("data > " + dto.getColumn2() +" - "+ " data > " + dto.getColumn3());
		}*/
		
		try {
			
			for(int i = 0; i < primaryList.size(); i ++) {
				int count = 0;
				
				GenericExcelDto dto = primaryList.get(i);
				
				//System.out.println("DATA > " + dto.getColumn2());
				
				questionAnswerSet = new JSONObject();
				choiceList = new JSONArray();
				while (count<7) {
					count++;
					GenericExcelDto dto2 = primaryList.get(i);
					
					choiseJson = new JSONObject();
					choiseJson.put("name", count);
					choiseJson.put("score", "null");
					
					
					choiceList.put(choiseJson);
					
				}
				
				//System.out.println("question > "+dto.getColumn2());
				questionAnswerSet.put("questionName", dto.getColumn2());
				questionAnswerSet.put("choice", choiceList);
				questionList.put(questionAnswerSet);
				
				//System.out.println("QUESTION LIST > " + questionList.toString());
				
			}
			parentJson.put("surveyName", surveyName);
			parentJson.put("headerText", headerText);
			parentJson.put("choiceType", answerType);
			parentJson.put("questionList", questionList);
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return parentJson;
	}
	
	
	
}



