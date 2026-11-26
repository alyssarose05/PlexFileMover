@echo off
@setlocal EnableExtensions EnableDelayedExpansion

REM /** PlexFileMover: © Copyright 2026 Alyssa Ayala | ara1105
REM - Built to manage Plex and other media server directories by grouping files (videos, subtitles, etc.) of the same name into their respective folders.
REM THIS SOFTWARE IS DISTRIBUTED FREE OF CHARGE AND ON AN OPEN-SOURCE BASIS, WITH NO WARRANTY OF ANY KIND. YOU MAY USE IT AS YOU LIKE, PROVIDED YOU INCLUDE THE ATTACHED LICENSE. **/

REM Get current directory
set "currDir=%~dp0"

REM Loop through current directory
for /f "delims=" %%F in ('dir /b /a-d') do (
	
	REM file name without extension
	set "fileName=%%~NF"
	
	if not "!fileName!"=="PlexFileMover" ( REM Disregard PlexFileMover files
		
		REM Get folder path, and make folder if not already done
		set "folderPath=!currDir!!fileName!"
		if not exist !folderPath! mkdir !folderPath!
		
		REM Move file to folder without prompt
		move /Y %%F !folderPath!
	)
)