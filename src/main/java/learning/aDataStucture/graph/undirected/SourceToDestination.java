package learning.aDataStucture.graph.undirected;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

public class SourceToDestination {

    static boolean fun(JSONObject jsonObject, String source, String destination, Set<String> set) {

        if(set.contains(source))  return false;

        set.add(source);

        if (source.equals(destination)) {
            return true;
        }
        try {
            for (Object s : (JSONArray) (jsonObject.get(source))) {
                if (fun(jsonObject, (String) s, destination, set)) {
                    return true;
                }
            }
        } catch (Exception ignored) {
        }

        return false;
    }

    public static void main(String[] args) {
        String as = "[['w', 'x'], ['x','y'], ['y1', 'z']]";
        JSONArray jsonObject = new JSONArray(as);

        JSONObject object = build(jsonObject);

        //System.out.println(object);

        System.out.println(fun(object, "w", "y", new HashSet()));
        System.out.println(fun(object, "w", "z", new HashSet()));
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
