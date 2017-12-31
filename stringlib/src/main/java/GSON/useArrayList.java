package GSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class useArrayList {

    static void run(List<Integer> lstInta, List<Integer> lstIntb) {
        lstInta.addAll(lstIntb);
        lstIntb = lstInta;
    }

    public static void jsonToMap(String jsonString) {

     /*
     jsonString = ""Id" : "1007",
	"amount" : 234.77f,
	"dateOfExpense" : 11/15/2017",
	"dateSubmitted" : "11/17/2017",
	"vendor" : "DELPHI"";

     HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = new JSONObject(t);
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jObject.getString(key);
            map.put(key, value);

        }*/
        HashMap<String,String> map = new Gson().fromJson(jsonString, new TypeToken<HashMap<String, String>>(){}.getType());

 //       System.out.println("json : "+jObject);
        System.out.println("map : "+map);
    }

    // List<ClassName> list = Arrays.asList(array)
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("Output.json");
        String strArray[] = { "Homer", "Marge", "Bart", "Lisa", "Maggie" };
        List<String> lstOfStr = Arrays.asList(strArray);
        System.out.println(" strArray to list size :" + lstOfStr.size());

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> Origa = new ArrayList<>(a);
        run(a, b);
        System.out.println(a.toString()+ b.toString());
        Gson gson = new GsonBuilder().create();
        gson.toJson("Merge two integer array :" + a.toString(), writer);
        gson.toJson(" from :"+Origa.toString(), writer);
        gson.toJson(" and :"+b.toString(), writer);
        writer.close();
        String jsonString = "{Id : 1007, amount : 234.77f, dateOfExpense : 11152017}";
        jsonToMap(jsonString);
    }
}
