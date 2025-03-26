import java.io.File;

public class Renamer {
	
	public static void main(String[] args) {

		File dir = new File(System.getProperty("user.dir"));
		replacement(dir.listFiles(), args[0], args[1], args[2]);
	}

	public static void replacement(File[] files, String delimeter, String oldWord, String newWord) {
		for (File f: files) {
			String master = delimeter + oldWord;

			// Go into sub-directory
			if (f.isDirectory()) {
				replacement(f.listFiles(), delimeter, oldWord, newWord);
			}


			String g = f.getPath();
			String target = delimeter + newWord;

			if (f.getName().indexOf(master) != -1) {
				String newName = f.getPath().replace(master, target);
				f.renameTo(new File(newName));
			}
			
		}
	}
}