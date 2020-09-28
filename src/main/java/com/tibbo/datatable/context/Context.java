package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public interface Context {

    List<VariableDefinition> getVariableDefinitions();

    void addVariableDefinition(VariableDefinition vd);

    Optional<VariableDefinition> getVariableDefinition(String name);

    DataTable getVariable(String name);

    void setVariable(String name, DataTable dataTable);

    String getName();

}
