package org.mo.jfa.core.database.dai;

import org.mo.com.collections.FDataset;

public interface IDatabaseDai
{

   FDataset listTable(String table);

   FDataset listTableField(String table,
                           String field);

}
