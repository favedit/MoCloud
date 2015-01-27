@CLS

@SET HOME=%cd%

@SET HOME_SERVER=%HOME%\tomcat-cloud.develop\conf
COPY /Y %HOME_SERVER%\server.work.xml %HOME_SERVER%\server.xml

@SET HOME_SERVER=%HOME%\tomcat-cloud.design\conf
COPY /Y %HOME_SERVER%\server.work.xml %HOME_SERVER%\server.xml

@SET HOME_SERVER=%HOME%\tomcat-cloud.content\conf
COPY /Y %HOME_SERVER%\server.work.xml %HOME_SERVER%\server.xml

@SET HOME_SERVER=%HOME%\tomcat-cloud.storage\conf
COPY /Y %HOME_SERVER%\server.work.xml %HOME_SERVER%\server.xml
