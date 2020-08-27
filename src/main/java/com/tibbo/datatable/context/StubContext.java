package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public class StubContext implements Context {

    private Map<String, DataTable> variables = new HashMap<>();
    private List<VariableDefinition> variableDefinitions = new ArrayList<>();

    @Override
    public List<VariableDefinition> getVariableDefinitions() {
        List<VariableDefinition> newList = new ArrayList<>();
        newList.addAll(0, variableDefinitions);
        return newList; // do not return original array variableDefinitions
    }

    @Override
    public void setVariableDefinition(VariableDefinition vd, int index) {
        if (index < variableDefinitions.size())
            variableDefinitions.set(index, vd);
        else
            variableDefinitions.add(vd);
    }

    @Override
    public VariableDefinition getVariableDefinition(int index) {
        checkIndexVariableDefinition(index);
        return variableDefinitions.get(index);
    }

    @Override
    public DataTable getVariable(String name) {
        checkNameVariable(name);
        return variables.get(name);
    }

    @Override
    public void setVariable(String name, DataTable dataTable) {
        variables.put(name, dataTable);
    }

    @Override
    public String getName(int index) {
        checkIndexVariableDefinition(index);
        return variableDefinitions.get(index).getName();
    }

    private void checkIndexVariableDefinition(int index) {
        if (index > variableDefinitions.size() || index < 0)
            throw new IllegalStateException(String.format("Index %d out of bounds, must between 0 and %d", index, variableDefinitions.size()));
    }

    private void checkNameVariable(String name) {
        if (!variables.containsKey(name))
            throw new IllegalStateException(String.format("Name %s not found", name));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StubContext that = (StubContext) o;
        return variables.equals(that.variables) &&
                variableDefinitions.equals(that.variableDefinitions);
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
}
