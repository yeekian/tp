@echo off
setlocal enableextensions
pushd %~dp0

cd ..
call gradlew clean shadowJar

cd build\libs
for /f "tokens=*" %%a in (
    'dir /b *.jar'
) do (
    set jarloc=%%a
)

:: delete data directory from previous run if it exists
if exist "..\..\text-ui-test\data" (
    rmdir /s /q "..\..\text-ui-test\data"
)

:: copy data_init to data
xcopy "..\..\text-ui-test\data_init" "..\..\text-ui-test\data" /s /e /i

java -jar %jarloc% < ..\..\text-ui-test\input.txt > ..\..\text-ui-test\ACTUAL.TXT

cd ..\..\text-ui-test

FC ACTUAL.TXT EXPECTED.TXT >NUL && ECHO Test passed! || Echo Test failed!
