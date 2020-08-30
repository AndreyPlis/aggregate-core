package com.tibbo.datatable;

import com.tibbo.datatable.field.FieldFormat;

import java.util.*;

public class SimpleDataTable implements DataTable, Cloneable {
    private List<DataRecord> dataRecords = new ArrayList<>();
    private TableFormat tableFormat;

    public SimpleDataTable( TableFormat tableFormat ){
        this.tableFormat = tableFormat;
    }

    @Override
    public void addRecord(DataRecord dataRecord) {
        dataRecords.add( dataRecord );
    }

    private void checkNullPointer( int index ) {
        if( index > dataRecords.size( ) || index < 0 )
            throw new NullPointerException( "ндекс находится за пределами массива" );
    }

    @Override
    public void addRecord(DataRecord dataRecord, int index) {
        checkNullPointer( index );
        dataRecords.add( index, dataRecord );
    }

    @Override
    public void removeRecord(int index) {
        checkNullPointer( index );
        dataRecords.remove( index );
    }

    @Override
    public DataRecord rec() {
        Optional<DataRecord> dataRecord = dataRecords.stream( ).findFirst( );
        return dataRecord.get( );
    }

    @Override
    public Object get() {
        return rec( ).getValue( 0 );
    }

    @Override
    public DataRecord getRecord(int index) {
        checkNullPointer( index );
        return dataRecords.get( index );
    }

    @Override
    public void setCellValue(String field, int index, Object value) {
        dataRecords.get( index ).setValue( field, value );
    }

    @Override
    public Object getCellValue(String field, int index) {
        checkNullPointer( index );
        return dataRecords.get( index ).getValue( field );
    }

    @Override
    public TableFormat getFormat() {
        return tableFormat;
    }

    @Override
    public int getRecordsCount() {
        return dataRecords.size();
    }

    private void reverse() {
        int last = dataRecords.toArray().length - 1;
        int middle = dataRecords.toArray().length / 2;
        for (int i = 0; i <= middle; i++) {
            DataRecord temp = dataRecords.get(i);
            dataRecords.set( i, dataRecords.get( last - i ) );
            dataRecords.set( last - i, temp );
        }
    }

    @Override
    public void sort(String fieldName, boolean desc) {
        Collections.sort( dataRecords, ( o1, o2 ) ->  o1.getValue( fieldName ).toString().compareTo( o2.getValue( fieldName ).toString( ) ) );
        if ( desc ) {
            reverse( );
        }

    }

    @Override
    public DataTable filter(String fieldName, Object value) {
        DataTable dataTable = new SimpleDataTable( tableFormat );
        for( DataRecord dataRecord: dataRecords ) {
            if ( dataRecord.getValue( fieldName ).equals( value ) ) {
                dataTable.addRecord(dataRecord);
            }
        }
        return dataTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDataTable that = (SimpleDataTable) o;
        return Objects.equals(dataRecords, that.dataRecords) &&
                Objects.equals(tableFormat, that.tableFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataRecords, tableFormat);
    }

    @Override
    protected DataTable clone() throws CloneNotSupportedException {
        DataTable dataTable = (DataTable) super.clone();
        return dataTable;
    }
    public List<DataRecord> getDataRecords( )
    {
        List<DataRecord> dataRecords = new ArrayList<>( );
        dataRecords.addAll( this.dataRecords );
        return dataRecords;
    }

}
