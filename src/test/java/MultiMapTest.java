import com.tibbo.datatable.util.MultiMap;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MultiMapTest {

    @Test
    public void put() {
        MultiMap<Number, String> multiMap = new MultiMap<>();
        multiMap.put(1, "one");
        multiMap.put(1, "two");
        assertEquals("1=[one, two]\n", multiMap.toString());
        multiMap.put(2, "two");
        assertNotEquals("1=[one, two]\n", multiMap.toString());
    }

    @Test
    public void get() {
        MultiMap<Number, String> multiMap = new MultiMap<>();
        multiMap.put(1, "one");
        multiMap.put(1, "two");
        assertEquals(new ArrayList<>(Arrays.asList("one", "two")), multiMap.get(1));
        multiMap.put(1, "three");
        assertEquals(new ArrayList<>(Arrays.asList("one", "two", "three")), multiMap.get(1));
    }

    @Test
    public void remove() {
        MultiMap<Number, String> multiMap = new MultiMap<>();
        multiMap.put(1, "one");
        multiMap.put(1, "two");
        assertEquals("two", multiMap.remove(1, "two"));
        multiMap.put(2, "two-one");
        multiMap.put(2, "two-two");
        assertEquals(new ArrayList<>(Arrays.asList("two-one", "two-two")), multiMap.remove(2));
    }

    @Test
    public void putAll() {
        MultiMap<Number, String> multiMap = new MultiMap<>();
        multiMap.put(1, "one");
        Map<Integer, String> newMap = new HashMap<>();
        newMap.put(1, "two");
        newMap.put(2, "three");
        multiMap.putAll(newMap);
        assertEquals(new ArrayList<>(Arrays.asList("one", "two")), multiMap.get(1));
        assertEquals(new ArrayList<>(Arrays.asList("three")), multiMap.get(2));
    }

    @Test
    public void equals() {
        MultiMap<Number, String> multiMap = new MultiMap<>();
        multiMap.put(1, "one");
        multiMap.put(1, "two");
        MultiMap<Number, String> multiMap1 = new MultiMap<>();
        multiMap1.put(1, "one");
        multiMap1.put(1, "two");
        assertEquals(multiMap, multiMap1);
        multiMap1.remove(1, "one");
        assertNotEquals(multiMap, multiMap1);
    }

}
