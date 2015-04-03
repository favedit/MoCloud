package org.mo.content.mime.obj;

import org.mo.com.io.FFileLineReader;
import org.mo.com.lang.RString;
import org.mo.com.lang.RStrings;

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
   @SuppressWarnings("resource")
   public void loadFile(String fileName,
                        String encoding){
      try(FFileLineReader reader = new FFileLineReader(fileName, encoding)){
         for(String line : reader){
            String[] data = RStrings.splitTrimNotEmpty(line, ' ');
            if(data.length < 1){
               break;
            }
            switch(data[0]){
               case "v"://顶点
                  parseVertex(data);
                  break;
               case "vt"://贴图uv
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
      SObjVertex vertex = new SObjVertex();
      vertex.x = Float.parseFloat(data[1]);
      vertex.y = Float.parseFloat(data[2]);
      vertex.z = Float.parseFloat(data[3]);
      _vertexs.push(vertex);
   }

   //============================================================
   // <T>解析法线信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseNormal(String[] data){
      SObjNormal normal = new SObjNormal();
      normal.x = Float.parseFloat(data[1]);
      normal.y = Float.parseFloat(data[2]);
      normal.z = Float.parseFloat(data[3]);
      _normals.push(normal);
   }

   //============================================================
   // <T>解析面信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseFace(String[] data){
      SObjFace face = new SObjFace();
      for(int i = 1; i < data.length; i++){
         String[] idxs = data[i].split("/");
         SObjFaceSegment segment = new SObjFaceSegment();
         if(RString.isBlank(idxs[0])){
            segment.vIdx = Integer.parseInt(idxs[0]);
         }
         if(RString.isBlank(idxs[1])){
            segment.tcIdx = Integer.parseInt(idxs[1]);
         }
         if(RString.isBlank(idxs[2])){
            segment.nIdx = Integer.parseInt(idxs[2]);
         }
         face._segments.push(segment);
      }
      _faces.push(face);
   }
}
