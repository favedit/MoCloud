package org.mo.data.dataset.common;

import org.mo.com.lang.FString;
import org.mo.com.xml.IXmlObject;
import org.mo.data.dataset.IDatasetConsole;

public class FSqlBuilder
{
   //   private IDatasetConsole _console;
   //
   //   private FString _sql = new FString();
   //
   //   private XDataset _xdataset;
   //
   //   private IXmlObjects _xfields;
   public FSqlBuilder(IDatasetConsole console,
                      IXmlObject xdataset){
      //      _console = console;
      //      _sql.clear();
      //      _xdataset = xdataset;
      //      _xfields = _xdataset.children();
   }

   //   private String makeDataType(IXmlObject xfield){
   //      String dataType = xfield.innerGet("data_type");
   //      String dataSize = xfield.innerGet("data_size");
   //      if("bool".equals(dataType)){
   //         return "CHAR(1)";
   //      }else if("int".equals(dataType)){
   //         return "INTEGER";
   //      }else if("char".equals(dataType)){
   //         return "CHAR(" + dataSize + ")";
   //      }else if("string".equals(dataType)){
   //         return "VARCHAR(" + dataSize + ")";
   //      }else if("mstring".equals(dataType)){
   //         return "VARCHAR(" + dataSize + ")";
   //      }else if("date".equals(dataType)){
   //         return "DATE";
   //      }
   //      return dataType;
   //   }
   //
   //   private void makeForeignKey(){
   //      String dataset = _xdataset.getDataName();
   //      for(int n = 0; n < _xfields.count(); n++){
   //         XDatasetField xfield = (XDatasetField) _xfields.get(n);
   //         String dataRefer = xfield.getDataRefer();
   //         if(RString.isEmpty(dataRefer)){
   //            continue;
   //         }
   //         XDataset xrefer = _console.find(dataRefer);
   //         String refername = xrefer.getDataName();
   //
   //         String dataName = xfield.getDataName().toUpperCase();
   //         String shortName = dataName;
   //         if(dataName.endsWith("_ID")){
   //            shortName = shortName.substring(0, shortName.length() - 3);
   //         }
   //         _sql.appendLine(",");
   //         _sql.appendLine("   CONSTRAINT `", dataset, "_", shortName, "`");
   //         _sql.append("      FOREIGN KEY `", dataset, "` (`", dataName, "`)");
   //         _sql.appendLine(" REFERENCES `", refername, "` (`OUID`)");
   //         _sql.append("      ON DELETE RESTRICT ON UPDATE RESTRICT");
   //      }
   //   }
   //
   //   private void makeUniqueKey(){
   //      for(int n = 0; n < _xfields.count(); n++){
   //         XDatasetField xfield = (XDatasetField) _xfields.get(n);
   //         if(RBoolean.parse(xfield.getIsKey())){
   //            continue;
   //         }
   //         if(RBoolean.parse(xfield.getIsUnique())){
   //            String dataName = xfield.getDataName();
   //            _sql.appendLine(",");
   //            _sql.append("   UNIQUE INDEX `", _xdataset.getDataName(), "_", dataName, "` (`", dataName, "`)");
   //         }
   //      }
   //   }
   public FString parse(){
      //      _sql.appendLine("CREATE TABLE `", _xdataset.getDataName(), "` (");
      //      for(int n = 0; n < _xfields.count(); n++){
      //         XDatasetField xfield = (XDatasetField) _xfields.get(n);
      //         _sql.append("   ", RString.rightPad(xfield.getDataName(), 27));
      //         String type = null;
      //         if(RBoolean.parse(xfield.getIsKey())){
      //            type = "INTEGER UNSIGNED";
      //         }else if(RString.isNotEmpty(xfield.getDataRefer())){
      //            type = "INTEGER UNSIGNED";
      //         }else{
      //            type = makeDataType(xfield);
      //         }
      //         if(!RBoolean.parse(xfield.getIsNull())){
      //            _sql.append(RString.rightPad(type, 16));
      //            _sql.append(" NOT NULL");
      //         }else{
      //            _sql.append(type);
      //         }
      //         if(RString.isNotEmpty(xfield.getDataDefault())){
      //            _sql.append(" DEFAULT '", xfield.getDataDefault(), "'");
      //         }
      //         _sql.appendLine(",");
      //      }
      //      _sql.append("   PRIMARY KEY (`OUID`)");
      //      makeUniqueKey();
      //      makeForeignKey();
      //      _sql.appendLine();
      //      _sql.appendLine(")");
      //      _sql.appendLine("ENGINE = InnoDB");
      //      _sql.appendLine("CHARACTER SET utf8 COLLATE utf8_unicode_ci;");
      //      return _sql;
      return null;
   }
}
