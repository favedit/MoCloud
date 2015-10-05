package org.ahyc.eai.demo.connect.test;

/*

 TUIO Java GUI Demo
 Copyright (c) 2005-2014 Martin Kaltenbrunner <martin@tuio.org>
 
 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files
 (the "Software"), to deal in the Software without restriction,
 including without limitation the rights to use, copy, modify, merge,
 publish, distribute, sublicense, and/or sell copies of the Software,
 and to permit persons to whom the Software is furnished to do so,
 subject to the following conditions:
 
 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioPoint;
import TUIO.TuioTime;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JComponent;

public class TuioDemoComponent
      extends JComponent
      implements
         TuioListener
{

   private Hashtable<Long, TuioDemoObject> objectList = new Hashtable<Long, TuioDemoObject>();

   private Hashtable<Long, TuioCursor> cursorList = new Hashtable<Long, TuioCursor>();

   private Hashtable<Long, TuioDemoBlob> blobList = new Hashtable<Long, TuioDemoBlob>();

   public static final int finger_size = 15;

   public static final int object_size = 60;

   public static final int table_size = 760;

   public static int width, height;

   private float scale = 1.0f;

   public boolean verbose = false;

   @Override
   public void setSize(int w,
                       int h){
      super.setSize(w, h);
      width = w;
      height = h;
      scale = height / (float)TuioDemoComponent.table_size;
   }

   @Override
   public void addTuioObject(TuioObject tobj){
      TuioDemoObject demo = new TuioDemoObject(tobj);
      objectList.put(tobj.getSessionID(), demo);

      if(verbose)
         System.out.println("add obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ") " + tobj.getX() + " " + tobj.getY() + " " + tobj.getAngle());
   }

   @Override
   public void updateTuioObject(TuioObject tobj){

      TuioDemoObject demo = objectList.get(tobj.getSessionID());
      demo.update(tobj);

      if(verbose)
         System.out.println("set obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ") " + tobj.getX() + " " + tobj.getY() + " " + tobj.getAngle() + " " + tobj.getMotionSpeed() + " " + tobj.getRotationSpeed() + " " + tobj.getMotionAccel() + " "
               + tobj.getRotationAccel());
   }

   @Override
   public void removeTuioObject(TuioObject tobj){
      objectList.remove(tobj.getSessionID());

      if(verbose)
         System.out.println("del obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ")");
   }

   @Override
   public void addTuioCursor(TuioCursor tcur){

      if(!cursorList.containsKey(tcur.getSessionID())){
         cursorList.put(tcur.getSessionID(), tcur);
         repaint();
      }

      if(verbose)
         System.out.println("add cur " + tcur.getCursorID() + " (" + tcur.getSessionID() + ") " + tcur.getX() + " " + tcur.getY());
   }

   @Override
   public void updateTuioCursor(TuioCursor tcur){

      repaint();

      if(verbose)
         System.out.println("set cur " + tcur.getCursorID() + " (" + tcur.getSessionID() + ") " + tcur.getX() + " " + tcur.getY() + " " + tcur.getMotionSpeed() + " " + tcur.getMotionAccel());
   }

   @Override
   public void removeTuioCursor(TuioCursor tcur){

      cursorList.remove(tcur.getSessionID());
      repaint();

      if(verbose)
         System.out.println("del cur " + tcur.getCursorID() + " (" + tcur.getSessionID() + ")");
   }

   @Override
   public void addTuioBlob(TuioBlob tblb){
      TuioDemoBlob demo = new TuioDemoBlob(tblb);
      blobList.put(tblb.getSessionID(), demo);

      if(verbose)
         System.out.println("add blb " + tblb.getBlobID() + " (" + tblb.getSessionID() + ") " + tblb.getX() + " " + tblb.getY() + " " + tblb.getAngle());
   }

   @Override
   public void updateTuioBlob(TuioBlob tblb){

      TuioDemoBlob demo = blobList.get(tblb.getSessionID());
      demo.update(tblb);

      if(verbose)
         System.out.println("set blb " + tblb.getBlobID() + " (" + tblb.getSessionID() + ") " + tblb.getX() + " " + tblb.getY() + " " + tblb.getAngle() + " " + tblb.getMotionSpeed() + " " + tblb.getRotationSpeed() + " " + tblb.getMotionAccel() + " "
               + tblb.getRotationAccel());
   }

   @Override
   public void removeTuioBlob(TuioBlob tblb){
      blobList.remove(tblb.getSessionID());

      if(verbose)
         System.out.println("del blb " + tblb.getBlobID() + " (" + tblb.getSessionID() + ")");
   }

   @Override
   public void refresh(TuioTime frameTime){
      repaint();
   }

   @Override
   public void paint(Graphics g){
      update(g);
   }

   @Override
   public void update(Graphics g){

      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

      g2.setColor(Color.white);
      g2.fillRect(0, 0, width, height);

      int w = Math.round(width - scale * finger_size / 2.0f);
      int h = Math.round(height - scale * finger_size / 2.0f);

      Enumeration<TuioCursor> cursors = cursorList.elements();
      while(cursors.hasMoreElements()){
         TuioCursor tcur = cursors.nextElement();
         if(tcur == null)
            continue;
         ArrayList<TuioPoint> path = tcur.getPath();
         TuioPoint current_point = path.get(0);
         if(current_point != null){
            // draw the cursor path
            g2.setPaint(Color.blue);
            for(int i = 0; i < path.size(); i++){
               TuioPoint next_point = path.get(i);
               g2.drawLine(current_point.getScreenX(w), current_point.getScreenY(h), next_point.getScreenX(w), next_point.getScreenY(h));
               current_point = next_point;
            }
         }

         // draw the finger tip
         g2.setPaint(Color.lightGray);
         int s = (int)(scale * finger_size);
         g2.fillOval(current_point.getScreenX(w - s / 2), current_point.getScreenY(h - s / 2), s, s);
         g2.setPaint(Color.black);
         g2.drawString(tcur.getCursorID() + "", current_point.getScreenX(w), current_point.getScreenY(h));
      }

      // draw the objects
      Enumeration<TuioDemoObject> objects = objectList.elements();
      while(objects.hasMoreElements()){
         TuioDemoObject tobj = objects.nextElement();
         if(tobj != null)
            tobj.paint(g2, width, height);
      }
   }
}
