package org.mo.content.mime.stl;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.geom.SFloatVector3;
import org.mo.com.io.FFileLineReader;
import org.mo.com.lang.RStrings;
import org.mo.content.geom.mesh.FGeomMesh;
import org.mo.content.geom.mesh.FGeomModel;
import org.mo.content.geom.mesh.SGeomFace;

//============================================================
// <T>OBJ文件。</T>
//============================================================
public class FStlFile
      extends FStlMesh
{
   // 文件编码
   protected String _encoding = "UTF-8";

   //============================================================
   // <T>构造OBJ文件。</T>
   //============================================================
   public FStlFile(){
   }

   //============================================================
   // <T>构造OBJ文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FStlFile(String fileName){
      loadFile(fileName, _encoding);
   }

   //============================================================
   // <T>加载文件。</T>
   //
   // @param fileName 文件名称
   // @param encoding 文本编码
   //============================================================
   public void loadFile(String fileName,
                        String encoding){
      try(FFileLineReader reader = new FFileLineReader(fileName, encoding)){
         SStlFace face = null;
         int vertexIndex = 0;
         for(String line : reader){
            String[] data = RStrings.splitTrimNotEmpty(line.trim(), ' ');
            if(data.length < 1){
               continue;
            }
            switch(data[0]){
               case "solid"://文件头
                  break;
               case "facet"://面开始、法线
                  face = new SStlFace();
                  face.normal = parseNormal(data);
                  break;
               case "outer"://顶点循环开始
                  vertexIndex = 0;
                  break;
               case "vertex"://顶点
                  parseVertex(face, vertexIndex, data);
                  vertexIndex++;
                  break;
               case "endloop"://顶点循环结束
                  vertexIndex = 0;
                  break;
               case "endfacet"://面结束
                  _faces.push(face);
                  face = null;
                  break;
               case "endsolid"://文件结束
                  break;
               default:
                  break;
            }
         }
      }
   }

   //============================================================
   // <T>解析顶点信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseVertex(SStlFace face,
                           int vertexIndex,
                           String[] data){
      SDoublePoint3 vertex = new SDoublePoint3(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
      face.vertexs[vertexIndex] = vertex;
   }

   //============================================================
   // <T>解析法线信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public SFloatVector3 parseNormal(String[] data){
      SFloatVector3 normal = new SFloatVector3(Float.parseFloat(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4]));
      return normal;
   }

   //============================================================
   // <T>创建GeomModel。</T>
   //
   // @param line 行字符串
   //============================================================
   public FGeomModel CreateGeomModel(){
      FGeomModel model = new FGeomModel();
      FGeomMesh mesh = new FGeomMesh();
      mesh.setOptionVertexPosition(true);
      mesh.setOptionVertexColor(false);
      mesh.setOptionVertexCoord(false);
      mesh.setOptionVertexNormal(true);
      mesh.setOptionVertexBinormal(false);
      mesh.setOptionVertexTangent(false);

      //多边形平面情况顶点和法线会有冗余
      for(SStlFace stlFace : _faces){
         SGeomFace geomFace = new SGeomFace();
         geomFace.positionIndexs = new int[3];
         geomFace.normalIndexs = new int[3];
         int normalIndex = mesh.vertexNormals().count();
         mesh.vertexNormals().push(stlFace.normal);
         for(int i = 0; i < 3; i++){
            int vertexIndex = mesh.vertexPositions().count();
            mesh.vertexPositions().push(stlFace.vertexs[i]);
            geomFace.positionIndexs[i] = vertexIndex;
            geomFace.normalIndexs[i] = normalIndex;
         }
         mesh.faces().push(geomFace);
      }

      mesh.update();
      model.meshs().push(mesh);
      return model;
   }
}
