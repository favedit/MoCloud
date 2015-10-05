package org.ahyc.eai.demo.core.input.tuio;

import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>TUIO监听器。</T>
//============================================================
public abstract class FTuioListener
      extends FObject
      implements
         TuioListener
{
   // 日志输出接口
   private static final ILogger _logger = RLogger.find(FTuioListener.class);

   // 游标集合
   protected FObjects<FTuioCursor> _cursors = new FObjects<FTuioCursor>(FTuioCursor.class);

   // 游标集合
   protected FObjects<FTuioBlob> _blobs = new FObjects<FTuioBlob>(FTuioBlob.class);

   // 游标集合
   protected FObjects<FTuioObject> _objects = new FObjects<FTuioObject>(FTuioObject.class);

   //============================================================
   // <T>创建游标。</T>
   //
   // @param value 内容
   // @return 游标
   //============================================================
   protected abstract FTuioCursor createCursor(TuioCursor value);

   //============================================================
   // <T>根据会话查找游标。</T>
   //
   // @param sessionId 会话编号
   // @return 游标
   //============================================================
   public FTuioCursor findCursorBySessionId(long sessionId){
      for(FTuioCursor cursor : _cursors){
         if(cursor.sessionId() == sessionId){
            return cursor;
         }
      }
      return null;
   }

   //============================================================
   // <T>增加游标。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void addTuioCursor(TuioCursor value){
      long sessionId = value.getSessionID();
      FTuioCursor find = findCursorBySessionId(sessionId);
      if(find == null){
         FTuioCursor cursor = createCursor(value);
         _cursors.push(cursor);
         _logger.debug(this, "addTuioCursor", "Add tuio cursor. (session_id={1}, cursor_id={2}, position={3})", sessionId, cursor.id(), cursor.position());
         update();
      }
   }

   //============================================================
   // <T>更新游标。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void updateTuioCursor(TuioCursor value){
      long sessionId = value.getSessionID();
      FTuioCursor cursor = findCursorBySessionId(sessionId);
      if(cursor != null){
         cursor.set(value);
         _logger.debug(this, "updateTuioCursor", "Update tuio cursor. (session_id={1}, cursor_id={2}, position={3})", sessionId, cursor.id(), cursor.position());
         update();
      }
   }

   //============================================================
   // <T>移除游标。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void removeTuioCursor(TuioCursor value){
      long sessionId = value.getSessionID();
      FTuioCursor cursor = findCursorBySessionId(sessionId);
      if(cursor != null){
         _cursors.remove(cursor);
         _logger.debug(this, "removeTuioCursor", "Remove tuio cursor. (session_id={1}, cursor_id={2}, position={3})", sessionId, cursor.id(), cursor.position());
         update();
      }
   }

   //============================================================
   // <T>创建数据。</T>
   //
   // @param value 内容
   // @return 数据
   //============================================================
   protected abstract FTuioBlob createBlob(TuioBlob value);

   //============================================================
   // <T>根据会话查找数据。</T>
   //
   // @param sessionId 会话编号
   // @return 数据
   //============================================================
   public FTuioBlob findBlobBySessionId(long sessionId){
      for(FTuioBlob blob : _blobs){
         if(blob.sessionId() == sessionId){
            return blob;
         }
      }
      return null;
   }

   //============================================================
   // <T>增加数据。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void addTuioBlob(TuioBlob value){
      long sessionId = value.getSessionID();
      FTuioBlob find = findBlobBySessionId(sessionId);
      if(find == null){
         FTuioBlob blob = createBlob(value);
         _blobs.push(blob);
         _logger.debug(this, "addTuioBlob", "Add tuio blob. (session_id={1}, id={2}, position={3})", sessionId, blob.id(), blob.position());
         update();
      }
   }

   //============================================================
   // <T>更新数据。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void updateTuioBlob(TuioBlob value){
      long sessionId = value.getSessionID();
      FTuioBlob blob = findBlobBySessionId(sessionId);
      if(blob != null){
         blob.set(value);
         _logger.debug(this, "updateTuioBlob", "Update tuio blob. (session_id={1}, id={2}, position={3})", sessionId, blob.id(), blob.position());
         update();
      }
   }

   //============================================================
   // <T>移除数据。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void removeTuioBlob(TuioBlob value){
      long sessionId = value.getSessionID();
      FTuioBlob blob = findBlobBySessionId(sessionId);
      if(blob != null){
         _blobs.remove(blob);
         _logger.debug(this, "removeTuioBlob", "Remove tuio blob. (session_id={1}, id={2}, position={3})", sessionId, blob.id(), blob.position());
         update();
      }
   }

   //============================================================
   // <T>创建对象。</T>
   //
   // @param value 内容
   // @return 数据
   //============================================================
   protected abstract FTuioObject createObject(TuioObject value);

   //============================================================
   // <T>根据会话查找对象。</T>
   //
   // @param sessionId 会话编号
   // @return 数据
   //============================================================
   public FTuioObject findObjectBySessionId(long sessionId){
      for(FTuioObject object : _objects){
         if(object.sessionId() == sessionId){
            return object;
         }
      }
      return null;
   }

   //============================================================
   // <T>增加对象。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void addTuioObject(TuioObject value){
      long sessionId = value.getSessionID();
      FTuioObject find = findObjectBySessionId(sessionId);
      if(find == null){
         FTuioObject object = createObject(value);
         _objects.push(object);
         _logger.debug(this, "addTuioObject", "Add tuio object. (session_id={1}, id={2}, position={3})", sessionId, object.id(), object.position());
         update();
      }
   }

   //============================================================
   // <T>更新对象。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void updateTuioObject(TuioObject value){
      long sessionId = value.getSessionID();
      FTuioObject object = findObjectBySessionId(sessionId);
      if(object != null){
         object.set(value);
         _logger.debug(this, "updateTuioObject", "Update tuio object. (session_id={1}, id={2}, position={3})", sessionId, object.id(), object.position());
         update();
      }
   }

   //============================================================
   // <T>移除对象。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void removeTuioObject(TuioObject value){
      long sessionId = value.getSessionID();
      FTuioObject object = findObjectBySessionId(sessionId);
      if(object != null){
         _objects.remove(object);
         _logger.debug(this, "removeTuioObject", "Remove tuio object. (session_id={1}, id={2}, position={3})", sessionId, object.id(), object.position());
         update();
      }
   }

   //============================================================
   // <T>刷新处理。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void refresh(TuioTime value){
      //value.getStartTime();
   }

   //============================================================
   // <T>更新处理。</T>
   //============================================================
   public void update(){
   }
}
