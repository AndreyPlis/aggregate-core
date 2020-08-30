package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public class StubContext implements Context{

    private Map<String, DataTable> variables = new HashMap<>();
    private List<VariableDefinition> variableDefinitions = new ArrayList<>();

    @Override
    public List<VariableDefinition> getVariableDefinitions() {
        List<VariableDefinition> variableDefinitions = new ArrayList<>( );
        variableDefinitions.addAll( this.variableDefinitions );
        return variableDefinitions; // do not return original array variableDefinitions
    }

    @Override
    public void setVariableDefinition(VariableDefinition vd) {
        variableDefinitions.add( vd );
    }

    @Override
    public VariableDefinition getVariableDefinition() {
        return variableDefinitions.get( 0 );
    }

    @Override
    public DataTable getVariable(String name) {
        return variables.get( name );
    }

    @Override
    public void setVariable(String name, DataTable dataTable) {
        variables.put( name, dataTable );
    }

    @Override
    public String getName() {
        return variableDefinitions.get( 0 ).getName( );
    }
}
