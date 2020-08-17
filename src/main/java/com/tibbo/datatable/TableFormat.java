package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();

    private int minCountLine; //added 2.2
    private int maxCountLine; //added 2.2

    public int getMinCountLine() {
        return minCountLine;
    }

    public void setMinCountLine(int minCountLine) {
        this.minCountLine = minCountLine;
    }

    public int getMaxCountLine() {
        return maxCountLine;
    }

    public void setMaxCountLine(int maxCountLine) {
        this.maxCountLine = maxCountLine;
    }

    public void addField(FieldFormat fieldFormat)
    {
        fields.add(fieldFormat);
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        return fields.remove(fieldFormat);
    }
    //added 2.1
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return  false;
        }
        if( getClass() !=o.getClass()){
            return false;
        }
        TableFormat tableEquals = (TableFormat) o;
        return false; // need update after create min & max string
    }
    //added 2.1
    @Override
    public int hashCode(){
        return Objects.hash();// need update after create min & max string
    }
    //added 2.1
    @Override
    public String toString(){
        return "Hello"; // need update after create min & max string
    }
    //added 2.1
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
