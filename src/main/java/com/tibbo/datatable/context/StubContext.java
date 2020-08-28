package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public class StubContext implements Context{

    private Map<String, DataTable> variables = new HashMap<>();
    private List<VariableDefinition> variableDefinitions = new ArrayList<>();

    @Override
    public List<VariableDefinition> getVariableDefinitions() {
        List<VariableDefinition> VariableDefinitionsGetList = new ArrayList<>();
        VariableDefinitionsGetList.addAll(variableDefinitions);
        return VariableDefinitionsGetList; //Дополнение do not return original array variableDefinitions
    }

    @Override
    public void setVariableDefinition(VariableDefinition vd) {
        variableDefinitions.add(vd);
    }

    @Override
    public void setVariableDefinition(VariableDefinition vd, int index) {
        if(index > variableDefinitions.size()){
            variableDefinitions.add(vd); // or create method addVariableDefinition and replace this row on throws.
        }
        else{
            variableDefinitions.set(index, vd);
        }
    }

    @Override
    public VariableDefinition getVariableDefinition(int index) {
        checkIndexValidVariableDefinition(index);
        return variableDefinitions.get(index);
    }

    @Override
    public DataTable getVariable(String name) {
        checkNameValidVariable(name);
        return variables.get(name);
    }

    @Override
    public void setVariable(String name, DataTable dataTable) {
        variables.put(name, dataTable);
    }

    @Override
    public String getName(int index) {
        checkIndexValidVariableDefinition(index);
        return variableDefinitions.get(index).getName();
    }
    private void checkIndexValidVariableDefinition(int index){
        if (index > variableDefinitions.size() || index < 0)
            throw new IllegalArgumentException("Index incorrect");
    }
    private void checkNameValidVariable(String name) {
        if (variables.containsKey(name) == false)
            throw new IllegalArgumentException("Name incorrect");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StubContext that = (StubContext) o;
        return Objects.equals(variables, that.variables) &&
                Objects.equals(variableDefinitions, that.variableDefinitions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variables, variableDefinitions);
    }

    @Override
    public String toString() {
        return "StubContext{" +
                "variables=" + variables +
                ", variableDefinitions=" + variableDefinitions +
                '}';
    }
    @Override
    public StubContext clone(){
        try{
            return (StubContext) super.clone();
        }
        catch (CloneNotSupportedException error){
            throw new IllegalArgumentException("Cant be used", error);
        }
    }
}
