package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public class StubContext implements Context{

    private Map<String, DataTable> variables = new HashMap<>();
    private List<VariableDefinition> variableDefinitions = new ArrayList<>();

    @Override
    public List<VariableDefinition> getVariableDefinitions() {
        List<VariableDefinition> list = new ArrayList<>();
        try{
            for(VariableDefinition def:variableDefinitions){
                list.add(def.clone());
            }
        }
        catch (CloneNotSupportedException e){
            throw new IllegalStateException("Clone don't supported in getVariableDefinitions", e);
        }
        return list;
    }

    @Override
    public void setVariableDefinition(VariableDefinition vd) {
        if(vd == null)
            throw new IllegalArgumentException("Variable definition must don't be null");
        variableDefinitions.add(0, vd);
    }

    @Override
    public VariableDefinition getVariableDefinition() {
        if(variableDefinitions.size() == 0){
            return null;
        }
        return variableDefinitions.get(0);
    }

    @Override
    public DataTable getVariable(String name) {
        if(name == null || !variables.containsKey(name))
            return null;
        return variables.get(name);
    }

    @Override
    public void setVariable(String name, DataTable dataTable) {
        if(name == null || name.equals(""))
            throw new IllegalStateException("Name of variable must don't be null");
        variables.put(name, dataTable);
    }

    @Override
    public String getName() {
        if (variableDefinitions.size() == 0){
            return null;
        }
        return variableDefinitions.get(0).getName();
    }
}
