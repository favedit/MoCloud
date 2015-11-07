package com.ahyc.eai.core.cockpit.projectmanage;

import java.io.IOException;
import org.apache.http.ParseException;

//============================================================
// <T>项目管理控制台接口。</T>
//============================================================
public interface IProjectManageConsole
{
   //============================================================
   // <T>调用其他接口返回json格式的数据</T>
   //============================================================
   public String getJson(String uid) throws ParseException, IOException;
}
