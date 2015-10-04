echo %ADL_SRTE122_HOME%

set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_60
SET ADL_SRTE122_HOME=C:\Users\rodri\Work\Scorm-player\Sample_RTE_1_2_2
SET CATALINA_HOME=%ADL_SRTE122_HOME%\jakarta-tomcat

if "%OS%" == "Windows_NT" call cmd.exe /C %CATALINA_HOME%\bin\startup.bat
IF NOT "%OS%" == "Windows_NT" call command.com /e:4096 /c%CATALINA_HOME%\bin\startup.bat
