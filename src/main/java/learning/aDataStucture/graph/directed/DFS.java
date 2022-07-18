package learning.aDataStucture.graph.directed;

import org.json.JSONArray;
import org.json.JSONObject;

public class DFS {
    static void fun(JSONObject jsonObject, String source) {

        System.out.println(source);
        for (Object s : (JSONArray) (jsonObject.get(source))) {
            fun(jsonObject, (String) s);
        }
    }

    public static void main(String[] args) {
        String as = "{'a' : ['b', 'c'], 'b': ['d'], 'c': ['e'], 'd': ['f'], 'e': [], 'f' : []}";
        JSONObject jsonObject = new JSONObject(as);
        fun(jsonObject, "a");
    }
}
