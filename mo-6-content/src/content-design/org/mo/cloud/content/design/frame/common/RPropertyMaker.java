package org.mo.cloud.content.design.frame.common;

import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.RBoolean;

public class RPropertyMaker
{
   // 查看模式
   public static final String MODE_VIEW = "V";

   // 设计模式
   public static final String MODE_DESIGN = "G";

   // 搜索模式
   public static final String MODE_SEARCH = "S";

   // 插入模式
   public static final String MODE_INSERT = "I";

   // 更新模式
   public static final String MODE_UPDATE = "U";

   // 删除模式
   public static final String MODE_DELETE = "D";

   // 缩放模式
   public static final String MODE_ZOOM = "Z";

   // 打印模式
   public static final String MODE_PRINT = "P";

   //   public static final String DATE_DAY = "D";
   //
   //   public static final String DATE_HOUR = "H";
   //
   //   public static final String DATE_MINUTE = "T";
   //
   //   public static final String DATE_MONTH = "M";
   //
   //   public static final String DATE_SECOND = "S";
   //
   //   public static final String DATE_YEAR = "Y";
   //
   //   public static final String DISP_AUTO = "A";
   //
   //   public static final String DISP_DRAG = "D";
   //
   //   public static final String DISP_FIXED = "F";
   //
   //   public static final String DISP_LIST = "L";
   //
   //   public static final String EDIT_COPY = "C";
   //
   //   public static final String EDIT_SEARCH = "S";
   //
   //   public static final String PANEL_HEAD = "H";
   //
   //   public static final String PANEL_HINT = "N";
   //
   //   public static final String PANEL_SEARCH = "S";
   //
   //   public static final String PANEL_TITLE = "T";
   //
   //   public static final String PANEL_TOTAL = "A";
   //
   //   public static final String VALID_DELETE = "D";
   //
   //   public static final String VALID_INSERT = "I";
   //
   //   public static final String VALID_UPDATE = "U";

   public static String convertBoolean(XContentObject xobject,
                                       String fieldName,
                                       String flag){
      return RBoolean.toString(xobject.get(fieldName), flag, "");
   }

   public static String containsValue(String access,
                                      String value){
      return RBoolean.toString((null != access) ? access.contains(value) : false);
   }

   //============================================================
   // <T>获得显示模式。</T>
   //
   // @return 显示模式
   //============================================================
   public static String getDisplayMode2(XContentObject xobject){
      String result = "";
      result += convertBoolean(xobject, "display_view", MODE_VIEW);
      result += convertBoolean(xobject, "display_design", MODE_DESIGN);
      result += convertBoolean(xobject, "display_search", MODE_SEARCH);
      result += convertBoolean(xobject, "display_insert", MODE_INSERT);
      result += convertBoolean(xobject, "display_update", MODE_UPDATE);
      result += convertBoolean(xobject, "display_delete", MODE_DELETE);
      result += convertBoolean(xobject, "display_zoom", MODE_ZOOM);
      result += convertBoolean(xobject, "display_print", MODE_PRINT);
      return result;
   }

   //============================================================
   // <T>设置显示模式。</T>
   //
   // @param 显示模式
   //============================================================
   public static void setDisplayMode2(XContentObject xobject,
                                      String value){
      xobject.set("display_view", containsValue(value, MODE_VIEW));
      xobject.set("display_design", containsValue(value, MODE_DESIGN));
      xobject.set("display_search", containsValue(value, MODE_SEARCH));
      xobject.set("display_insert", containsValue(value, MODE_INSERT));
      xobject.set("display_update", containsValue(value, MODE_UPDATE));
      xobject.set("display_delete", containsValue(value, MODE_DELETE));
      xobject.set("display_zoom", containsValue(value, MODE_ZOOM));
      xobject.set("display_print", containsValue(value, MODE_PRINT));
   }

   //   public static String getDispMode(XContentObject xobject){
   //      String access = "";
   //      access += convertBoolean(xobject, "disp_display", MODE_DISPLAY);
   //      access += convertBoolean(xobject, "disp_search", MODE_SEARCH);
   //      access += convertBoolean(xobject, "disp_insert", MODE_INSERT);
   //      access += convertBoolean(xobject, "disp_update", MODE_UPDATE);
   //      access += convertBoolean(xobject, "disp_delete", MODE_DELETE);
   //      access += convertBoolean(xobject, "disp_zoom", MODE_ZOOM);
   //      return access;
   //   }
   //   public static String getDisplayMode(XContentObject xobject){
   //      String access = "";
   //      access += convertBoolean(xobject, "display_list", DISP_LIST);
   //      access += convertBoolean(xobject, "display_fixed", DISP_FIXED);
   //      access += convertBoolean(xobject, "display_auto", DISP_AUTO);
   //      access += convertBoolean(xobject, "display_size", DISP_SIZE);
   //      access += convertBoolean(xobject, "display_drag", DISP_DRAG);
   //      access += convertBoolean(xobject, "display_print", DISP_PRINT);
   //      return access;
   //   }

   //   public static String getEditConfig(XContentObject xobject){
   //      String access = "";
   //      access += convertBoolean(xobject, "edit_search", EDIT_SEARCH);
   //      access += convertBoolean(xobject, "edit_copy", EDIT_COPY);
   //      return access;
   //   }
   //
   //   public static String getEditDate(XContentObject xobject){
   //      String editDate = "";
   //      editDate += RBoolean.toString(xobject.innerGet("edit_year"), DATE_YEAR, "");
   //      editDate += RBoolean.toString(xobject.innerGet("edit_month"), DATE_MONTH, "");
   //      editDate += RBoolean.toString(xobject.innerGet("edit_day"), DATE_DAY, "");
   //      return editDate;
   //   }
   //
   //   public static String getEditMode(XContentObject xobject){
   //      String access = "";
   //      access += convertBoolean(xobject, "edit_insert", MODE_INSERT);
   //      access += convertBoolean(xobject, "edit_update", MODE_UPDATE);
   //      access += convertBoolean(xobject, "edit_delete", MODE_DELETE);
   //      access += convertBoolean(xobject, "edit_zoom", MODE_ZOOM);
   //      return access;
   //   }
   //
   //   public static String getEditTime(XContentObject xobject){
   //      String editDate = "";
   //      editDate += RBoolean.toString(xobject.innerGet("edit_hour"), DATE_HOUR, "");
   //      editDate += RBoolean.toString(xobject.innerGet("edit_minute"), DATE_MINUTE, "");
   //      editDate += RBoolean.toString(xobject.innerGet("edit_second"), DATE_SECOND, "");
   //      return editDate;
   //   }
   //
   //   public static String getPanelAccess(XContentObject xobject){
   //      String access = "";
   //      access += RBoolean.toString(xobject.innerGet("panel_title"), PANEL_TITLE, "");
   //      access += RBoolean.toString(xobject.innerGet("panel_head"), PANEL_HEAD, "");
   //      access += RBoolean.toString(xobject.innerGet("panel_search"), PANEL_SEARCH, "");
   //      access += RBoolean.toString(xobject.innerGet("panel_hint"), PANEL_HINT, "");
   //      access += RBoolean.toString(xobject.innerGet("panel_total"), PANEL_TOTAL, "");
   //      return access;
   //   }
   //
   //   public static String getValidAccess(XContentObject xobject){
   //      String access = "";
   //      access += RBoolean.toString(xobject.innerGet("valid_insert"), VALID_INSERT, "");
   //      access += RBoolean.toString(xobject.innerGet("valid_update"), VALID_UPDATE, "");
   //      access += RBoolean.toString(xobject.innerGet("valid_delete"), VALID_DELETE, "");
   //      return access;
   //   }
   //
   //   public static void setDispMode(XContentObject xobject,
   //                                  String value){
   //      xobject.innerSet("disp_display", containsAccess(value, MODE_DISPLAY));
   //      xobject.innerSet("disp_search", containsAccess(value, MODE_SEARCH));
   //      xobject.innerSet("disp_insert", containsAccess(value, MODE_INSERT));
   //      xobject.innerSet("disp_update", containsAccess(value, MODE_UPDATE));
   //      xobject.innerSet("disp_delete", containsAccess(value, MODE_DELETE));
   //      xobject.innerSet("disp_zoom", containsAccess(value, MODE_ZOOM));
   //   }
   //
   //   public static void setEditConfig(XContentObject xobject,
   //                                    String value){
   //      xobject.innerSet("edit_search", containsAccess(value, EDIT_SEARCH));
   //      xobject.innerSet("edit_copy", containsAccess(value, EDIT_COPY));
   //   }
   //
   //   public static void setEditDate(XContentObject xobject,
   //                                  String value){
   //      xobject.innerSet("edit_year", containsAccess(value, DATE_YEAR));
   //      xobject.innerSet("edit_month", containsAccess(value, DATE_MONTH));
   //      xobject.innerSet("edit_day", containsAccess(value, DATE_DAY));
   //   }
   //
   //   public static void setEditMode(XContentObject xobject,
   //                                  String value){
   //      xobject.innerSet("edit_insert", containsAccess(value, MODE_INSERT));
   //      xobject.innerSet("edit_update", containsAccess(value, MODE_UPDATE));
   //      xobject.innerSet("edit_delete", containsAccess(value, MODE_DELETE));
   //      xobject.innerSet("edit_zoom", containsAccess(value, MODE_ZOOM));
   //   }
   //
   //   public static void setEditTime(XContentObject xobject,
   //                                  String value){
   //      xobject.innerSet("edit_hour", containsAccess(value, DATE_HOUR));
   //      xobject.innerSet("edit_minute", containsAccess(value, DATE_MINUTE));
   //      xobject.innerSet("edit_second", containsAccess(value, DATE_SECOND));
   //   }
   //
   //   public static void setPanelAccess(XContentObject xobject,
   //                                     String value){
   //      xobject.innerSet("panel_title", containsAccess(value, PANEL_TITLE));
   //      xobject.innerSet("panel_head", containsAccess(value, PANEL_HEAD));
   //      xobject.innerSet("panel_search", containsAccess(value, PANEL_SEARCH));
   //      xobject.innerSet("panel_hint", containsAccess(value, PANEL_HINT));
   //   }
   //
   //   public static void setValidAccess(XContentObject xobject,
   //                                     String value){
   //      xobject.innerSet("valid_insert", containsAccess(value, VALID_INSERT));
   //      xobject.innerSet("valid_update", containsAccess(value, VALID_UPDATE));
   //      xobject.innerSet("valid_delete", containsAccess(value, VALID_DELETE));
   //   }
}
