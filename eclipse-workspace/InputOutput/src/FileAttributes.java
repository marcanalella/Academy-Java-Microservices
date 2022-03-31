import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Collections;

public class FileAttributes {
	public static void main (String[] args) throws IOException {
		Path start = Paths.get(".");
		int maxDepth = 2;
		Files.walkFileTree(start, 
			   Collections.singleton(FileVisitOption.FOLLOW_LINKS), 
			   maxDepth, 
			   new FileVisitor<Path>() {
			
			
			
				public FileVisitResult preVisitDirectory(Path dir, 
						BasicFileAttributes attrs)
						throws IOException {
					System.out.printf("previsit %s\n", dir);
					return FileVisitResult.CONTINUE;
				}
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
						throws IOException {
					System.out.printf("visit %s\n", file);
					return FileVisitResult.CONTINUE;
				}
				public FileVisitResult visitFileFailed(Path file, IOException exc) 
						throws IOException {
					System.out.printf("visit fail %s %s\n", file, exc);
					return FileVisitResult.CONTINUE;
				}
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) 
						throws IOException {
					System.out.printf("postvisit %s %s\n", dir, exc);
					return FileVisitResult.CONTINUE;
				}
			});
		
		Files.walk(start, maxDepth, FileVisitOption.FOLLOW_LINKS)
			 .filter(p -> p.getFileName().toString().equals("Nio2.java"))
//			 .findFirst()
			 .forEach(System.out::println);
		     
	}

}
