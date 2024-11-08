package Wipro.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadData {
	public  List<HashMap<String, String>> readJsonData(String filepath) throws IOException {
		//convert JsonFile to string
		String Json=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		//string to map
		ObjectMapper obj= new ObjectMapper();
		List<HashMap<String,String>> data=obj.readValue(Json, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}

}
