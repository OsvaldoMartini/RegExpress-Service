@echo off


SETLOCAL

set JAVA_HOME=C:\Java Tools\jdk1.8.0_144
set path=C:\Java Tools\jdk1.8.0_144\bin;%path%

set MAVE_HOME=C:\Appl\apache-maven-3.5.2
set path=%MAVE_HOME%\bin;%path%

set M2_HOME=C:\Appl\apache-maven-3.5.2
set path=%M2_HOME%\bin;%path%


call mvn spring-boot:run 


ENDLOCAL
