#!/bin/bash

for file in $(ls)
do
	if [[ ! -d $file ]] && [[ ! $file = "PlexFileMover.sh" ]]
	then

		# Get file name without extension
		name="${file%.*}"
		
		# Make directory if it doesn't exist already
		if [ ! -d $name ]
		then
			mkdir $name
		fi

		# Move file to respective directory
		mv $file $name
		echo $name
	fi
done
	