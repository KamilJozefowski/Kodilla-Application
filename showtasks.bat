call runcrud
if "%ERRORLEVEL%" == "0" goto goToLink
echo Run script RUNCRUD has errors – breaking work
goto fail

:goToLink
start "" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open link
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.