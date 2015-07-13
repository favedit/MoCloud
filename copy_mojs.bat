@CLS

@SET HOME_SOURCE=D:\Microbject\MoScript\source
@SET HOME_TARGET=D:\Microbject\MoCloud

XCOPY /E /Y %HOME_SOURCE%\ajs\release\ %HOME_TARGET%\mp-eai-content\webroot\ajs
XCOPY /E /Y %HOME_SOURCE%\eai-release  %HOME_TARGET%\mp-eai-content\webroot

