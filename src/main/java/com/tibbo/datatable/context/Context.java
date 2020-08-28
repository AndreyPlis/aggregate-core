package com.tibbo.datatable.context;

import com.tibbo.datatable.*;

import java.util.*;

public interface Context {

    List<VariableDefinition> getVariableDefinitions();

    void setVariableDefinition(VariableDefinition vd);

    void setVariableDefinition(VariableDefinition vd, int index);

    VariableDefinition getVariableDefinition(int index);

    DataTable getVariable(String name);

    void setVariable(String name, DataTable dataTable);

    String getName(int index);

}
