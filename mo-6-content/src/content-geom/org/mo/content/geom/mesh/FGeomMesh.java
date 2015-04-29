package org.mo.content.geom.mesh;

import com.cyou.gccloud.define.enums.common.EGcData;
import org.mo.com.geom.SDoubleOutline3;
import org.mo.com.geom.SDoublePoint3;
import org.mo.com.geom.SFloatPoint2;
import org.mo.com.geom.SFloatVector3;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.content.geom.common.SFloatColor4;
import org.mo.content.resource.common.FResStream;
import org.mo.content.resource.mesh.FResMesh;

//============================================================
// <T>空间网格。</T>
//============================================================
public class FGeomMesh
      extends FObject
{
   // 顶点位置配置
   protected boolean _optionVertexPosition;

   // 顶点颜色配置
   protected boolean _optionVertexColor;

   // 顶点uv配置
   protected boolean _optionVertexCoord;

   // 顶点法线配置
   protected boolean _optionVertexNormal;

   // 顶点副法线配置
   protected boolean _optionVertexBinormal;

   // 顶点切线配置
   protected boolean _optionVertexTangent;

   // 轮廓
   protected SDoubleOutline3 _outline = new SDoubleOutline3();

   // 顶点法线集合
   protected FObjects<SDoublePoint3> _vertexPositions = new FObjects<SDoublePoint3>(SDoublePoint3.class);

   // 顶点颜色集合
   protected FObjects<SFloatColor4> _vertexColors = new FObjects<SFloatColor4>(SFloatColor4.class);

   // 顶点纹理集合
   protected FObjects<SFloatPoint2> _vertexCoords = new FObjects<SFloatPoint2>(SFloatPoint2.class);

   // 顶点法线集合
   protected FObjects<SFloatVector3> _vertexNormals = new FObjects<SFloatVector3>(SFloatVector3.class);

   // 顶点副集合
   protected FObjects<SFloatVector3> _vertexBinormals = new FObjects<SFloatVector3>(SFloatVector3.class);

   // 顶点切线集合
   protected FObjects<SFloatVector3> _vertexTangents = new FObjects<SFloatVector3>(SFloatVector3.class);

   // 顶点集合
   protected FObjects<SGeomVertex> _vertexs = new FObjects<SGeomVertex>(SGeomVertex.class);

   // 顶点字典
   protected FDictionary<SGeomVertex> _adjustVertexs = new FDictionary<SGeomVertex>(SGeomVertex.class);

   // 面集合
   protected FObjects<SGeomFace> _faces = new FObjects<SGeomFace>(SGeomFace.class);

   //============================================================
   // <T>构造空间网格。</T>
   //============================================================
   public FGeomMesh(){
   }

   //============================================================
   // <T>获得顶点位置配置。</T>
   //
   // @return 顶点位置配置
   //============================================================
   public boolean optionVertexPosition(){
      return _optionVertexPosition;
   }

   //============================================================
   // <T>设置顶点位置配置。</T>
   //
   // @param value 顶点位置配置
   //============================================================
   public void setOptionVertexPosition(boolean value){
      _optionVertexPosition = value;
   }

   //============================================================
   // <T>获得顶点颜色配置。</T>
   //
   // @return 顶点颜色配置
   //============================================================
   public boolean optionVertexColor(){
      return _optionVertexColor;
   }

   //============================================================
   // <T>设置顶点颜色配置。</T>
   //
   // @param value 顶点颜色配置
   //============================================================
   public void setOptionVertexColor(boolean value){
      _optionVertexColor = value;
   }

   //============================================================
   // <T>获得顶点uv配置。</T>
   //
   // @return 顶点位置配置
   //============================================================
   public boolean optionVertexCoord(){
      return _optionVertexCoord;
   }

   //============================================================
   // <T>设置顶点uv配置。</T>
   //
   // @param value 顶点位置配置
   //============================================================
   public void setOptionVertexCoord(boolean value){
      _optionVertexCoord = value;
   }

   //============================================================
   // <T>获得顶点法线配置。</T>
   //
   // @return 顶点位置配置
   //============================================================
   public boolean optionVertexNormal(){
      return _optionVertexNormal;
   }

   //============================================================
   // <T>设置顶点法线配置。</T>
   //
   // @param value 顶点位置配置
   //============================================================
   public void setOptionVertexNormal(boolean value){
      _optionVertexNormal = value;
   }

   //============================================================
   // <T>获得顶点副法线配置。</T>
   //
   // @return 顶点位置配置
   //============================================================
   public boolean optionVertexBinormal(){
      return _optionVertexBinormal;
   }

   //============================================================
   // <T>设置顶点副法线配置。</T>
   //
   // @param value 顶点位置配置
   //============================================================
   public void setOptionVertexBinormal(boolean value){
      _optionVertexBinormal = value;
   }

   //============================================================
   // <T>获得顶点切线配置。</T>
   //
   // @return 顶点位置配置
   //============================================================
   public boolean optionVertexTangent(){
      return _optionVertexTangent;
   }

   //============================================================
   // <T>设置顶点切线配置。</T>
   //
   // @param value 顶点位置配置
   //============================================================
   public void setOptionVertexTangent(boolean value){
      _optionVertexTangent = value;
   }

   //============================================================
   // <T>获得顶点法线集合。</T>
   //
   // @return 顶点法线集合
   //============================================================
   public FObjects<SDoublePoint3> vertexPositions(){
      return _vertexPositions;
   }

   //============================================================
   // <T>获得顶点纹理集合。</T>
   //
   // @return 顶点纹理集合
   //============================================================
   public FObjects<SFloatPoint2> vertexCoords(){
      return _vertexCoords;
   }

   //============================================================
   // <T>获得顶点颜色集合。</T>
   //
   // @return 顶点颜色集合
   //============================================================
   public FObjects<SFloatColor4> vertexColors(){
      return _vertexColors;
   }

   //============================================================
   // <T>获得顶点法线集合。</T>
   //
   // @return 顶点法线集合
   //============================================================
   public FObjects<SFloatVector3> vertexNormals(){
      return _vertexNormals;
   }

   //============================================================
   // <T>获得顶点副法线集合。</T>
   //
   // @return 顶点副法线集合
   //============================================================
   public FObjects<SFloatVector3> vertexBinormals(){
      return _vertexBinormals;
   }

   //============================================================
   // <T>获得顶点切线集合。</T>
   //
   // @return 顶点切线集合
   //============================================================
   public FObjects<SFloatVector3> vertexTangents(){
      return _vertexTangents;
   }

   //============================================================
   // <T>创建多个顶点。</T>
   //============================================================
   public void createVertexs(int count){
      _vertexs.ensureSize(count);
      for(int n = 0; n < count; n++){
         _vertexs.push(new SGeomVertex());
      }
   }

   //============================================================
   // <T>获得指定索引的顶点。</T>
   //
   // @param index 索引
   // @return 顶点
   //============================================================
   public SGeomVertex vertex(int index){
      return _vertexs.get(index);
   }

   //============================================================
   // <T>获得顶点集合。</T>
   //
   // @return 顶点集合
   //============================================================
   public FObjects<SGeomVertex> vertexs(){
      return _vertexs;
   }

   //============================================================
   // <T>创建多个面。</T>
   //============================================================
   public void createFaces(int count){
      _faces.ensureSize(count);
      for(int n = 0; n < count; n++){
         _faces.push(new SGeomFace());
      }
   }

   //============================================================
   // <T>获得指定索引的面。</T>
   //
   // @param index 索引
   // @return 面
   //============================================================
   public SGeomFace face(int index){
      return _faces.get(index);
   }

   //============================================================
   // <T>获得面集合。</T>
   //
   // @return 面集合
   //============================================================
   public FObjects<SGeomFace> faces(){
      return _faces;
   }

   //============================================================
   // <T>计算轮廓数据。</T>
   //============================================================
   public void calculateOutline(){
      _outline.reset();
      for(SGeomVertex vertex : _vertexs){
         SDoublePoint3 position = vertex.position;
         _outline.min.min(position);
         _outline.max.max(position);
      }
   }

   //============================================================
   // <T>计算法线数据。</T>
   //============================================================
   public void calculateNormal(){
      //      for(SGeomVertex vertex : _vertexs){
      //      }
   }

   //============================================================
   // <T>合并网格数据。</T>
   //============================================================
   public void mergeMesh(){
   }

   //============================================================
   // <T>分割网格数据。</T>
   //============================================================
   public void splitMesh(){
   }

   //============================================================
   // <T>根据代码获得唯一顶点。</T>
   //============================================================
   public SGeomVertex syncVertex(int vertexId,
                                 int coordId,
                                 int normalId,
                                 int binormalId,
                                 int tangentId){
      String code = vertexId + "-" + coordId + "-" + normalId + "-" + binormalId + "-" + tangentId;
      SGeomVertex vertex = _adjustVertexs.find(code);
      if(vertex == null){
         vertex = new SGeomVertex();
         vertex.adjuestId = _vertexs.count();
         _vertexs.push(vertex);
         _adjustVertexs.set(code, vertex);
      }
      return vertex;
   }

   //============================================================
   // <T>更新处理。</T>
   //============================================================
   public void update(){
      // 根据面信息调整节点信息
      int faceIndex = -1;
      for(SGeomFace face : _faces){
         face.index = ++faceIndex;
         face.indexs = new int[3];
         for(int n = 0; n < 3; n++){
            // 获得索引
            int positionIndex = face.positionIndexs[n];
            int coordIndex = face.coordIndexs == null ? 0 : face.coordIndexs[n];
            int normalIndex = face.normalIndexs == null ? 0 : face.normalIndexs[n];
            int binormalIndex = face.binormalIndexs == null ? 0 : face.binormalIndexs[n];
            int tangentIndex = face.tangentIndexs == null ? 0 : face.tangentIndexs[n];
            // 设置内容
            SGeomVertex vertex = syncVertex(positionIndex, coordIndex, normalIndex, binormalIndex, tangentIndex);
            face.indexs[n] = vertex.adjuestId;
            // 设置顶点信息
            if(!vertex.calculate){
               //vertex.merged = _vertexList[vertexIndex].merged;
               vertex.position = _vertexPositions.get(positionIndex);
               vertex.pushFace(face);
               if(_optionVertexColor){
                  int colorIndex = face.colorIndexs[n];
                  SFloatColor4 color = _vertexColors.get(colorIndex);
                  vertex.color = new SFloatColor4(color.red, color.green, color.blue, 1.0f);
               }
               //               if(!_alphaList.IsEmpty){
               //                  int alphaIndex = face.AlphaIndex[n];
               //                  vertex.Alpha = _alphaList[alphaIndex];
               //                  vertex.Color.A = vertex.Alpha;
               //               }
               if(_optionVertexCoord){
                  vertex.coord = _vertexCoords.get(coordIndex);
               }
               if(_optionVertexNormal){
                  vertex.normal = _vertexNormals.get(normalIndex);
                  vertex.normal.normalize();
               }
               if(_optionVertexBinormal){
                  vertex.binormal = _vertexBinormals.get(binormalIndex);
                  vertex.binormal.normalize();
               }
               if(_optionVertexTangent){
                  vertex.tangent = _vertexTangents.get(tangentIndex);
                  vertex.tangent.normalize();
               }
               //               if(!_illumList.IsEmpty){
               //                  int illumIndex = face.IllumIndex[n];
               //                  vertex.Illum = _illumList[illumIndex];
               //               }
               //               if(_weightMaxCount > 0){
               //                  vertex.Weights.Assign(_vertexList[vertexIndex].Weights);
               //               }
               //               if(_channels.Count > 2){
               //                  FDrChannelFace channelFace = _channels[2].Indexs[face.Index];
               //                  SFloatPoint3 channelPoint = channelFace.Points[n];
               //                  vertex.LightCoord.X = channelPoint.X;
               //                  vertex.LightCoord.Y = channelPoint.Y;
               //                  if((vertex.LightCoord.X != vertex.Coord.X) || (vertex.LightCoord.Y != -vertex.Coord.Y)){
               //                     vertex.LightCoord.X = channelPoint.X;
               //                     vertex.LightCoord.Y = channelPoint.Y;
               //                  }
               //               }
               vertex.calculate = true;
            }
            //face.AdjustVertexIndex.Set(n, vertex.AdjuestId);
         }
      }
   }

   //============================================================
   // <T>建立网格。</T>
   //
   // @return 面集合
   //============================================================
   public void buildResource(FResMesh mesh){
      mesh.streams().clear();
      mesh.outline().min.set((float)_outline.min.x, (float)_outline.min.y, (float)_outline.min.z);
      mesh.outline().max.set((float)_outline.max.x, (float)_outline.max.y, (float)_outline.max.z);
      // 导入数据流
      int vertexCount = _vertexs.count();
      int faceCount = _faces.count();
      //............................................................
      // 建立顶点坐标流
      if(_optionVertexPosition){
         FResStream stream = new FResStream();
         stream.setCode("position");
         stream.setElementDataCd(EGcData.Float32);
         stream.setElementCount(3);
         stream.setDataStride(4 * 3);
         stream.setDataCount(vertexCount);
         FByteStream dataStream = new FByteStream();
         for(SGeomVertex vertex : _vertexs){
            SDoublePoint3 position = vertex.position;
            dataStream.writeFloat((float)position.x);
            dataStream.writeFloat((float)position.y);
            dataStream.writeFloat((float)position.z);
         }
         stream.setData(dataStream.toArray());
         mesh.streams().push(stream);
      }
      //............................................................
      // 建立顶点颜色流
      if(_optionVertexColor){
         FResStream stream = new FResStream();
         stream.setCode("color");
         stream.setElementDataCd(EGcData.Uint8);
         stream.setElementCount(4);
         stream.setDataStride(4);
         stream.setDataCount(vertexCount);
         FByteStream dataStream = new FByteStream();
         for(SGeomVertex vertex : _vertexs){
            SFloatColor4 color = vertex.color;
            dataStream.writeUint8((short)(color.red * 255.0));
            dataStream.writeUint8((short)(color.green * 255.0));
            dataStream.writeUint8((short)(color.blue * 255.0));
            dataStream.writeUint8((short)(color.alpha * 255.0));
         }
         stream.setData(dataStream.toArray());
         mesh.streams().push(stream);
      }
      //............................................................
      FResStream indexStream = new FResStream();
      indexStream.setCode("index32");
      indexStream.setElementDataCd(EGcData.Int32);
      indexStream.setElementCount(3);
      indexStream.setDataStride(4 * 3);
      indexStream.setDataCount(faceCount);
      FByteStream faceStream = new FByteStream();
      for(SGeomFace face : _faces){
         faceStream.writeUint32(face.positionIndexs[0]);
         faceStream.writeUint32(face.positionIndexs[1]);
         faceStream.writeUint32(face.positionIndexs[2]);
      }
      indexStream.setData(faceStream.toArray());
      mesh.streams().push(indexStream);
   }
}
