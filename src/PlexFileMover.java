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
		
		// Fetch current directory
		Path currDir = Path.of("").toAbsolutePath();
		
		try (Stream<Path> stream = Files.list(currDir)) {
			
			// Fetch all file paths in current directory
			List<Path> files = stream
				.filter(Files::isRegularFile)
				.toList();
			
			for (Path file: files) { 
				if (!file.toString().contains("PlexFileMover")) { // Disregard PlexFileMover files
					
					// Get media name: no path or extension
					String fileName = file.getFileName().toString();
					int dotIndex = fileName.lastIndexOf('.');
					String mediaName = fileName.substring(0, dotIndex);
					
					// Make folder path, and the folder itself if it does not exist
					Path folderPath = Paths.get(currDir + "/" + mediaName);
					if (!Files.isDirectory(folderPath)) {
						Files.createDirectories(folderPath);
					}
					
					// Move file to its designated folder
					Path targetFile = folderPath.resolve(file.getFileName());
					Files.move(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}