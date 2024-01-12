@echo off
title PlexFileMover.bat
for %%f in (*.*) do (
	if NOT "%%f" == "PlexFileMover.bat" (
		
		REM Create directory if it doesn't exist, and more corresponding file to it
		if NOT exist "%cd%/%%~nf" mkdir "%cd%/%%~nf"
		move %%f "%cd%/%%~nf"
		echo %%~nf
		
	)
)
pause