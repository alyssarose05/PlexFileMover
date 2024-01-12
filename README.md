# <img src="https://github.com/alyssarose05/PlexFileMover/blob/main/Images/Plex_logo_2022.svg.png" width="40" height="40"> PlexFileMover



Do you own a large Plex server filled with hundreds or even thousands of media files? In the Plex community, it is known that you should move each media file into its own folder to keep things like subtitles and posters together. But wouldn't that take too much time?
If you use my PlexFileMover tool, you can save _hours_ of creating and moving files, as it will do it all in minutes at most. 

## How it works
Here's a demonstration using Windows. If you're using Linux, replace it with the `PlexFileMover.sh` file. Let's say that this is your server before running the program:<br>
![](Images/before.png)<br>

You would like these videos to be put into their own folders, right? Once you run the program, the name of each file that's been moved will appear in the console/terminal in real time to keep you up-to-date on the progress. You can check each new directory to make sure that the corresponding file is indeed in that folder. As long as each file such as the subtitles has the same name as its corresponding movie, you should find it all in that folder.<br>
![](Images/cmd.png)

 Here is the result, which was complete in approximately 2 seconds on a 64-bit Windows 11 machine:<br>
![](Images/after.png)<br>
Note that the `PlexFileMover.jar` or `PlexFileMover.sh` file is intentionally left out so it can easily be found again. Obviously, this is a _small_ example. I ran the same program on my father's Plex server with about a thousand movies and TV shows, and it took about two minutes to complete.

## Linux/Bash installation
If you use Linux to navigate through your computer, then you only need to download the `PlexFileMover.sh` file and move it to the same location as your Plex server.<br>
If you want to make sure that you can run it before trying to do so, you can manually give yourself executable permissions with the command `chmod +x PlexFileMover.sh`. Then run it using the command `./PlexFileMover.sh` in your Linux terminal. 

## JDK installation for Windows and MAC users
If you do not use Linux, then you can use Java, but note that you will need the JDK (Java Development Kit) installed on your computer. First, you will need to download an up-to-date JDK so that you can run .jar files in the command prompt. Find the latest JDK version <a href="https://www.oracle.com/java/technologies/downloads/#jdk21-windows">here.</a> 

If you've successfully installed the JDK, typing `javac -version` into your terminal should give you the current version that you have:<br>
![](Images/javac.png)<br>
If you want to be extra sure, you can also make sure that you have the Java runtime environment installed with the `java -version` command:<br>
![](Images/java.png)<br>

To run the program, put the `PlexFileMover.jar` file into the same location as your Plex server. Then open the terminal in the same place and type in this command: `java -jar PlexFileMover.jar`. 
