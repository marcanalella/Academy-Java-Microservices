import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void main(String[] args) throws IOException {

		try (InputStream is = new FileInputStream("src/Main.java");
				OutputStream os = new FileOutputStream("/tmp/pippo")) {

			for (;;) {
				int b = is.read();

				if (b < 0) {
					break;
				}

				os.write(b);

				System.out.print((char) b);
			}
		}

		byte[] buffer = new byte[1024 * 64];
		try (InputStream is = new FileInputStream("src/Main.java");
				OutputStream os = new FileOutputStream("/tmp/pippo")) {

			for (;;) {
				int n = is.read(buffer);

				if (n < 0) {
					break;
				}

				os.write(buffer, 0, n);
			}
		}

		// String x = "\u1234";
		char[] cBuffer = new char[16 * 1024];
		try (Reader r = new FileReader("src/Main.java"); Writer w = new FileWriter("/tmp/pippo2")) {
			for (;;) {
				int n = r.read(cBuffer);

				if (n < 0) {
					break;
				}

				w.write(cBuffer, 0, n);
			}
		}

		// èéàòìùç€
		try (Reader r = new InputStreamReader(new FileInputStream("src/Main.java"), StandardCharsets.UTF_8);
				Writer w = new OutputStreamWriter(new FileOutputStream("/tmp/pippo2"), StandardCharsets.ISO_8859_1)) {

			for (;;) {
				int n = r.read(cBuffer);

				if (n < 0) {
					break;
				}

				w.write(cBuffer, 0, n);
			}
		}

		try (BufferedReader r = new BufferedReader(new FileReader("src/Main.java"));
				BufferedWriter w = new BufferedWriter(new FileWriter("/tmp/pippo2"))) {

			for (;;) {
				String s = r.readLine();

				if (s == null) {
					break;
				}

				w.write(s);
				w.newLine();
			}
		}

		try (BufferedReader r = new BufferedReader(new FileReader("src/Main.java"));
				PrintWriter w = new PrintWriter(new FileWriter("/tmp/pippo2"))) {

			for (;;) {
				String s = r.readLine();

				if (s == null) {
					break;
				}

				w.println(s);
			}
		}
		
		File file = new File("/tmp/pippo");
		file.isDirectory();
		file.isAbsolute();
		file.isFile();
		file.isHidden();
		file.exists();
		
		file.delete();
		File[] files = file.listFiles();
		
		byte[] bytes = new byte[100000];
		// somebody writes into bytes
		new ByteArrayInputStream(bytes);
		
		new ByteArrayOutputStream();
		new StringReader("xxx");
		new StringWriter();
		
//		new BufferedInputStream(in);
//		new BufferedOutputStream(out);
		
	}
}
