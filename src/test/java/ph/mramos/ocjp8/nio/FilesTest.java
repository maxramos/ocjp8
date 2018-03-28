package ph.mramos.ocjp8.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class FilesTest {

	@Test
	public void testCopy() throws IOException {
		Path pwd = Paths.get(".").toRealPath();
		System.out.println(pwd);

		Path path1 = Paths.get("dir\\subdir1\\test-copy");
		Path path2 = Paths.get("dir\\subdir2\\new-copy");

		if (Files.exists(path1)) {
			Path path3 = Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
			System.out.println(path3);
			System.out.println(Files.exists(path3));
			Files.delete(path1);
		} else {
			Path path3 = Files.copy(path2, path1, StandardCopyOption.REPLACE_EXISTING);
			System.out.println(path3);
			System.out.println(Files.exists(path3));
			Files.delete(path2);
		}
	}

	@Test
	public void testMove() throws IOException {
		Path path1 = Paths.get("dir\\subdir1\\test-move");
		Path path2 = Paths.get("dir\\subdir2\\new-move");

		if (Files.exists(path1)) {
			Path path3 = Files.move(path1, path2);
			System.out.println(path3);
			System.out.println(Files.exists(path3));
		} else {
			Path path3 = Files.move(path2, path1);
			System.out.println(path3);
			System.out.println(Files.exists(path3));
		}
	}

	@Test
	public void testDelete() throws IOException {
		Path path1 = Paths.get("dir\\subdir1\\test-delete");
		Path path2 = Paths.get("dir\\subdir2\\new-delete");

		if (Files.exists(path1)) {
			Files.copy(path1, path2);
			Files.delete(path1);
			System.out.println(Files.exists(path1));
		} else {
			Files.copy(path2, path1);
			Files.delete(path2);
			System.out.println(Files.exists(path2));
		}
	}

	@Test
	public void testRealAllLines() throws IOException {
		Path path1 = Paths.get("dir\\subdir1\\test-copy");
		Path path2 = Paths.get("dir\\subdir2\\new-copy");

		if (Files.exists(path1)) {
			Files.readAllLines(path1).forEach(System.out::println);
		} else {
			Files.readAllLines(path2).forEach(System.out::println);
		}
	}

	@Test
	public void testOwner() throws IOException {
		UserPrincipal owner = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("mramos");
		System.out.println(owner);
	}

	@Test
	public void testFileAttributes() throws IOException {
		BasicFileAttributes attributes = Files.readAttributes(Paths.get("dir\\test-attribute"), BasicFileAttributes.class);
		System.out.println(attributes.lastModifiedTime());
		System.out.println(attributes.size());

		System.out.println();

		BasicFileAttributeView view = Files.getFileAttributeView(Paths.get("dir\\test-attribute"), BasicFileAttributeView.class);
		System.out.println(view.name());
		System.out.println(view.readAttributes().lastModifiedTime());
	}

	@Test
	public void testWalk() throws IOException {
		Files.walk(Paths.get("dir\\subdir")).forEach(file -> System.out.println(file.toAbsolutePath()));
		System.out.println();
		Files.walk(Paths.get("dir\\subdir"), 1).forEach(file -> System.out.println(file.toAbsolutePath()));
	}

	@Test
	public void testFind() throws IOException {
		Files.find(Paths.get("dir\\subdir"), Integer.MAX_VALUE, (p, b) -> p.toString().endsWith(".txt") && b.isRegularFile()).forEach(p -> System.out.println(p.toAbsolutePath()));
	}

	@Test
	public void testList() throws IOException {
		Files.list(Paths.get("dir\\subdir")).forEach(p -> System.out.println(p.toAbsolutePath()));
	}

	@Test
	public void testLines() throws IOException {
		Files.lines(Paths.get("dir\\subdir\\test-file1")).map(str -> str.toUpperCase()).forEach(System.out::println);
		System.out.println();
		Files.readAllLines(Paths.get("dir\\subdir\\test-file2")).forEach(System.out::println);
	}

	@Test
	public void testCreateFiles() throws IOException {
		Files.createDirectories(Paths.get("dir\\subdir3\\subsubdir1"));
		Files.createDirectories(Paths.get("dir\\subdir3\\subsubdir2"));

		Path path1 = Paths.get("dir\\subdir3\\test-file1");
		Path path2 = Paths.get("dir\\subdir3\\subsubdir1\\test-file2");
		Path path3 = Paths.get("dir\\subdir3\\subsubdir2\\test-file3");

		if (Files.notExists(path1)) {
			Files.createFile(path1);
		}

		if (Files.notExists(path2)) {
			Files.createFile(path2);
		}

		if (Files.notExists(path3)) {
			Files.createFile(path3);
		}

		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, StandardOpenOption.APPEND))) {
			for (int i = 0; i < 10; i++) {
				writer.println("Test file 1.");
			}

			writer.println();
		}

		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path2, StandardOpenOption.APPEND))) {
			for (int i = 0; i < 10; i++) {
				writer.println("Test file 2.");
			}

			writer.println();
		}

		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path3, StandardOpenOption.APPEND))) {
			for (int i = 0; i < 10; i++) {
				writer.println("Test file 3.");
			}

			writer.println();
		}

		Files.walk(Paths.get("dir\\subdir3")).forEach(p -> System.out.println(p.toAbsolutePath()));
	}

	@Test
	public void testDeleteFiles() throws IOException {
		Path dir = Paths.get("dir\\subdir3");
		List<Path> paths = Files.walk(dir).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		paths.forEach(System.out::println);
		paths.forEach(p -> {
			try {
				Files.delete(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Test
	public void testCreateTempFile() throws IOException {
		Path path = Paths.get("dir\\subdir");
		Files.createTempFile(path, "tempprefix-", "-tempsuffix");
		// tempprefix-1649614728757491846-tempsuffix
	}

}
