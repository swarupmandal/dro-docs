package com.drofile.reader;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonClass {

	public static void main(String[] args) {
		
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
			
			JSONObject parentJson = new JSONObject();
			parentJson.put("surveyName", "TESTSURVEY");
			parentJson.put("questionList", questionList);
			
			System.out.println(parentJson.toString());
			
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
/*{
"surveyName": "",
"questionList": [{
"questionName": "My motivation is lower when I am fatigued",
"choice": [{
"name": "1",
"score": ""
},
{
"name": "2",
"score": ""
},
{
"name": "3",
"score": ""
},
{
"name": "4",
"score": ""
},
{
"name": "5",
"score": ""
},
{
"name": "6",
"score": ""
},
{
"name": "7",
"score": ""
}
]
}]
}*/