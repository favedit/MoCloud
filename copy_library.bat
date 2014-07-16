@CLS

@SET HOME=E:\ZW-MoCloud
@SET HOME_SOURCE=%HOME%\library

@SET HOME_TARGET=%HOME%\mp-cloud-service\webroot\WEB-INF\lib\
COPY /Y %HOME_SOURCE%\mo-common.jar %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-cloud-manage\webroot\WEB-INF\lib\
COPY /Y %HOME_SOURCE%\mo-common.jar %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar %HOME_TARGET%
