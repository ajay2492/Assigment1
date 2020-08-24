package comm.framework;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class JsonCreator {
    public static void jsonFile(String inputKey, String inputValue) {
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put(inputKey, inputValue);

        try {
            FileWriter file = new FileWriter("resources/" + inputKey + ".json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Logger.info(jsonObject.toString());
    }

}