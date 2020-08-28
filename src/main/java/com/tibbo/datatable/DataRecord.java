package com.tibbo.datatable;

import com.tibbo.datatable.field.*;

import java.util.*;

public class DataRecord implements Cloneable {

    private TableFormat tableFormat;

    private Map<String,Object> data = new LinkedHashMap<>();

    public DataRecord(TableFormat tableFormat) {
        this.tableFormat = tableFormat;
    }

    private void validAndPutValue( Object value, int index, String fieldName )
    {
        FieldFormat ff = null;
        if( !fieldName.isEmpty() ){
            ff = findField( fieldName );
        }
        if( index > 0 ){
            ff = findField( index );
        }
        if ( ff == null )
            throw new NullPointerException( "Пустой Филд" );
        ff.validate( value );
        data.put(ff.getName(), value);
    }

    public void setValue(String fieldName, Object value)
    {
        validAndPutValue( value, 0, fieldName );
    }

    public void setValue(int index, Object value)
    {
        validAndPutValue( value, index, "" );
    }

    public Object getValue(int index)
    {
        FieldFormat ff = findField(index);
        return getValue(ff.getName());
    }

    public Object getValue(String fieldName)
    {
        Object value = data.get( fieldName );
        if( value == null )
            throw new NullPointerException( "По заданному филду нет значений" );
        return value;
    }

    private FieldFormat findField(int index)
    {
        return tableFormat.getField(index);
    }

    private FieldFormat findField( String fieldName )
    {
        return tableFormat.getField( fieldName );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRecord that = (DataRecord) o;
        return Objects.equals(tableFormat, that.tableFormat) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableFormat, data);
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "tableFormat=" + tableFormat +
                ", data=" + data +
                '}';
    }

    @Override
    protected DataRecord clone() throws CloneNotSupportedException {
        DataRecord dataRecord = (DataRecord) super.clone( );
        return dataRecord;
    }
}
