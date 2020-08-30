package com.tibbo.datatable;

import java.util.*;
import javax.xml.crypto.*;

public class RecordComparator implements Comparator<DataRecord> {
    String fieldName;
    boolean descending;

    public RecordComparator(String fieldName){
        this(fieldName, false);
    }

    public RecordComparator(String fieldName, boolean descending){
        this.fieldName = fieldName;
        this.descending = descending;
    }

    @Override
    public int compare(DataRecord o1, DataRecord o2) {
        int result = 0;
        if( (o1.getValue(fieldName) == null) ^ (o2.getValue(fieldName) == null) ){
            if(descending){
                return 1;
            }
            else{
                return -1;
            }
        }
        if( !(o1.getValue(fieldName) instanceof Comparable) ){
            throw new IllegalStateException("Value not comparable: " + o1.getValue(fieldName));
        }

        Comparable cv1 = (Comparable) o1.getValue(fieldName);
        Comparable cv2 = (Comparable) o2.getValue(fieldName);
        result = cv1.compareTo(cv2);
        if( !descending ){
            result *= -1;
        }
        return result;
    }
}
