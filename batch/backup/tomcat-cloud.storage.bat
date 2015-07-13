@CLS

@SET APP_ROOT=%cd%\..

@SET CATALINA_OPTS=-Xms256m -Xmx512m
@SET CATALINA_HOME=%APP_ROOT%\mt-server\tomcat-cloud.storage
@SET MOBJ_MODE=Logic
@SET MOBJ_JS=Test
@SET MOBJ_CONFIG=application-local
@SET JAVA_OPTS=-Duser.mobj.application=%APP_ROOT% -Duser.mobj.mode=%MOBJ_MODE% -Duser.mobj.js=%MOBJ_JS% -Duser.mobj.config=%MOBJ_CONFIG%

@"%CATALINA_HOME%\bin\catalina.bat" run
