package ph.mramos.ocjp8.io;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import org.junit.Test;

public class FileTest {

	@Test
	public void testFileCreation() throws IOException {
		File file= new File("myfile.txt");
		System.out.println("File created: " + file.createNewFile());
		System.out.println("Absolute: " + file.getAbsolutePath());

		if (file.exists() && file.isFile()) {
			System.out.println("File deleted: " + file.delete());
		}
	}

	@Test
	public void testDirCreation() throws IOException {
		File dir = new File("mydir");
		System.out.println("Dirs created: " + dir.mkdir());

		if (dir.exists() && dir.isDirectory()) {
			System.out.println("Dir deleted: " + dir.delete());
		}
	}

	@Test
	public void testDirsCreation() throws IOException {
		File dir = new File("mydir2/subdir");
		System.out.println("Dirs created: " + dir.mkdirs());

		if (dir.exists() && dir.isDirectory()) {
			System.out.println("Dir deleted: " + dir.delete());
		}
	}

	@Test
	public void testDirDeletionCreation() throws IOException {
		File dir = new File("mydir3/subdir");
		dir.mkdirs();

		File file1= new File("mydir3/subdir", "myfile1.txt");
		System.out.println("File created: " + file1.createNewFile());
		File file2= new File("mydir3/subdir", "myfile2.txt");
		System.out.println("File created: " + file2.createNewFile());

		Stream.of(dir.listFiles()).forEach(System.out::println);
		System.out.println("Dir deleted: " + dir.delete());
		Stream.of(dir.listFiles()).forEach(File::delete);
		File rootDir = new File("mydir3/subdir");
		if (rootDir.exists() && rootDir.isDirectory()) {
			System.out.println("Dir deleted: " + rootDir.delete());
		}
	}

	@Test
	public void testListRoot() {
		Stream.of(File.listRoots()).forEach(System.out::println);
	}

	@Test
	public void testFieldInitialization() {
		System.out.println(new ClassB().getName());
		System.out.println(((ClassA) new ClassB()).getName());
	}

}
