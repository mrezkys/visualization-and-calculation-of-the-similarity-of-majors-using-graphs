package Core.Helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHelper {
    public  static List<String> readAndConvertToList(String path) throws IOException {
        // Read the JSON file containing the list of topics
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        String json = builder.toString();

        // Parse the JSON data using the Gson library
        // im using additional depedency that you should import, if not, it'll be error
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> res = gson.fromJson(json, listType);
        return  res;
    }
}