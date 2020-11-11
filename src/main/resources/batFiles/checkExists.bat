@echo off
REM simple bat file that checks if an inputted file exists

IF EXIST "%~f1" (
    EXIT /B 0
) ELSE (
    EXIT /B 1
)