package org.mo.content.mime.obj;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.geom.SFloatPoint2;
import org.mo.com.geom.SFloatVector3;
import org.mo.com.io.FFileLineReader;
import org.mo.com.lang.RString;
import org.mo.com.lang.RStrings;
import org.mo.content.geom.mesh.FGeomMesh;
import org.mo.content.geom.mesh.FGeomModel;
import org.mo.content.geom.mesh.SGeomFace;

//============================================================
// <T>OBJ文件。</T>
//============================================================
public class FObjFile
      extends FObjMesh
{
   // 文件编码
   protected String _encoding = "UTF-8";

   //============================================================
   // <T>构造PLY文件。</T>
   //============================================================
   public FObjFile(){
   }

   //============================================================
   // <T>构造PLY文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FObjFile(String fileName){
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
         for(String line : reader){
            String[] data = RStrings.splitTrimNotEmpty(line, ' ');
            if(data.length < 1){
               continue;
            }
            switch(data[0]){
               case "v"://顶点
                  parseVertex(data);
                  break;
               case "vt"://贴图uv
                  parseTextureCoord(data);
                  break;
               case "vn"://法线
                  parseNormal(data);
                  break;
               case "f"://面
                  parseFace(data);
                  break;
               case "s"://Smooth shading group or off, ONLY off is supported, currently.
                  break;
               case "#"://注释
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
   public void parseVertex(String[] data){
      SDoublePoint3 vertex = new SDoublePoint3(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
      _vertexs.push(vertex);
   }

   //============================================================
   // <T>解析uv信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseTextureCoord(String[] data){
      SFloatPoint2 tc = new SFloatPoint2(Float.parseFloat(data[1]), Float.parseFloat(data[2]));
      _textureCoords.push(tc);
   }

   //============================================================
   // <T>解析法线信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseNormal(String[] data){
      SFloatVector3 normal = new SFloatVector3(Float.parseFloat(data[1]), Float.parseFloat(data[2]), Float.parseFloat(data[3]));
      _normals.push(normal);
   }

   //============================================================
   // <T>解析面信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseFace(String[] data){
      SGeomFace face = new SGeomFace();
      face.positionIndexs = new int[data.length - 1];
      face.coordIndexs = new int[data.length - 1];
      face.normalIndexs = new int[data.length - 1];

      for(int i = 1; i < data.length; i++){
         String[] idxs = data[i].split("/");
         if(RString.isBlank(idxs[0])){
            face.positionIndexs[i] = Integer.parseInt(idxs[0]);
         }
         if(RString.isBlank(idxs[1])){
            face.coordIndexs[i] = Integer.parseInt(idxs[1]);
         }
         if(RString.isBlank(idxs[2])){
            face.normalIndexs[i] = Integer.parseInt(idxs[2]);
         }
      }
      _faces.push(face);
   }

   //============================================================
   // <T>创建GeomModel。</T>
   //
   // @param line 行字符串
   //============================================================
   public FGeomModel CreateGeomModel(){
      FGeomModel model = new FGeomModel();
      FGeomMesh mesh = new FGeomMesh();
      mesh.vertexPositions().assign(_vertexs);
      mesh.vertexNormals().assign(_normals);
      mesh.faces().assign(_faces);
      mesh.update();
      model.meshs().push(mesh);
      return model;
   }
}
