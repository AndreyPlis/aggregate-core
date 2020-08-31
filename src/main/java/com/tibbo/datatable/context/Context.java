package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public interface Context {

    List<VariableDefinition> getVariableDefinitions() throws CloneNotSupportedException;

    void setVariableDefinition(VariableDefinition vd);

    VariableDefinition getVariableDefinition();

    DataTable getVariable(String name);

    void setVariable(String name, DataTable dataTable);

    String getName();

}
