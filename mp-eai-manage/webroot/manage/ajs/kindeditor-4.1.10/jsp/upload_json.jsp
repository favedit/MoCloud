<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.json.simple.*" %>
<%@ page import="org.mo.com.lang.*" %>
<%@ page import="org.mo.core.aop.*" %>
<%@ page import="org.mo.web.core.upload.*" %>
<%@ page import="org.mo.cloud.core.storage.*" %>
<%!
private String getError(String message) {
   JSONObject obj = new JSONObject();
   obj.put("error", 1);
   obj.put("message", message);
   return obj.toJSONString();
}
%>
<%
// 检查内容
response.setContentType("text/html; charset=UTF-8");
if(!ServletFileUpload.isMultipartContent(request)){
   out.println(getError("请选择文件---。"));
   return;
}
//............................................................
// 获得上传控制台
IWebUploadConsole uploadConsole = RAop.find(IWebUploadConsole.class);
String savePath = uploadConsole.directory();
String saveUrl  = null;
// 检查目录
File uploadDir = new File(savePath);
if(!uploadDir.isDirectory()){
   out.println(getError("上传目录不存在。"));
   return;
}
// String sUploadFileName = RFile.makeFilename(savePath, RUuid.uuid());
// 获得存储控制台
IGcStorageConsole storageConsole = RAop.find(IGcStorageConsole.class);
//............................................................
// 定义允许上传的文件扩展名
HashMap<String, String> extMap = new HashMap<String, String>();
extMap.put("image", "gif,jpg,jpeg,png,bmp");
extMap.put("flash", "swf,flv");
extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
// 最大文件大小
int maxSize = 1024*1024*8;
//检查目录写权限
if(!uploadDir.canWrite()){
	out.println(getError("上传目录没有写权限。"));
	return;
}
String dirName = request.getParameter("dir");
if(dirName == null) {
	dirName = "image";
}
if(!extMap.containsKey(dirName)){
	out.println(getError("目录名不正确。"));
	return;
}
// 创建文件夹
savePath += dirName + "/";
saveUrl += dirName + "/";
File saveDirFile = new File(savePath);
if (!saveDirFile.exists()) {
	saveDirFile.mkdirs();
}
String date = RDateTime.format("yyyymmdd");
savePath += date + "/";
saveUrl += date + "/";
File dirFile = new File(savePath);
if (!dirFile.exists()) {
	dirFile.mkdirs();
}
//............................................................
DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setSizeThreshold(maxSize);
ServletFileUpload upload = new ServletFileUpload(factory);
upload.setHeaderEncoding("UTF-8");
List items = upload.parseRequest(request);
Iterator iterator = items.iterator();
while(iterator.hasNext()){
	FileItem item = (FileItem)iterator.next();
	String fileName = item.getName();
	long fileSize = item.getSize();
	if (!item.isFormField()) {
		//检查文件大小
		if(item.getSize() > maxSize){
			out.println(getError("上传文件大小超过限制。"));
			return;
		}
		//检查扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
			out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
			return;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
		String storeFileName = null;
		File uploadedFile = null;
		try{
			uploadedFile = new File(savePath, newFileName);
			item.write(uploadedFile);
		}catch(Exception e){
			out.println(getError("上传文件失败。"));
			return;
		}
		String url = saveUrl + newFileName;
		// 上传到存储服务器
		SGcStorage storage = new SGcStorage(EGcStorageCatalog.TempUpload, uploadedFile);
		if(storageConsole.store(storage)){
		    url = storageConsole.makeUrl(storage);
		    uploadedFile.delete();
		}
		// 返回内容
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("url", url);
		out.println(obj.toJSONString());
	}
}
%>
