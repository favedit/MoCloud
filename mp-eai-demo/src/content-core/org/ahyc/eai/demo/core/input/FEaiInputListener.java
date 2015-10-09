package org.ahyc.eai.demo.core.input;

import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioObject;
import org.ahyc.eai.demo.core.input.tuio.FTuioBlob;
import org.ahyc.eai.demo.core.input.tuio.FTuioCursor;
import org.ahyc.eai.demo.core.input.tuio.FTuioListener;
import org.ahyc.eai.demo.core.input.tuio.FTuioObject;
import org.ahyc.eai.demo.service.touch.FTouchServlet;
import org.mo.com.geom.SIntSize2;
import org.mo.com.io.FByteStream;

//============================================================
// <T>输入监听器。</T>
//============================================================
public class FEaiInputListener
      extends FTuioListener
{
   // 日志输出接口
   // private static final ILogger _logger = RLogger.find(FEaiInputListener.class);

   protected FEaiInputConsole _console;

   protected SIntSize2 _size = new SIntSize2();

   public FEaiInputListener(){
   }

   public FEaiInputListener(FEaiInputConsole console){
      _console = console;
   }

   //============================================================
   // <T>创建游标。</T>
   //
   // @param value 内容
   // @return 游标 
   //============================================================
   @Override
   protected FTuioCursor createCursor(TuioCursor value){
      return new FEaiInputCursor(value);
   }

   //============================================================
   // <T>创建数据。</T>
   //
   // @param value 内容
   // @return 数据 
   //============================================================
   @Override
   protected FTuioBlob createBlob(TuioBlob value){
      return new FEaiInputBlob(value);
   }

   //============================================================
   // <T>创建游标。</T>
   //
   // @param value 内容
   // @return 游标 
   //============================================================
   @Override
   protected FTuioObject createObject(TuioObject value){
      return new FEaiInputObject(value);
   }

   public SIntSize2 size(){
      return _size;
   }

   //============================================================
   // <T>增加游标。</T>
   //
   // @param value 内容
   //============================================================
   public void sendCursor(String typeCode){
      FByteStream stream = new FByteStream();
      stream.writeString(typeCode);
      //message.append(typeCode);
      stream.writeInt32(_cursors.count());
      for(FTuioCursor cursor : _cursors){
         cursor.position().serialize(stream);
      }
      _console.sendMessage(FTouchServlet.GROUP_NAME, stream.memory(), 0, stream.length());
   }

   //============================================================
   // <T>增加游标。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void addTuioCursor(TuioCursor value){
      super.addTuioCursor(value);
      sendCursor("D");
   }

   //============================================================
   // <T>更新游标。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void updateTuioCursor(TuioCursor value){
      super.updateTuioCursor(value);
      sendCursor("M");
   }

   //============================================================
   // <T>移除游标。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void removeTuioCursor(TuioCursor value){
      super.removeTuioCursor(value);
      sendCursor("U");
   }

   //============================================================
   // <T>更新处理。</T>
   //============================================================
   @Override
   public void update(){
   }
}