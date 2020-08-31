package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public class StubContext implements Context{

    private Map<String, DataTable> variables = new HashMap<>();
    private List<VariableDefinition> variableDefinitions = new ArrayList<>();

    @Override
    public List<VariableDefinition> getVariableDefinitions() throws CloneNotSupportedException {
        List<VariableDefinition> newVariableDefinitions = new ArrayList<>();
        for(VariableDefinition it: variableDefinitions){
            newVariableDefinitions.add(it.clone());
        }
        return   newVariableDefinitions;
    }

    @Override
    public void setVariableDefinition(VariableDefinition vd) {

    }

    @Override
    public VariableDefinition getVariableDefinition() {
        return null;
    }

    @Override
    public DataTable getVariable(String name) {
        return null;
    }

    @Override
    public void setVariable(String name, DataTable dataTable) {

    }

    @Override
    public String getName() {
        return null;
    }
}
