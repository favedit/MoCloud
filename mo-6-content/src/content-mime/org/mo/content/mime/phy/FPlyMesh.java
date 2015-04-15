package org.mo.content.mime.phy;

import com.cyou.gccloud.define.enums.common.EGcData;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.content.geom.mesh.FGeomMesh;
import org.mo.content.geom.mesh.SGeomFace;
import org.mo.content.geom.mesh.SGeomVertex;
import org.mo.content.resource3d.common.FRs3Geometry;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.content.resource3d.mesh.FRs3Mesh;

//============================================================
// <T>PLY网格。</T>
//============================================================
public class FPlyMesh
      extends FObject
{
   // 顶点定义
   protected FObjects<SPlyProperty> _vertexProperties = new FObjects<SPlyProperty>(SPlyProperty.class);

   // 存在顶点位置
   protected boolean _vertexPosition;

   // 存在顶点颜色
   protected boolean _vertexColor;

   // 顶点集合
   protected FObjects<SPlyVertex> _vertexs = new FObjects<SPlyVertex>(SPlyVertex.class);

   // 面定义
   protected FObjects<SPlyProperty> _faceProperties = new FObjects<SPlyProperty>(SPlyProperty.class);

   // 面集合
   protected FObjects<SPlyFace> _faces = new FObjects<SPlyFace>(SPlyFace.class);

   //============================================================
   // <T>构造PLY网格。</T>
   //============================================================
   public FPlyMesh(){
   }

   //============================================================
   // <T>获得顶点定义。</T>
   //
   // @return 顶点定义
   //============================================================
   public FObjects<SPlyProperty> vertexProperties(){
      return _vertexProperties;
   }

   //============================================================
   // <T>获得顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SPlyVertex> vertexs(){
      return _vertexs;
   }

   //============================================================
   // <T>获得面集合。</T>
   //
   // @return 面集合
   //============================================================
   public FObjects<SPlyFace> faces(){
      return _faces;
   }

   //============================================================
   // <T>建立网格。</T>
   //
   // @return 面集合
   //============================================================
   public FGeomMesh makeMesh(){
      FGeomMesh mesh = new FGeomMesh();
      //............................................................
      // 设置数据大小
      int vertexCount = _vertexs.count();
      mesh.createVertexs(vertexCount);
      int faceCount = _faces.count();
      mesh.createFaces(faceCount);
      //............................................................
      // 建立顶点坐标流
      if(_vertexPosition){
         mesh.setOptionVertexPosition(true);
         for(int n = 0; n < vertexCount; n++){
            SPlyVertex vertex = _vertexs.get(n);
            SGeomVertex geomVertex = mesh.vertex(n);
            geomVertex.position.set(vertex.x, vertex.y, vertex.z);
         }
      }
      //............................................................
      // 建立顶点颜色流
      if(_vertexColor){
         mesh.setOptionVertexColor(true);
         for(int n = 0; n < vertexCount; n++){
            SPlyVertex vertex = _vertexs.get(n);
            SGeomVertex geomVertex = mesh.vertex(n);
            geomVertex.color.setInt(vertex.red, vertex.green, vertex.blue, 255);
         }
      }
      //............................................................
      // 建立面信息
      for(int n = 0; n < faceCount; n++){
         SPlyFace face = _faces.get(n);
         SGeomFace geomFace = mesh.face(n);
         geomFace.set(face.data);
      }
      //............................................................
      mesh.calculateOutline();
      // 返回结果
      return mesh;
   }

   //============================================================
   // <T>建立网格。</T>
   //
   // @return 面集合
   //============================================================
   public void buildMesh(FRs3Mesh mesh){
      mesh.streams().clear();
      // 导入数据流
      int vertexCount = _vertexs.count();
      int faceCount = _faces.count();
      //............................................................
      // 建立顶点坐标流
      if(_vertexPosition){
         FRs3Stream vertexPositionStream = new FRs3Stream();
         vertexPositionStream.setCode("position");
         vertexPositionStream.setElementDataCd(EGcData.Float32);
         vertexPositionStream.setElementCount(3);
         vertexPositionStream.setDataStride(4 * 3);
         vertexPositionStream.setDataCount(vertexCount);
         FByteStream positionStream = new FByteStream();
         for(SPlyVertex vertex : _vertexs){
            positionStream.writeFloat(vertex.x);
            positionStream.writeFloat(vertex.y);
            positionStream.writeFloat(vertex.z);
         }
         vertexPositionStream.setData(positionStream.toArray());
         mesh.streams().push(vertexPositionStream);
      }
      //............................................................
      // 建立顶点颜色流
      if(_vertexColor){
         FRs3Stream vertexColorStream = new FRs3Stream();
         vertexColorStream.setCode("color");
         vertexColorStream.setElementDataCd(EGcData.Uint8);
         vertexColorStream.setElementCount(4);
         vertexColorStream.setDataStride(4);
         vertexColorStream.setDataCount(vertexCount);
         FByteStream colorStream = new FByteStream();
         for(SPlyVertex vertex : _vertexs){
            colorStream.writeUint8((short)vertex.red);
            colorStream.writeUint8((short)vertex.green);
            colorStream.writeUint8((short)vertex.blue);
            colorStream.writeUint8((short)255);
         }
         vertexColorStream.setData(colorStream.toArray());
         mesh.streams().push(vertexColorStream);
      }
      //............................................................
      FRs3Stream indexStream = new FRs3Stream();
      indexStream.setCode("index32");
      indexStream.setElementDataCd(EGcData.Int32);
      indexStream.setElementCount(3);
      indexStream.setDataStride(4 * 3);
      indexStream.setDataCount(faceCount);
      FByteStream faceStream = new FByteStream();
      for(SPlyFace face : _faces){
         faceStream.writeUint32(face.data[0]);
         faceStream.writeUint32(face.data[1]);
         faceStream.writeUint32(face.data[2]);
      }
      indexStream.setData(faceStream.toArray());
      mesh.streams().push(indexStream);
   }

   //============================================================
   // <T>建立网格。</T>
   //
   // @return 面集合
   //============================================================
   public void buildMesh(FRs3Geometry mesh){
      mesh.clearStreams();
      // 导入数据流
      int vertexCount = _vertexs.count();
      int faceCount = _faces.count();
      //............................................................
      // 建立顶点坐标流
      if(_vertexPosition){
         FRs3Stream vertexPositionStream = new FRs3Stream();
         vertexPositionStream.setCode("position");
         vertexPositionStream.setElementDataCd(EGcData.Float32);
         vertexPositionStream.setElementCount(3);
         vertexPositionStream.setDataStride(4 * 3);
         vertexPositionStream.setDataCount(vertexCount);
         FByteStream positionStream = new FByteStream();
         for(SPlyVertex vertex : _vertexs){
            positionStream.writeFloat(vertex.x);
            positionStream.writeFloat(vertex.y);
            positionStream.writeFloat(vertex.z);
         }
         vertexPositionStream.setData(positionStream.toArray());
         mesh.pushStream(vertexPositionStream);
      }
      //............................................................
      // 建立顶点颜色流
      if(_vertexColor){
         FRs3Stream vertexColorStream = new FRs3Stream();
         vertexColorStream.setCode("color");
         vertexColorStream.setElementDataCd(EGcData.Uint8);
         vertexColorStream.setElementCount(4);
         vertexColorStream.setDataStride(4);
         vertexColorStream.setDataCount(vertexCount);
         FByteStream colorStream = new FByteStream();
         for(SPlyVertex vertex : _vertexs){
            colorStream.writeUint8((short)vertex.red);
            colorStream.writeUint8((short)vertex.green);
            colorStream.writeUint8((short)vertex.blue);
            colorStream.writeUint8((short)255);
         }
         vertexColorStream.setData(colorStream.toArray());
         mesh.pushStream(vertexColorStream);
      }
      //............................................................
      FRs3Stream indexStream = new FRs3Stream();
      indexStream.setCode("index32");
      indexStream.setElementDataCd(EGcData.Int32);
      indexStream.setElementCount(3);
      indexStream.setDataStride(4 * 3);
      indexStream.setDataCount(faceCount);
      FByteStream faceStream = new FByteStream();
      for(SPlyFace face : _faces){
         faceStream.writeUint32(face.data[0]);
         faceStream.writeUint32(face.data[1]);
         faceStream.writeUint32(face.data[2]);
      }
      indexStream.setData(faceStream.toArray());
      mesh.pushStream(indexStream);
   }
}
