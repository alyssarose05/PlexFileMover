// FILE HANDLING
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// FILE ACTIONS
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

// ArrayList
import java.util.List;
import java.util.ArrayList;

// HashMap
import java.util.HashMap;
import java.util.Map;

/** 
	PlexFileMover: © Copyright 2026 Alyssa Ayala | ara1105
	- Built to manage Plex and other media server directories by grouping files (videos, subtitles, etc.) of the same name into their respective folders.

	THIS SOFTWARE IS DISTRIBUTED FREE OF CHARGE AND ON AN OPEN-SOURCE BASIS, WITH NO WARRANTY OF ANY KIND. YOU MAY USE IT AS YOU LIKE, PROVIDED YOU INCLUDE THE ATTACHED LICENSE.


**/
public class PlexFileMover {
	
	public static void main(String[] args) {
		
		/* 
			STEP 1: GET PATHS OF MEDIA FILES, stored in ArrayList mediaFiles.
		*/
		Path mediaDir = Path.of("").toAbsolutePath();
		List<Path> mediaFiles = new ArrayList<>();
		
		try (Stream<Path> stream = Files.list(mediaDir)) {
			List<Path> files = stream // Fetch the file paths into a list
				.filter(Files::isRegularFile)
				.toList();
			
			for (Path file: files) { // Add paths of media paths to ArrayList mediaFiles
				if (!mediaFiles.contains(file) && !file.toString().contains("PlexFileMover")) {
					mediaFiles.add(file);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* 
			STEP 2: MAKE HASHMAP OF FOLDER NAMES AND PATHS, folderMap.
				@key: The folder's name
				@value: The folder's path
		*/
		Map<String, Path> folderMap = new HashMap<>();
		
		for (Path file: mediaFiles) {
			
			// Get media name without path or extension
			String fileName = file.getFileName().toString();
			int dotIndex = fileName.lastIndexOf('.');
			String mediaName = fileName.substring(0, dotIndex);
			
			if (!folderMap.containsKey(mediaName)) { // Create and get folder paths for each unique media
				// Complete folder map entry: a media name and its folder
				Path mediaPath = Paths.get(mediaDir + "/" + mediaName);
				//System.out.println(mediaPath);
				folderMap.put(mediaName, mediaPath);
				
				try { // Create the folder in the current directory
					Files.createDirectories(mediaPath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		/* 
			STEP 3: MOVE MEDIA FILES TO THEIR RESPECTIVE FOLDERS.
		*/
		for (Path file: mediaFiles) {
			for (Map.Entry<String, Path> entry : folderMap.entrySet()) {
				if (file.toString().contains(entry.getKey())) { // Found the folder the file should be moved to
					
					System.out.println(entry.getKey() + " = " + entry.getValue());
					Path targetDir = entry.getValue();
					
					try { // Move source file to target directory
						Path targetFile = targetDir.resolve(file.getFileName());
						Files.move(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}