package learning.aDataStucture.graph.directed.simple;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static Queue<String> queue = new LinkedList();

    static void fun(JSONObject jsonObject, String source) {
        while (queue.size() > 0) {
            String current = queue.poll();

            System.out.println(current);

            for (Object s : (JSONArray) (jsonObject.get(current))) {
                queue.add((String) s);
                fun(jsonObject, (String) s);
            }
        }
    }

    public static void main(String[] args) {
        String as = "{'a' : ['b', 'c'], 'b': ['d'], 'c': ['e'], 'd': ['f'], 'e': [], 'f' : []}";
        JSONObject jsonObject = new JSONObject(as);
        queue.add("a");
        fun(jsonObject, "a");
    }
}
