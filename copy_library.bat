@CLS

@SET HOME=%cd%
@SET HOME_SOURCE=%HOME%\library

@SET HOME_TARGET=%HOME%\mp-cloud-develop\webroot\WEB-INF\lib\
MKDIR %HOME_TARGET%
@REM COPY /Y %HOME_SOURCE%\mo-common.jar  %HOME_TARGET%
@REM COPY /Y %HOME_SOURCE%\mo-core.jar    %HOME_TARGET%
@REM COPY /Y %HOME_SOURCE%\mo-logic.jar   %HOME_TARGET%
@REM COPY /Y %HOME_SOURCE%\mo-web.jar     %HOME_TARGET%
@REM COPY /Y %HOME_SOURCE%\mo-cloud.jar   %HOME_TARGET%
@REM COPY /Y %HOME_SOURCE%\mo-content.jar %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-cloud-editor\webroot\WEB-INF\lib\
MKDIR %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-common.jar  %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar    %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar   %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar     %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-cloud.jar   %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-content.jar %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-lib-lzma.jar %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-cloud-manage\webroot\WEB-INF\lib\
MKDIR %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-common.jar  %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar    %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar   %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar     %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-cloud.jar   %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-content.jar %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-develop-logger\webroot\WEB-INF\lib\
MKDIR %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-common.jar  %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar    %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar   %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar     %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-cloud.jar   %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-content.jar %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-eai-batch\webroot\WEB-INF\lib\
MKDIR %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-common.jar      %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar        %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar       %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar         %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-cloud.jar       %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-content.jar     %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-lib-lzma.jar    %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-eai-content.jar %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-eai-content\webroot\WEB-INF\lib\
MKDIR %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-common.jar         %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar           %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar          %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar            %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-cloud.jar          %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-content.jar        %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-lib-lzma.jar       %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-eai-content.jar    %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-eai-manage\webroot\WEB-INF\lib\
MKDIR %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-common.jar         %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar           %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar          %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar            %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-cloud.jar          %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-content.jar        %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-lib-lzma.jar       %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-eai-content.jar    %HOME_TARGET%

@SET HOME_TARGET=%HOME%\mp-eai-service\webroot\WEB-INF\lib\
MKDIR %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-common.jar         %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-core.jar           %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-logic.jar          %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-web.jar            %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-cloud.jar          %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-content.jar        %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-lib-lzma.jar       %HOME_TARGET%
COPY /Y %HOME_SOURCE%\mo-eai-content.jar    %HOME_TARGET%
