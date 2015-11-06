package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil
{
   public DateUtil(){
   }

   /** 
    * @see     取得当前日期（格式为：yyyy-MM-dd） 
    * @return String 
    */
   public static String GetDate(){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String sDate = sdf.format(new Date());
      return sDate;
   }

   public static String GetDate(String strDate){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      try{
         Date sDate = sdf.parse(strDate);
         return sdf.format(sDate);
      }catch(ParseException e){
         e.printStackTrace();
         return null;
      }
   }

   public static String GetFormatDate(String format){
      try{
         SimpleDateFormat sdf = new SimpleDateFormat(format);
         Date sDate = new Date();
         return sdf.format(sDate);
      }catch(Exception e){
         e.printStackTrace();
         return null;
      }
   }

   public static Date GetDate2(String strDate,
                               String format){
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      try{
         return sdf.parse(strDate);
      }catch(ParseException e){
         e.printStackTrace();
         return null;
      }
   }

   /** 
    * @see     取得当前时间（格式为：yyy-MM-dd HH:mm:ss） 
    * @return String 
    */
   public static String GetDateTime(){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String sDate = sdf.format(new Date());
      return sDate;
   }

   public static String GetTime(){
      SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
      String sDate = sdf.format(new Date());
      return sDate;
   }

   /** 
    * @see     按指定格式取得当前时间() 
    * @return String 
    */
   public static String GetTimeFormat(String strFormat){
      SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
      String sDate = sdf.format(new Date());
      return sDate;
   }

   /** 
    * @see     取得指定时间的给定格式() 
    * @return String 
    * @throws ParseException 
    */
   public static String SetDateFormat(String myDate,
                                      String strFormat) throws ParseException{

      SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
      String sDate = sdf.format(sdf.parse(myDate));

      return sDate;
   }

   public static String FormatDateTime(String strDateTime,
                                       String strFormat){
      String sDateTime = strDateTime;
      try{
         Calendar Cal = parseDateTime(strDateTime);
         SimpleDateFormat sdf = null;
         sdf = new SimpleDateFormat(strFormat);
         sDateTime = sdf.format(Cal.getTime());
      }catch(Exception e){

      }
      return sDateTime;
   }

   public static Calendar parseDateTime(String baseDate){
      Calendar cal = null;
      cal = new GregorianCalendar();
      int yy = Integer.parseInt(baseDate.substring(0, 4));
      int mm = Integer.parseInt(baseDate.substring(5, 7)) - 1;
      int dd = Integer.parseInt(baseDate.substring(8, 10));
      int hh = 0;
      int mi = 0;
      int ss = 0;
      if(baseDate.length() > 12){
         hh = Integer.parseInt(baseDate.substring(11, 13));
         mi = Integer.parseInt(baseDate.substring(14, 16));
         ss = Integer.parseInt(baseDate.substring(17, 19));
      }
      cal.set(yy, mm, dd, hh, mi, ss);
      return cal;
   }

   public static int getDay(String strDate){
      Calendar cal = parseDateTime(strDate);
      return cal.get(Calendar.DATE);
   }

   public static int getMonth(String strDate){
      Calendar cal = parseDateTime(strDate);

      return cal.get(Calendar.MONTH) + 1;
   }

   public static int getWeekDay(String strDate){
      Calendar cal = parseDateTime(strDate);
      return cal.get(Calendar.DAY_OF_WEEK);
   }

   public static String getWeekDayName(String strDate){
      String mName[] = {"日", "一", "二", "三", "四", "五", "六"};
      int iWeek = getWeekDay(strDate);
      iWeek = iWeek - 1;
      return "星期" + mName[iWeek];
   }

   public static int getYear(String strDate){
      Calendar cal = parseDateTime(strDate);
      return cal.get(Calendar.YEAR) + 1900;
   }

   public static String DateAdd(String strDate,
                                int iCount,
                                int iType){
      try{
         Calendar Cal = parseDateTime(strDate);
         int pType = 0;
         if(iType == 0){
            pType = 1;
         }else if(iType == 1){
            pType = 2;
         }else if(iType == 2){
            pType = 5;
         }else if(iType == 3){
            pType = 10;
         }else if(iType == 4){
            pType = 12;
         }else if(iType == 5){
            pType = 13;
         }
         Cal.add(pType, iCount);
         SimpleDateFormat sdf = null;
         if(iType <= 2)
            sdf = new SimpleDateFormat("yyyy-MM-dd");

         else
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String sDate = sdf.format(Cal.getTime());
         return sDate;
      }catch(Exception e){
         // TODO Auto-generated catch block
         e.printStackTrace();
         return null;
      }
   }

   /**
    * 取时
    * @param strStartDate
    * @return
    */
   public static String GetHh(String strStartDate){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      SimpleDateFormat hh = new SimpleDateFormat("HH");
      Date dd;
      String sDate = strStartDate;
      try{
         dd = sdf.parse(strStartDate);
         sDate = hh.format(dd);
      }catch(ParseException e){
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return sDate;
   }

   /**
    * 取分
    * @param strStartDate
    * @return
    */
   public static String GetMm(String strStartDate){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      SimpleDateFormat hh = new SimpleDateFormat("mm");
      Date dd;
      String sDate = strStartDate;
      try{
         dd = sdf.parse(strStartDate);
         sDate = hh.format(dd);
      }catch(ParseException e){
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return sDate;
   }

   public static String DateAdd(String strOption,
                                int iDays,
                                String strStartDate){
      if(!strOption.equals("d"))
         ;
      return strStartDate;
   }

   //给开始时间,结束时间
   public static int DateDiff(String strDateBegin,
                              String strDateEnd,
                              int iType){
      Calendar calBegin = parseDateTime(strDateBegin);
      Calendar calEnd = parseDateTime(strDateEnd);
      long lBegin = calBegin.getTimeInMillis();
      long lEnd = calEnd.getTimeInMillis();
      int ss = (int)((lEnd - lBegin) / 1000L);
      int min = ss / 60;
      int hour = min / 60;
      int day = hour / 24;
      if(iType == 0)
         return hour;
      if(iType == 1)
         return min;
      if(iType == 2)
         return day;
      else
         return -1;
   }

   /***************************************** 
    * @功能     判断某年是否为闰年 
    * @return  boolean 
    * @throws ParseException 
    ****************************************/
   public static boolean isLeapYear(int yearNum){
      boolean isLeep = false;
      /**判断是否为闰年，赋值给一标识符flag*/
      if((yearNum % 4 == 0) && (yearNum % 100 != 0)){
         isLeep = true;
      }else if(yearNum % 400 == 0){
         isLeep = true;
      }else{
         isLeep = false;
      }
      return isLeep;
   }

   /***************************************** 
   * @功能     计算当前日期某年的第几周 
   * @return  interger 
   * @throws ParseException 
   ****************************************/
   public static int getWeekNumOfYear(){
      Calendar calendar = Calendar.getInstance();
      int iWeekNum = calendar.get(Calendar.WEEK_OF_YEAR);
      return iWeekNum;
   }

   /***************************************** 
    * @功能     计算指定日期某年的第几周 
    * @return  interger 
    * @throws ParseException 
    ****************************************/
   public static int getWeekNumOfYearDay(String strDate) throws ParseException{
      Calendar calendar = Calendar.getInstance();
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      Date curDate = format.parse(strDate);
      calendar.setTime(curDate);
      int iWeekNum = calendar.get(Calendar.WEEK_OF_YEAR);
      return iWeekNum;
   }

   /***************************************** 
    * @功能     计算某年某周的开始日期 
    * @return  interger 
    * @throws ParseException 
    ****************************************/
   public static String getYearWeekFirstDay(int yearNum,
                                            int weekNum) throws ParseException{

      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, yearNum);
      cal.set(Calendar.WEEK_OF_YEAR, weekNum);
      cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
      //分别取得当前日期的年、月、日  
      String tempYear = Integer.toString(yearNum);
      String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
      String tempDay = Integer.toString(cal.get(Calendar.DATE));
      String tempDate = tempYear + "-" + tempMonth + "-" + tempDay;
      return SetDateFormat(tempDate, "yyyy-MM-dd");

   }

   /***************************************** 
    * @功能     计算某年某周的结束日期 
    * @return  interger 
    * @throws ParseException 
    ****************************************/
   public static String getYearWeekEndDay(int yearNum,
                                          int weekNum) throws ParseException{
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, yearNum);
      cal.set(Calendar.WEEK_OF_YEAR, weekNum + 1);
      cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
      //分别取得当前日期的年、月、日  
      String tempYear = Integer.toString(yearNum);
      String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
      String tempDay = Integer.toString(cal.get(Calendar.DATE));
      String tempDate = tempYear + "-" + tempMonth + "-" + tempDay;
      return SetDateFormat(tempDate, "yyyy-MM-dd");
   }

   /***************************************** 
    * @功能     计算某年某月的开始日期 
    * @return  interger 
    * @throws ParseException 
    ****************************************/
   public static String getYearMonthFirstDay(int yearNum,
                                             int monthNum) throws ParseException{

      //分别取得当前日期的年、月、日  
      String tempYear = Integer.toString(yearNum);
      String tempMonth = Integer.toString(monthNum);
      String tempDay = "1";
      String tempDate = tempYear + "-" + tempMonth + "-" + tempDay;
      return SetDateFormat(tempDate, "yyyy-MM-dd");

   }

   /***************************************** 
    * @功能     计算某年某月的结束日期 
    * @return  interger 
    * @throws ParseException 
    ****************************************/
   public static String getYearMonthEndDay(int yearNum,
                                           int monthNum) throws ParseException{

      //分别取得当前日期的年、月、日  
      String tempYear = Integer.toString(yearNum);
      String tempMonth = Integer.toString(monthNum);
      String tempDay = "31";
      if(tempMonth.equals("1") || tempMonth.equals("3") || tempMonth.equals("5") || tempMonth.equals("7") || tempMonth.equals("8") || tempMonth.equals("10") || tempMonth.equals("12")){
         tempDay = "31";
      }
      if(tempMonth.equals("4") || tempMonth.equals("6") || tempMonth.equals("9") || tempMonth.equals("11")){
         tempDay = "30";
      }
      if(tempMonth.equals("2")){
         if(isLeapYear(yearNum)){
            tempDay = "29";
         }else{
            tempDay = "28";
         }
      }
      //System.out.println("tempDay:" + tempDay);  
      String tempDate = tempYear + "-" + tempMonth + "-" + tempDay;
      return SetDateFormat(tempDate, "yyyy-MM-dd");

   }

   /**
    * 某年某月某周的周几是多少号
    * @param year
    * @param month
    * @param weekOfMonth
    * @param dayOfWeek
    * @return
    */
   public static String weekdatetodata(int year,
                                       int month,
                                       int weekOfMonth,
                                       int dayOfWeek){
      Calendar c = Calendar.getInstance();
      //计算出 x年 y月 1号 是星期几
      c.set(year, month - 1, 1);

      //如果i_week_day =1 的话 实际上是周日  
      int i_week_day = c.get(Calendar.DAY_OF_WEEK);

      int sumDay = 0;
      //dayOfWeek+1 就是星期几（星期日 为 1）
      if(i_week_day == 1){
         sumDay = (weekOfMonth - 2) * 7 + dayOfWeek + 1;
      }else{
         sumDay = 7 - i_week_day + 1 + (weekOfMonth - 2) * 7 + dayOfWeek + 1;
      }
      //在1号的基础上加上相应的天数
      c.set(Calendar.DATE, sumDay);
      SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
      return sf2.format(c.getTime());
   }

   /**
    * 某年某月的天数
    * @param year
    * @param month
    * @return
    */
   public static int days(int year,
                          int month){
      int days = 0;
      if(month != 2){
         switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
               days = 31;
               break;
            case 4:
            case 6:
            case 9:
            case 11:
               days = 30;

         }
      }else{

         if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            days = 29;
         else
            days = 28;

      }
      return days;
   }

   /**
    * 返回整数周
    * @param year
    * @param month
    * @param n
    * @return
    */
   public static int getCustomIntWeek(int year,
                                      int month,
                                      int n){
      //GregorianCalendar g = new GregorianCalendar();
      int week = 1;
      int w = n / 7 + 1;
      switch(w){
         case 1:
            week = 1;
            break;
         case 2:
            week = 2;
            break;
         case 3:
            week = 3;
            break;
         case 4:
            week = 4;
            break;
         case 5:
            week = 5;
            break;
         default:
            week = 0;
            break;
      }
      return week;
   }

   /**
    * 自定义周1-7号第一个星期，8-14第二个星期
    * @param n:多少号
    */
   public static String getCustomWeek(int year,
                                      int month,
                                      int n){
      GregorianCalendar g = new GregorianCalendar();
      String weeks = "第1周1号-7号";
      if(n > g.getActualMaximum(Calendar.DAY_OF_MONTH)){
         System.out.println(g.getActualMaximum(Calendar.DAY_OF_MONTH));
         System.out.println("超过当前月的最大允许值");
         //System.exit(1);
      }else{
         int w = n / 7 + 1;
         switch(w){
            case 1:
               weeks = "第1周1号-7号";
               break;
            case 2:
               weeks = "第2周8号-14号";
               break;
            case 3:
               weeks = "第3周15号-21号";
               break;
            case 4:
               weeks = "第4周22号-28号";
               break;
            case 5:
               weeks = "第5周29号-" + days(year, month) + "号";
               break;
            default:
               weeks = "错误的日期";
               break;
         }
      }
      return weeks;
   }

   //字符转日期格式化
   public static Date strChangeDate(String formate,
                                    String datetime){
      DateFormat df = new SimpleDateFormat(formate);
      Date d = null;
      try{
         d = df.parse(datetime);
      }catch(Exception e){
         e.printStackTrace();
      }
      return d;
   }

   public static String getTimeSegment(String timeSegment){
      switch(timeSegment){
         case "00":
         case "01":
         case "02":
            timeSegment = "1";
            break;
         case "03":
         case "04":
         case "05":
            timeSegment = "2";
            break;
         case "06":
         case "07":
         case "08":
            timeSegment = "3";
            break;
         case "09":
         case "10":
         case "11":
            timeSegment = "4";
            break;
         case "12":
         case "13":
         case "14":
            timeSegment = "5";
            break;
         case "15":
         case "16":
         case "17":
            timeSegment = "6";
            break;
         case "18":
         case "19":
         case "20":
            timeSegment = "7";
            break;
         case "21":
         case "22":
         case "23":
            timeSegment = "8";
            break;
         default:
            timeSegment = "1";
            break;
      }
      return timeSegment;
   }

   /**
   * @param args
   */
   public static void main(String args[]){
      //System.out.println("天数差值="+DateDiff("2011-05-29","2011-06-01",2));
      //Date d = DateUtils.strChangeDate("yyyy-MM-dd HH:mm", "2004-03-26 13:31:40");
      System.out.println("d::" + GetFormatDate("yyyyMM"));
      System.out.println("20150916235959".substring(8, 10));
      System.out.println(getTimeSegment("05"));
   }
}
