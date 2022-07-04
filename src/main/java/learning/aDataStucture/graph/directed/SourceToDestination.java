package learning.aDataStucture.graph.directed;

import org.json.JSONArray;
import org.json.JSONObject;

public class SourceToDestination {

    static boolean fun(JSONObject jsonObject, String source, String destination) {

        if (source.equals(destination)) {
            return true;
        }
        System.out.println(source);
        try {
            for (Object s : (JSONArray) (jsonObject.get(source))) {
                if (fun(jsonObject, (String) s, destination)) {
                    return true;
                }
            }
        } catch (Exception ignored) {
        }

        return false;
    }

    public static void main(String[] args) {
        String as = "{'a' : ['b', 'c'], 'b': ['d'], 'c': ['e'], 'd': ['f'], 'e': [], 'f' : [], 'h' : []}";
        JSONObject jsonObject = new JSONObject(as);
        System.out.println(fun(jsonObject, "a", "f"));
        System.out.println(fun(jsonObject, "a", "h"));
    }
}
