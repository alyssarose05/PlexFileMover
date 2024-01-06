import java.io.File;

public class PlexFileMover {
	public static void main(String[] args) {

		// Get the current working directory
		File dir = new File(System.getProperty("user.dir"));
		if (dir.isDirectory()) {
			start(dir.listFiles(), dir.getPath());
		}
	}

	public static void start(File[] files, String dir) {
		for (File file: files) {
			if (!file.isDirectory() && !file.getName().equals("PlexFileMover.jar")) {
				
				// Get file paths and names without extensions
				File f = new File(dir + "/" + file.getName());
				String path = f.getPath().replaceFirst("[.][^.]+$", "");
				String name = f.getName().replaceFirst("[.][^.]+$", "");
				
				// Make directories and move files
				File moved = new File(path);
				moved.mkdir();
				f.renameTo(new File (moved.getPath() + "/" + file.getName()));
				System.out.println(moved.getName());
				
			}
		}
	}

}