import com.tibbo.datatable.util.MultiMap;
import org.junit.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MultiMapTest {

    @Test
    public void putMultiMap() {
        MultiMap<String, Integer> test = new MultiMap<>();
        test.put("1",1);
        test.put("1",26);
        test.put("2",6);
        test.put("2",1);

        MultiMap<String, Integer> test2 = new MultiMap<>();
        test2.put("1",1);
        test2.put("1",26);
        test2.put("2",6);
        test2.put("2",1);
        assertEquals( true, test.equals(test2));
    }
    @Test
    public void getMultiMap() {
        MultiMap<String, Integer> test = new MultiMap<>();
        test.put("1",1);
        test.put("1",55);
        test.put("2",26);
        test.put("2",1);
        Set<Integer> get = new HashSet<>();
        get.add( 26 );
        get.add( 1 );
        assertEquals(get, test.get( "2" ) );
        get.removeAll(get);
        get.add( 1 );
        get.add( 55 );
        assertEquals(get, test.get( "1" ) );
    }
    @Test
    public void removeMultiMap() {
        MultiMap<String, Integer> test = new MultiMap<>();
        test.put("1",1);
        test.put("1",26);
        test.put("2",26);
        test.put("2",1);
        test.remove( "1" );
        System.out.println( "fddf " + test.keys( ) );
        MultiMap<String, Integer> test2 = new MultiMap<>();
        test2.put("2",26);
        test2.put("2",1);
        assertEquals(true, test.equals(test2) );
    }
}
