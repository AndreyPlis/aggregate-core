import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> data = new HashMap<>();

        data.put("foo",1);
        data.put("foo2", 2);
        data.put("foo3",3);
        data.put("foo",4);
        System.out.println(data);

        if(data.containsKey("foo24")) {
            System.out.println(data.get("foo24"));
        }
        data.forEach((k,v) -> System.out.println(k + " " + v));
        Integer v = data.remove("foo");
        if(v != null)
            System.out.println(v);
        System.out.println("----------------------------------");

        for(Map.Entry<String,Integer> entry: data.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
