#!/bin/bash

# /** PlexFileMover: © Copyright 2026 Alyssa Ayala | ara1105
# - Built to manage Plex and other media server directories by grouping files (videos, subtitles, etc.) of the same name into their respective folders.
# THIS SOFTWARE IS DISTRIBUTED FREE OF CHARGE AND ON AN OPEN-SOURCE BASIS, WITH NO WARRANTY OF ANY KIND. YOU MAY USE IT AS YOU LIKE, PROVIDED YOU INCLUDE THE ATTACHED LICENSE. *//

# All files in current directory
currDir=$($PWD)

# Loop through regular files: items
files=()
for item in *; do
	# Get the folder for the item
	[ -f "$item" ] && files+=("$item")
	folder=("${item%.*}")
	
	# Create (if needed) and move the file there
	if [[ "$folder" != *"PlexFileMover"* ]]; then # Ignore PlexFileMover files
		mkdir -p "$folder"
		mv "$item" "$folder"/
	fi
done