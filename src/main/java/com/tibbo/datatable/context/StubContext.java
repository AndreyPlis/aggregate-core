package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public class StubContext implements Context {

    private String name;

    private Map<String, DataTable> variables = new HashMap<>();
    private List<VariableDefinition> variableDefinitions = new ArrayList<>();


    public StubContext(String name) {
        this.name = name;
    }

    @Override
    public List<VariableDefinition> getVariableDefinitions() {
        return new ArrayList<>(variableDefinitions);
    }

    @Override
    public void addVariableDefinition(VariableDefinition vd) {
        variableDefinitions.add(vd);
    }

    @Override
    public Optional<VariableDefinition> getVariableDefinition(String name) {
        return variableDefinitions.stream().filter(vd -> vd.getName().equals(name)).findFirst();
    }

    @Override
    public DataTable getVariable(String name) {
        if(getVariableDefinition(name).isPresent())
            return variables.get(name);
        return null;
    }

    @Override
    public void setVariable(String name, DataTable dataTable) {
        getVariableDefinition(name).ifPresent(vd-> variables.put(name,dataTable));
    }

    @Override
    public String getName() {
        return name;
    }
}
