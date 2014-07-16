@CLS

@SET JAVA_HOME=C:\Program Files\Java\jdk1.8.0_05
@SET APP_ROOT=E:\ZW-MoCloud

@SET CATALINA_OPTS=-Xms256m -Xmx512m
@SET CATALINA_HOME=%APP_ROOT%\mt-server\tomcat-cloud.manage-windows-8.0.9-x64
@SET MOBJ_MODE=Logic
@SET MOBJ_JS=Test
@SET MOBJ_CONFIG=application-local
@SET JAVA_OPTS=-Duser.mobj.application=%APP_ROOT% -Duser.mobj.mode=%MOBJ_MODE% -Duser.mobj.js=%MOBJ_JS% -Duser.mobj.config=%MOBJ_CONFIG%

@"%CATALINA_HOME%\bin\catalina.bat" run
