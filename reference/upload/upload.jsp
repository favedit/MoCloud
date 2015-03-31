<%@ page import="java.io.*" %><%
   BufferedInputStream fileIn = new BufferedInputStream(request.getInputStream());
   String fn = request.getParameter("fileName");
   
   byte[] buf = new byte[1024];
   
   File file = new File("d:/" + fn);
   
   BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(file));
   
   while (true) {
      int bytesIn = fileIn.read(buf, 0, 1024);
      
      System.out.println(bytesIn);
      
      if (bytesIn == -1) {
         break;
      } else {
         fileOut.write(buf, 0, bytesIn);
      }
   }
   
   fileOut.flush();
   fileOut.close();
   
   out.print(file.getAbsolutePath());
%>