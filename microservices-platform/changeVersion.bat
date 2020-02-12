@echo on
@echo =============================================================
@echo $                                                           $
@echo $                Microservices-Platform                  $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $   All Right Reserved                                   $
@echo $  Copyright (C) 2019-2050                                  $
@echo $                                                           $
@echo =============================================================
@echo.
@echo off

@title  Microservices-Platform
@color 0e

set /p version=������汾��:

call mvn versions:set -DnewVersion=%version%

call mvn versions:commit

pause