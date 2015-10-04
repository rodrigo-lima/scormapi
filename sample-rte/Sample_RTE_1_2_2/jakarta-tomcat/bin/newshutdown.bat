SET CATALINA_HOME="%ADL_SRTE122_HOME%\jakarta-tomcat"
if "%OS%" == "Windows_NT" cmd.exe /C %CATALINA_HOME%\bin\shutdown.bat
IF NOT "%OS%" == "Windows_NT" call command.com /e:4096 /c%CATALINA_HOME%\bin\shutdown.bat
cls