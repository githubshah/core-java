package learning.aDataStucture.graph.directed;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TotalSpanningTree {

    static int fun(JSONObject jsonObject) {

        Set<String> set = new HashSet<>();
        int longest = 0;

        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            int longest1 = longest(jsonObject, keys.next(), set);
            if(longest< longest1) longest = longest1;
        }
        return longest;
    }

    private static int longest(JSONObject jsonObject, String node, Set<String> visited) {
        if (visited.contains(node)) {
            return 0;
        }

        visited.add(node);

        int size = 1;

        try {
            for (Object s : (JSONArray) (jsonObject.get(node))) {
                size += longest(jsonObject, (String) s, visited);
            }
        } catch (Exception ignored) {
        }

        return size;
    }

    public static void main(String[] args) {
        String as = "{'0' : ['8', '1', '5'], '1': ['0'], '5': ['0' , '8'], '8': ['0', '5'], '2': ['3' , '4'], '3' : ['2' , '4'], '4' : ['3' , '2']}";
        JSONObject jsonObject = new JSONObject(as);
        System.out.println(fun(jsonObject));
    }
}
