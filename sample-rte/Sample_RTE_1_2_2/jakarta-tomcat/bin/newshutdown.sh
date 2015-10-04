#!/bin/sh

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home
export ADL_SRTE122_HOME=/Users/rolima/Downloads/SCORM1_2_SampleRTE1_2_2/Sample_RTE_1_2_2
export CATALINA_HOME=$ADL_SRTE122_HOME/jakarta-tomcat

sh $CATALINA_HOME/bin/shutdown.sh

