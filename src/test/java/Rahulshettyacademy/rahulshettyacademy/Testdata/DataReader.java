package Rahulshettyacademy.rahulshettyacademy.Testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	@SuppressWarnings("deprecation")
	public List<HashMap<String, String>> getjsondataToMap() throws IOException {
		// read json to string
		String jsoncontent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\Rahulshettyacademy\\rahulshettyacademy\\Testdata\\productorder.json"),
				StandardCharsets.UTF_8);
		// convert string to hashmap using jackson data binding
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		// return map({},{}}
		
		
		
	}

}
