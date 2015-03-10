@CLS

@SET HOME=E:\Microbject
@SET SOURCE=%HOME%\MoCloud
@SET TARGET=%HOME%\AliSvn-Microbject

xcopy /E /I /Y %SOURCE%\mp-cloud-content\webroot %TARGET%\cloud.content\webroot
xcopy /E /I /Y %HOME%\MoScript\source\ajs %TARGET%\cloud.content\script\ajs
