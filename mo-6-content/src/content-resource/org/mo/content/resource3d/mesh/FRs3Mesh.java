package org.mo.content.resource3d.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.define.enums.common.EGcData;
import org.mo.com.geom.SDoublePoint3;
import org.mo.com.geom.SFloatOutline3;
import org.mo.com.geom.SFloatPoint2;
import org.mo.com.geom.SFloatVector3;
import org.mo.com.io.FByteStream;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.geom.mesh.FGeomMesh;
import org.mo.content.geom.mesh.SGeomFace;
import org.mo.content.resource3d.common.FRs3Space;
import org.mo.content.resource3d.common.FRs3Stream;

//============================================================
// <T>资源模型网格。</T>
//============================================================
public class FRs3Mesh
      extends FRs3Space
{
   // 轮廓
   protected SFloatOutline3 _outline = new SFloatOutline3();

   // 数据流集合
   protected FObjects<FRs3Stream> _streams = new FObjects<FRs3Stream>(FRs3Stream.class);

   // 显示对象
   protected FRs3MeshDisplay _display = new FRs3MeshDisplay();

   //============================================================
   // <T>构造资源模型网格。</T>
   //============================================================
   public FRs3Mesh(){
   }

   //============================================================
   // <T>从FGeomMesh构造资源模型网格。</T>
   //
   // @param input 输入流
   //============================================================
   public FRs3Mesh(FGeomMesh geoMesh){
      // 顶点坐标流
      FRs3Stream vertexPositionStream = new FRs3Stream();
      vertexPositionStream.setCode("position");
      vertexPositionStream.setElementDataCd(EGcData.Float64);
      vertexPositionStream.setElementCount(3);
      vertexPositionStream.setDataStride(8 * 3);
      vertexPositionStream.setDataCount(geoMesh.vertexPositions().count());
      FByteStream positionStream = new FByteStream();
      for(SDoublePoint3 vertex : geoMesh.vertexPositions()){
         positionStream.writeDouble(vertex.x);
         positionStream.writeDouble(vertex.y);
         positionStream.writeDouble(vertex.z);
      }
      vertexPositionStream.setData(positionStream.toArray());
      _streams.push(vertexPositionStream);
      // 贴图uv流
      if(geoMesh.vertexCoords().count() > 0){
         FRs3Stream vertexCoordStream = new FRs3Stream();
         vertexCoordStream.setCode("textureCoord");
         vertexCoordStream.setElementDataCd(EGcData.Float32);
         vertexCoordStream.setElementCount(2);
         vertexCoordStream.setDataStride(4 * 2);
         vertexCoordStream.setDataCount(geoMesh.vertexCoords().count());
         FByteStream coordStream = new FByteStream();
         for(SFloatPoint2 coord : geoMesh.vertexCoords()){
            coordStream.writeFloat(coord.x);
            coordStream.writeFloat(coord.y);
         }
         vertexCoordStream.setData(coordStream.toArray());
         _streams.push(vertexCoordStream);
      }
      // 法线流
      if(geoMesh.vertexNormals().count() > 0){
         FRs3Stream vertexNormalStream = new FRs3Stream();
         vertexNormalStream.setCode("normal");
         vertexNormalStream.setElementDataCd(EGcData.Float32);
         vertexNormalStream.setElementCount(3);
         vertexNormalStream.setDataStride(4 * 3);
         vertexNormalStream.setDataCount(geoMesh.vertexNormals().count());
         FByteStream normalStream = new FByteStream();
         for(SFloatVector3 normal : geoMesh.vertexNormals()){
            normalStream.writeFloat(normal.x);
            normalStream.writeFloat(normal.y);
            normalStream.writeFloat(normal.z);
         }
         vertexNormalStream.setData(normalStream.toArray());
         _streams.push(vertexNormalStream);
      }
      // 索引流
      FRs3Stream positionIndexStream = new FRs3Stream();
      positionIndexStream.setCode("positionIndex");
      positionIndexStream.setElementDataCd(EGcData.Int32);
      positionIndexStream.setElementCount(3);
      positionIndexStream.setDataStride(4 * 3);
      positionIndexStream.setDataCount(geoMesh.faces().count());

      FRs3Stream textureCoordIndexStream = new FRs3Stream();
      textureCoordIndexStream.setCode("textureCoordIndex");
      textureCoordIndexStream.setElementDataCd(EGcData.Int32);
      textureCoordIndexStream.setElementCount(3);
      textureCoordIndexStream.setDataStride(4 * 3);
      textureCoordIndexStream.setDataCount(geoMesh.faces().count());

      FRs3Stream normalIndexStream = new FRs3Stream();
      normalIndexStream.setCode("normalIndex");
      normalIndexStream.setElementDataCd(EGcData.Int32);
      normalIndexStream.setElementCount(3);
      normalIndexStream.setDataStride(4 * 3);
      normalIndexStream.setDataCount(geoMesh.faces().count());

      FByteStream positionIdxStream = new FByteStream();
      FByteStream textureCoordIdxStream = new FByteStream();
      FByteStream normalIdxStream = new FByteStream();

      for(SGeomFace face : geoMesh.faces()){
         positionIdxStream.writeUint32(face.positionIndexs[0]);
         positionIdxStream.writeUint32(face.positionIndexs[1]);
         positionIdxStream.writeUint32(face.positionIndexs[2]);
         if(face.coordIndexs != null){
            textureCoordIdxStream.writeUint32(face.coordIndexs[0]);
            textureCoordIdxStream.writeUint32(face.coordIndexs[1]);
            textureCoordIdxStream.writeUint32(face.coordIndexs[2]);
         }
         if(face.normalIndexs != null){
            normalIdxStream.writeUint32(face.normalIndexs[0]);
            normalIdxStream.writeUint32(face.normalIndexs[1]);
            normalIdxStream.writeUint32(face.normalIndexs[2]);
         }
      }

      positionIndexStream.setData(positionIdxStream.toArray());
      _streams.push(positionIndexStream);

      if(textureCoordIdxStream.length() > 0){
         textureCoordIndexStream.setData(textureCoordIdxStream.toArray());
         _streams.push(textureCoordIndexStream);
      }

      if(normalIdxStream.length() > 0){
         normalIndexStream.setData(normalIdxStream.toArray());
         _streams.push(normalIndexStream);
      }
   }

   //============================================================
   // <T>获得轮廓。</T>
   //
   // @return 轮廓
   //============================================================
   public SFloatOutline3 outline(){
      return _outline;
   }

   //============================================================
   // <T>根据代码判断是否存在数据流。</T>
   //
   // @param code 代码
   // @return 是否含有
   //============================================================
   public boolean containsStream(String code){
      for(FRs3Stream stream : _streams){
         if(code.equals(stream.code())){
            return true;
         }
      }
      return false;
   }

   //============================================================
   // <T>根据代码获得数据流。</T>
   //
   // @param code 代码
   // @return 数据流
   //============================================================
   public FRs3Stream findStream(String code){
      for(FRs3Stream stream : _streams){
         if(code.equals(stream.code())){
            return stream;
         }
      }
      return null;
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FRs3Stream> streams(){
      return _streams;
   }

   //============================================================
   // <T>获得显示对象。</T>
   //
   // @return 显示对象
   //============================================================
   public FRs3MeshDisplay display(){
      return _display;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      // 输出属性
      super.serialize(output);
      // 输出轮廓
      _outline.serialize(output);
      // 输出数据流集合
      int streamCount = _streams.count();
      output.writeInt8((byte)streamCount);
      for(int i = 0; i < streamCount; i++){
         FRs3Stream stream = _streams.get(i);
         stream.serialize(output);
      }
      // 输出渲染信息
      _display.serialize(output);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Display")){
            _display.loadConfig(xnode);
         }
      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 存储渲染对象
      _display.saveConfig(xconfig.createNode("Display"));
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dMeshUnit unit){
      // 读取配置
      if(!RString.isEmpty(unit.content())){
         FXmlDocument xdocument = new FXmlDocument();
         xdocument.loadString(unit.content());
         loadConfig(xdocument.root());
      }
      // 读取属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _fullCode = unit.fullCode();
      _label = unit.label();
      // 读取轮廓
      _outline.min.parse(unit.outlineMin());
      _outline.max.parse(unit.outlineMax());
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResource3dMeshUnit unit){
      // 存储属性
      unit.setCode(_code);
      unit.setFullCode(_fullCode);
      unit.setLabel(_label);
      // 存储轮廓
      unit.setOutlineMin(_outline.min.toString());
      unit.setOutlineMax(_outline.max.toString());
      // 存储配置
      FXmlNode xconfig = new FXmlNode("Mesh");
      saveConfig(xconfig);
      unit.setContent(xconfig.xml().toString());
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 读取属性
      _label = xconfig.get("label");
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Display")){
            _display.mergeConfig(xnode);
         }
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      // 读取轮廓
      _outline.unserialize(input);
      // 读取数据流集合
      int count = input.readInt32();
      for(int n = 0; n < count; n++){
         FRs3MeshStream stream = new FRs3MeshStream();
         stream.setMesh(this);
         stream.importData(input);
         _streams.push(stream);
      }
   }

}
