@echo off

set "SECRET_PLAINTEXT=You have a deep, dark fear of spiders, circa 1990"
:: Alternatively, set "SECRET_PLAINTEXT=You have a deep, dark fear of clowns, circa 1990"

for /f %%I in ('echo|set /p="%SECRET_PLAINTEXT%"^| sha256sum.exe') do set "SECRET_256_HEX=%%I"

for /f %%I in ('echo %SECRET_256_HEX% ^| find /v /c ""') do set /a "SECRET_256_HEX_LENGTH=%%I"

setlocal enabledelayedexpansion
set "SECRET_256_BIN="
for /f %%I in ('echo %SECRET_256_HEX%') do (
    set "HEX=%%I"
    set "HEX=!HEX:~0,2!"
    set "BIN="
    for /l %%J in (0, 1, 7) do (
        set /a "DEC=!HEX:~%%J,1!"
        set "BIN=!BIN! !DEC:~0,1!"
    )
    set "SECRET_256_BIN=!SECRET_256_BIN!!BIN!"
)

echo %SECRET_256_HEX_LENGTH%
