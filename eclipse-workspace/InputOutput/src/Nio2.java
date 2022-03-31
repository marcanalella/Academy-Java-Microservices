import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Nio2 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/Main.java");
		File file = path.toFile();
		System.out.println("Exists? " + Files.exists(path));
		System.out.println("Exists? " + Files.exists(path, LinkOption.NOFOLLOW_LINKS));
		
//		InputStream is = new FileInputStream(path.toFile());
		InputStream is = Files.newInputStream(path, 
				StandardOpenOption.SYNC, StandardOpenOption.DSYNC);
		
		byte[] bytes = Files.readAllBytes(path);
		List<String> strings = Files.readAllLines(path, StandardCharsets.UTF_8);
		
//		Files.readAllLines(path, StandardCharsets.UTF_8).stream().....;
		
		try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
			List<String> identifiers =
				stream.filter(s -> !(s.contains("{") || s.contains("}")))
	     			  .map(s -> s.replaceAll("[,;=\\*\\.\\[\\]\\(\\)]", " "))
					  .map(String::trim)
					  .filter(s -> !s.isEmpty())
					  .flatMap(s -> Stream.of(s.split(" +")))
					  .distinct()
					  .sorted()
					  .collect(Collectors.toList());
//					  .forEach(System.out::println);
			System.out.println(identifiers);
//			stream.forEach((t) -> System.out.println(t));
		}
	}
}
