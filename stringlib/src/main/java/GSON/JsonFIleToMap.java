package GSON;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonFIleToMap {
    static JsonReader mJsonReader;
    public static void main(String[] args) {

        Gson gson = new Gson();

        String json_file = "C:\\Jihshin\\AndroidStudio\\Reflection\\stringlib\\src\\main\\java\\GSON\\mmap.json";

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(json_file));
            StringBuilder sb = new StringBuilder();
            String line="";
            while ( (line = br.readLine()) != null ) {
                sb.append(line);
            };
            System.out.println("GSOBN Object "+sb.toString());
            //convert the json string back to object
            Map jsonObject = (Map) gson.fromJson(sb.toString(), Object.class);
            Map map00 = (Map) jsonObject.get("Exp10");

            List expenses = (List) map00.get("ExpenseReports");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println("expenses[" + i + "]= " + expenses.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
