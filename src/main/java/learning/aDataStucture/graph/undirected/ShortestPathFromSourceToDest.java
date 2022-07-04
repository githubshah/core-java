package learning.aDataStucture.graph.undirected;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=tWVWeAqZ0WU
public class ShortestPathFromSourceToDest {

    static int shortestPath(JSONObject jsonObject, String source, String destination, Set<String> set, int ctr) {

        if (set.contains(source)) return ctr;

        set.add(source);

        if (source.equals(destination)) {
            System.out.println(ctr);
            return ctr;
        }

        int shorter = 10;
        try {
            for (Object s : (JSONArray) (jsonObject.get(source))) {
                int shortestPath = shortestPath(jsonObject, (String) s, destination, set, ++ctr);
                if (shortestPath < shorter) {
                    shorter = shortestPath;
                }
            }
        } catch (Exception ignored) {
        }

        return shorter;
    }

    public static void main(String[] args) {
        String as = "[['a', 'b'], ['a','d'], ['a', 'e'], ['b','c'], ['b','e'], ['c' , 'f'] , ['d', 'e'], ['d', 'g'], ['e', 'f'], ['e', 'h'], ['f', 'i'], ['h', 'i'], ['e', 'i']]";

        JSONArray jsonObject = new JSONArray(as);

        JSONObject object = build(jsonObject);

        System.out.println(object.toString(4));

        System.out.println(shortestPath(object, "a", "h", new HashSet(), 0));
    }

    private static JSONObject build(JSONArray jsonArray) {

        JSONObject jsonObject = new JSONObject();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray o = (JSONArray) jsonArray.get(i);
            String a = null;
            String b = null;
            a = (String) o.get(0);
            b = (String) o.get(1);

            boolean b1 = contains(jsonObject, a);
            if (!b1) {
                jsonObject.put(a, new JSONArray());
            }

            if (!contains(jsonObject, b)) {
                jsonObject.put(b, new JSONArray());
            }

            try {
                JSONArray o1 = (JSONArray) jsonObject.get(a);
                o1.put(b);
            } catch (Exception e) {
            }

            try {
                JSONArray o2 = (JSONArray) jsonObject.get(b);
                o2.put(a);
            } catch (Exception e) {
            }

        }
        return jsonObject;
    }

    private static boolean contains(JSONObject o, String a) {
        try {
            Object o1 = o.get(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
