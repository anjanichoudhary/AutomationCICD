package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		
		//red json string
	String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//sr//test//java//rahulshettyacademy//data//PurchaseOrder.json"), StandardCharsets.UTF_8);
	
	//String to HasMap Jackson Datbind
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	});
	return data;
	
	//{map, map}
				
				
	}

}
