package org.mo.content.resource.mesh;

import com.cyou.gccloud.data.data.FDataResourceModelMeshUnit;
import com.cyou.gccloud.define.enums.common.EGcData;
import org.mo.com.geom.SFloatOutline3;
import org.mo.com.io.FByteStream;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.geom.mesh.FGeomMesh;
import org.mo.content.geom.mesh.SGeomFace;
import org.mo.content.geom.mesh.SGeomVertex;
import org.mo.content.resource.common.FResSpace;
import org.mo.content.resource.common.FResStream;

//============================================================
// <T>资源模型网格。</T>
//============================================================
public class FResMesh
      extends FResSpace
{
   // 轮廓
   protected SFloatOutline3 _outline = new SFloatOutline3();

   // 数据流集合
   protected FObjects<FResStream> _streams;

   // 显示对象
   protected FResMeshDisplay _display = new FResMeshDisplay();

   //============================================================
   // <T>构造资源模型网格。</T>
   //============================================================
   public FResMesh(){
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
      for(FResStream stream : _streams){
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
   public FResStream findStream(String code){
      for(FResStream stream : _streams){
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
   public FObjects<FResStream> streams(){
      return _streams;
   }

   //============================================================
   // <T>增加一个数据流。</T>
   //
   // @param stream 数据流
   //============================================================
   public void pushStream(FResStream stream){
      if(_streams == null){
         _streams = new FObjects<FResStream>(FResStream.class);
      }
      _streams.push(stream);
   }

   //============================================================
   // <T>获得显示对象。</T>
   //
   // @return 显示对象
   //============================================================
   public FResMeshDisplay display(){
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
         FResStream stream = _streams.get(i);
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
   public void loadUnit(FDataResourceModelMeshUnit unit){
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
   public void saveUnit(FDataResourceModelMeshUnit unit){
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
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      // 读取轮廓
      _outline.unserialize(input);
      // 读取数据流集合
      int count = input.readInt32();
      for(int n = 0; n < count; n++){
         FResMeshStream stream = new FResMeshStream();
         stream.setMesh(this);
         stream.importData(input);
         _streams.push(stream);
      }
   }

   //============================================================
   // <T>从FGeomMesh构造资源模型网格。</T>
   //
   // @param input 输入流
   //============================================================
   public void loadGeometry(FGeomMesh geoMesh){
      int vertexCount = geoMesh.vertexs().count();
      // 顶点坐标流
      if(geoMesh.optionVertexPosition()){
         FResStream vertexPositionStream = new FResStream();
         vertexPositionStream.setCode("position");
         vertexPositionStream.setElementDataCd(EGcData.Float32);
         vertexPositionStream.setElementCount(3);
         vertexPositionStream.setDataStride(4 * 3);
         vertexPositionStream.setDataCount(vertexCount);
         FByteStream positionStream = new FByteStream();
         for(SGeomVertex vertex : geoMesh.vertexs()){
            positionStream.writeFloat((float)vertex.position.x);
            positionStream.writeFloat((float)vertex.position.y);
            positionStream.writeFloat((float)vertex.position.z);
         }
         vertexPositionStream.setData(positionStream.toArray());
         pushStream(vertexPositionStream);
      }
      // 顶点颜色流
      if(geoMesh.optionVertexColor()){
         FResStream vertexColorStream = new FResStream();
         vertexColorStream.setCode("color");
         vertexColorStream.setElementDataCd(EGcData.Uint8);
         vertexColorStream.setElementCount(4);
         vertexColorStream.setDataStride(4);
         vertexColorStream.setDataCount(vertexCount);
         FByteStream colorStream = new FByteStream();
         for(SGeomVertex vertex : geoMesh.vertexs()){
            colorStream.writeUint8((short)(vertex.color.red * 255.0));
            colorStream.writeUint8((short)(vertex.color.green * 255.0));
            colorStream.writeUint8((short)(vertex.color.blue * 255.0));
            colorStream.writeUint8((short)(vertex.color.alpha * 255.0));
         }
         vertexColorStream.setData(colorStream.toArray());
         pushStream(vertexColorStream);
      }
      // 贴图uv流
      if(geoMesh.optionVertexCoord()){
         FResStream vertexCoordStream = new FResStream();
         vertexCoordStream.setCode("coord");
         vertexCoordStream.setElementDataCd(EGcData.Float32);
         vertexCoordStream.setElementCount(2);
         vertexCoordStream.setDataStride(4 * 2);
         vertexCoordStream.setDataCount(vertexCount);
         FByteStream coordStream = new FByteStream();
         for(SGeomVertex vertex : geoMesh.vertexs()){
            coordStream.writeFloat(vertex.coord.x);
            coordStream.writeFloat(vertex.coord.y);
         }
         vertexCoordStream.setData(coordStream.toArray());
         pushStream(vertexCoordStream);
      }
      // 法线流
      if(geoMesh.optionVertexNormal()){
         FResStream vertexNormalStream = new FResStream();
         vertexNormalStream.setCode("normal");
         vertexNormalStream.setElementDataCd(EGcData.Float32);
         vertexNormalStream.setElementCount(3);
         vertexNormalStream.setDataStride(4 * 3);
         vertexNormalStream.setDataCount(vertexCount);
         FByteStream normalStream = new FByteStream();
         for(SGeomVertex vertex : geoMesh.vertexs()){
            normalStream.writeFloat(vertex.normal.x);
            normalStream.writeFloat(vertex.normal.y);
            normalStream.writeFloat(vertex.normal.z);
         }
         vertexNormalStream.setData(normalStream.toArray());
         pushStream(vertexNormalStream);
      }
      // 副法线流
      if(geoMesh.optionVertexBinormal()){
         FResStream vertexBinormalStream = new FResStream();
         vertexBinormalStream.setCode("binormal");
         vertexBinormalStream.setElementDataCd(EGcData.Float32);
         vertexBinormalStream.setElementCount(3);
         vertexBinormalStream.setDataStride(4 * 3);
         vertexBinormalStream.setDataCount(vertexCount);
         FByteStream binormalStream = new FByteStream();
         for(SGeomVertex vertex : geoMesh.vertexs()){
            binormalStream.writeFloat(vertex.binormal.x);
            binormalStream.writeFloat(vertex.binormal.y);
            binormalStream.writeFloat(vertex.binormal.z);
         }
         vertexBinormalStream.setData(binormalStream.toArray());
         pushStream(vertexBinormalStream);
      }
      // 切线流
      if(geoMesh.optionVertexTangent()){
         FResStream vertexTangentStream = new FResStream();
         vertexTangentStream.setCode("tangent");
         vertexTangentStream.setElementDataCd(EGcData.Float32);
         vertexTangentStream.setElementCount(3);
         vertexTangentStream.setDataStride(4 * 3);
         vertexTangentStream.setDataCount(vertexCount);
         FByteStream tangentStream = new FByteStream();
         for(SGeomVertex vertex : geoMesh.vertexs()){
            tangentStream.writeFloat(vertex.tangent.x);
            tangentStream.writeFloat(vertex.tangent.y);
            tangentStream.writeFloat(vertex.tangent.z);
         }
         vertexTangentStream.setData(tangentStream.toArray());
         pushStream(vertexTangentStream);
      }
      //顶点索引流
      FResStream indexStream = new FResStream();
      indexStream.setCode("index32");
      indexStream.setElementDataCd(EGcData.Int32);
      indexStream.setElementCount(3);
      indexStream.setDataStride(4 * 3);
      indexStream.setDataCount(geoMesh.faces().count());
      FByteStream faceStream = new FByteStream();
      for(SGeomFace face : geoMesh.faces()){
         faceStream.writeUint32(face.indexs[0]);
         faceStream.writeUint32(face.indexs[1]);
         faceStream.writeUint32(face.indexs[2]);
      }
      indexStream.setData(faceStream.toArray());
      pushStream(indexStream);
   }
}
