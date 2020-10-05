import com.tibbo.datatable.MultiMap;
import com.tibbo.datatable.field.FieldFormat;
import junit.framework.TestCase;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MultimapTest extends TestCase {

    public void testGet() {
        MultiMap<Integer, String> multimap = new MultiMap<>();
        multimap.put(1, "a");
        multimap.put(2, "b");
        multimap.put(3, "c");
        multimap.put(1, "aa");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("aa");
        ArrayList<String> actualArrayList = new ArrayList<>();
        actualArrayList = multimap.get(1);

        assertEquals(arrayList,actualArrayList );
    }

    public void testRemoveForKey() {
        MultiMap<Integer, String> multimap = new MultiMap<>();
        multimap.put(1, "a");
        multimap.put(2, "b");
        multimap.put(3, "c");
        multimap.put(1, "aa");

        ArrayList<String> actualArrayList = new ArrayList<>();
        actualArrayList = multimap.removeForKey(1);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("aa");
        multimap.removeForKey(1);
        assertEquals(arrayList,actualArrayList);
    }



    public void testPutAllItTheList() {
        MultiMap<Integer, String> multimap = new MultiMap<>();
        multimap.put(1, "a");
        multimap.put(2, "b");
        multimap.put(3, "c");
        multimap.put(1, "aa");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("aa");
        arrayList.add("b");
        arrayList.add("c");

        ArrayList<String> actualArrayList = multimap.putAllItTheList();
        assertEquals(arrayList,actualArrayList);
    }
}