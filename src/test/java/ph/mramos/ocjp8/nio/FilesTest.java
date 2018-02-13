package ph.mramos.ocjp8.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;

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

		BasicFileAttributeView view = Files.getFileAttributeView(Paths.get("dir\\test-attribute"), BasicFileAttributeView.class);
		System.out.println(view.readAttributes().lastModifiedTime());
	}

	@Test
	public void testWalk() throws IOException {
		Files.walk(Paths.get("dir\\subdir")).forEach(file -> System.out.println(file.toAbsolutePath()));
		System.out.println();
		Files.walk(Paths.get("dir\\subdir"), 1).forEach(file -> System.out.println(file.toAbsolutePath()));
	}

}
