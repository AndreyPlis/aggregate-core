package com.tibbo.datatable;

import com.tibbo.datatable.field.FieldFormat;

import java.util.Comparator;

public class ComparatorForDataRecords<T> implements Comparator<DataRecord> {
    private FieldFormat<T> fieldFormat;
    private  Boolean desc;
    public ComparatorForDataRecords(FieldFormat<T> fieldFormat, boolean desc) {
        this.fieldFormat= fieldFormat;
        this.desc = desc;
    }

    @Override
    public int compare( DataRecord o1, DataRecord o2 ) {
        if(fieldFormat == null){
            throw new IllegalStateException("fieldFormat is null");
        }
        Object tmp1 =  o1.getValue(fieldFormat.getName());
        Object tmp2 = o2.getValue(fieldFormat.getName());
        char fieldType = fieldFormat.getType();
        if(fieldType =='I'){
           if(desc) return  (Integer) tmp1 - (Integer) tmp2;
           else  return (Integer) tmp2 - (Integer) tmp1;
        }
        else if(fieldType =='S'){
            String s1 = (String)tmp1;
            String s2 = (String)tmp2;
             if(desc) return s1.compareTo(s2);
             else return  s2.compareTo(s1);
        }
        else if(fieldType == 'B'){
            Boolean b1 = (Boolean)tmp1;
            Boolean b2 = (Boolean)tmp2;
            if(desc) return b1.compareTo(b2);
            else return b2.compareTo(b1);
        }
        else {
            throw new IllegalStateException("unknown type: " + fieldFormat.getType());
        }

    }
}
