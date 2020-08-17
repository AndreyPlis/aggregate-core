package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();
    private Integer minString;
    private Integer maxString;

    public void setFields(List<FieldFormat> fields) {
        this.fields = fields;
    }

    public void setMinString(int minString) {
        this.minString = minString;
    }

    public void setMaxString(int maxString) {
        this.maxString = maxString;
    }

    public List<FieldFormat> getFields() {
        return fields;
    }

    public int getMinString() {
        return minString;
    }

    public int getMaxString() {
        return maxString;
    }

    public void addField(FieldFormat fieldFormat)
    {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        return fields.remove(fieldFormat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableFormat that = (TableFormat) o;
        Iterator iterator = that.fields.iterator();
        for(FieldFormat it: fields){
            if(it.equals(iterator.next()) == false) return false;
        }
        return minString == that.minString &&
                maxString == that.maxString;
    }

    @Override
    public int hashCode() {
       int result =0;
       result += maxString.hashCode() *29;
       result += minString.hashCode()*29;
       for(FieldFormat it: fields){
           result += fields.hashCode()*29;
       }
       return result;
    }

    @Override
    public String toString() {
        String stringFromFields = new String();
        for(FieldFormat it: fields){
            stringFromFields += it.toString();
        }
        return "TableFormat{" +
                "fields=" + stringFromFields +
                ", minString=" + minString +
                ", maxString=" + maxString +
                '}';
    }

    public TableFormat clone() {
        TableFormat tmp = new TableFormat();
        tmp.maxString = this.maxString;
        tmp.minString = this.minString;
        ArrayList<FieldFormat> myList = new ArrayList<>();
        for(FieldFormat it: fields){
            myList.add(it.clone());
        }
        tmp.fields = myList;
        return tmp;



    }

}

