@echo off
REM simple batch file that echoes text to a file and strips the quote marks

ECHO %~1 >> "%~f2"
EXIT /B 0