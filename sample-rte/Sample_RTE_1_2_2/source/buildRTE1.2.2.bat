@ECHO OFF

ECHO ***********************************************************************************
ECHO                        Build and install the Sample RTE
ECHO ***********************************************************************************
ECHO This bat file builds the ADL Sample Run-time Environment V1.2 installation from
ECHO scratch.  Java 2 SDK 1.4.2_02 Standard Edition must be installed.  The Java 2 SDK 
ECHO 1.3 Standard Edition and Jakarta Tomcat 5.0.16 must be installed.
ECHO
ECHO This script MUST BE RUN from within the top level Sample RTE source directory.
ECHO
ECHO ***********************************************************************************
ECHO
ECHO OFF

ECHO ********************************************************************
ECHO Begin Build and Configuration
ECHO ********************************************************************
REM
REM ***********************************************************************************
REM the following defines the location where TOMCAT 5.0.16 is installed
REM ***********************************************************************************
ECHO ********************************************************************
ECHO ADL_SRTE122_HOME Environment Variable should be defined when the Sample RTE is installed
ECHO ADL_SRTE122_HOME is %ADL_SRTE122_HOME%\jakarta-tomcat
ECHO ********************************************************************

REM ***********************************************************************************
REM                               Verify Java Version
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Verifying Java Version:
java -version
ECHO ********************************************************************


REM ***********************************************************************************
REM                              Create the folders under Tomcat
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Creating directories under ADL_SRTE122_HOME
ECHO ********************************************************************
ECHO OFF
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\menu-images
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org\adl
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org\adl\util
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org\adl\util\debug
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org\adl\samplerte
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org\adl\samplerte\util
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org\adl\samplerte\server
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\com
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\com\jspsmart
mkdir %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\com\jspsmart\upload

REM ***********************************************************************************
REM compile the debug source and create a debug jar file
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Building debug classes and jar file
ECHO ********************************************************************
mkdir debug
ECHO     DebugIndicator.java
ECHO OFF
javac -d .\debug -classpath .\debug .\org\adl\util\debug\DebugIndicator.java
cd debug
jar -cf debug.jar .\org\adl\util\debug
cd..
copy .\debug\debug.jar .\


REM ***********************************************************************************
REM compile the datamodel source and create a datamodel jar file
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Building data model classes and jar file
ECHO ********************************************************************
mkdir classfiles
ECHO     Element.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\Element.java
ECHO     CMIRequest.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIRequest.java
ECHO     DMErrorManager.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\DMErrorManager.java
ECHO     DataModelValidator.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\DataModelValidator.java
ECHO     CMICategory.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMICategory.java
ECHO     CMIResponse.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIResponse.java
ECHO     CMIScore.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIScore.java
ECHO     CMIStudentData.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIStudentData.java
ECHO     CMIComments.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIComments.java
ECHO     CMICommentsFromLms.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMICommentsFromLms.java
ECHO     CMILaunchData.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMILaunchData.java
ECHO     CMISuspendData.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMISuspendData.java
ECHO     CMIObjectiveData.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIObjectiveData.java
ECHO     CMIObjectives.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIObjectives.java
ECHO     CMIInteractionData.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIInteractionData.java
ECHO     CMIInteractions.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIInteractions.java
ECHO     CMIStudentPreference.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMIStudentPreference.java
ECHO     CMICore.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMICore.java
ECHO     SCODataManager.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\SCODataManager.java
ECHO     DataModelInterface.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\DataModelInterface.java
ECHO     CMITime.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;debug.jar .\org\adl\datamodels\cmi\CMITime.java


cd classfiles
jar -cf cmidatamodel.jar .\org\adl\datamodels
cd ..



REM ***********************************************************************************
REM compile the util source
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Building util classes
ECHO ********************************************************************
ECHO     RTEFileHandler.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles\cmidatamodel.jar;.\debug.jar .\org\adl\samplerte\util\RTEFileHandler.java


REM ***********************************************************************************
REM compile the servlet source
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Building org.adl.lms.server classes
ECHO ********************************************************************
ECHO     LMSCMIServlet.java
ECHO OFF
javac -deprecation -d .\classfiles -classpath .\classfiles\cmidatamodel.jar;.\debug.jar;%ADL_SRTE122_HOME%\jakarta-tomcat\common\lib\servlet-api.jar .\org\adl\samplerte\server\LMSCMIServlet.java
ECHO     LMSPackageHandler.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;.\debug.jar;%ADL_SRTE122_HOME%\jakarta-tomcat\common\lib\servlet-api.jar .\org\adl\samplerte\server\LMSPackageHandler.java
ECHO     LMSManifestHandler.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;%ADL_SRTE122_HOME%\jakarta-tomcat\common\endorsed\xerces.jar;%ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\ADLParser.jar;%ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\xml.jar;.\debug.jar; .\org\adl\samplerte\server\LMSManifestHandler.java


REM ***********************************************************************************
REM compile the client source and create an lmsclient jar file
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Building org.adl.lms.client classes
ECHO ********************************************************************
ECHO     ServletWriter.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;.\debug.jar .\org\adl\samplerte\client\ServletWriter.java
ECHO     ServletProxy.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;.\debug.jar .\org\adl\samplerte\client\ServletProxy.java
ECHO     LMSErrorManager.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;.\debug.jar .\org\adl\samplerte\client\LMSErrorManager.java
ECHO     APIAdapterApplet.java
ECHO OFF
javac -d .\classfiles -classpath .\classfiles;.\debug.jar;jso.jar;debug.jar .\org\adl\samplerte\client\APIAdapterApplet.java
cd classfiles
jar -cf lmsclient.jar .\org\adl\samplerte\client
cd ..


REM ***********************************************************************************
REM Set up the server files under tomcat
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Install servlets, data model and debug classes to TOMCAT
ECHO ********************************************************************
copy .\classfiles\org\adl\samplerte\util\* %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org\adl\samplerte\util
copy .\classfiles\org\adl\samplerte\server\* %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\classes\org\adl\samplerte\server

ECHO ********************************************************************
ECHO Install jars to TOMCAT
ECHO ********************************************************************
copy .\debug.jar %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl
copy .\classfiles\cmidatamodel.jar %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl
copy .\classfiles\lmsclient.jar %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl

copy .\debug.jar %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\lib
copy .\classfiles\cmidatamodel.jar %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\lib
copy .\classfiles\lmsclient.jar %ADL_SRTE122_HOME%\jakarta-tomcat\webapps\adl\WEB-INF\lib


REM ***********************************************************************************
REM cleanup the classfiles and debug build directories
REM ***********************************************************************************
ECHO ********************************************************************
ECHO Clean up the classfiles and debug build directories
ECHO ********************************************************************
IF "%OS%" == "Windows_NT" rmdir /S /Q .\classfiles
IF NOT "%OS%" == "Windows_NT" deltree /Y .\classfiles

IF "%OS%" == "Windows_NT" rmdir /S /Q .\debug
IF NOT "%OS%" == "Windows_NT" deltree /Y .\debug

ECHO ********************************************************************
ECHO Done Building Sample RTE
ECHO ********************************************************************