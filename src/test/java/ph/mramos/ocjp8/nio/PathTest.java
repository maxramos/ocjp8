package ph.mramos.ocjp8.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PathTest {

	@Test
	public void testStartsWith() {
		Path path = Paths.get("/ocjp/test/PathTest.java");
		System.out.println(path.startsWith("/"));
		System.out.println(path.startsWith("/ocjp"));
		System.out.println(path.startsWith("/ocjp/"));
		System.out.println(path.startsWith("/ocjp/test"));
	}

	@Test
	public void testEndsWith() {
		Path path = Paths.get("/ocjp/test/PathTest.java");
		System.out.println(path.endsWith(".java"));
		System.out.println(path.endsWith("PathTest.java"));
		System.out.println(path.endsWith("PathTest.java/"));
		System.out.println(path.endsWith("/PathTest.java"));
	}

	@Test
	public void testGetFileName() {
		Path path = Paths.get("/ocjp/test/PathTest.java");
		System.out.println(path.getFileName());
	}

	@Test
	public void testGetName() {
		Path path = Paths.get("/ocjp/test/PathTest.java");

		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
	}

	@Test
	public void testGetParent_Root() {
		Path path = Paths.get("/ocjp/test/PathTest.java");
		System.out.println(path.getParent());
		System.out.println(path.getRoot());

		path = Paths.get("c:\\ocjp\\test\\PathTest.java");
		System.out.println(path.getParent());
		System.out.println(path.getRoot());
	}

	@Test
	public void testIsAbsolute() {
		Path path1 = Paths.get("c:/ocjp/test/PathTest.java");
		Path path2 = Paths.get("ocjp/test/PathTest.java");
		System.out.println(path1.isAbsolute());
		System.out.println(path2.isAbsolute());
	}

	@Test
	public void testNormalize() {
		Path path = Paths.get("C:/Users/mramos/.babun/../cygwin/home/mramos/./workspace");
		System.out.println(path.normalize());
	}

	@Test
	public void testRelativize() {
		Path path1 = Paths.get("C:/Users/mramos/.babun/cygwin/home/mramos/workspace");
		Path path2 = Paths.get("C:/Users/mramos/Documents/Candidate");
		System.out.println(path1.relativize(path2));
		System.out.println(path2.relativize(path1));

		//		..\..\..\..\..\Documents\Candidate
		//		..\..\.babun\cygwin\home\mramos\workspace

		Path path3 = Paths.get("src/main");
		Path path4 = Paths.get("target/classes");
		System.out.println(path3.relativize(path4));
		System.out.println(path4.relativize(path3));

		//		..\..\target\classes
		//		..\..\src\main

		Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");
		Path p2 = Paths.get("c:\\personal\\index.html");
		Path p3 = p1.relativize(p2);
		System.out.println(p3);
	}

	@Test
	public void testResolve() {
		Path path1 = Paths.get("C:/Users/mramos/.babun/cygwin/home/mramos/workspace");
		Path path2 = Paths.get("C:/Users/mramos/Documents/Candidate");
		System.out.println(path1.resolve(path2));
		System.out.println(path2.resolve(path1));

		//		C:\Users\mramos\Documents\Candidate
		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace

		Path path3 = Paths.get("src/main");
		Path path4 = Paths.get("target/classes");
		System.out.println(path3.resolve(path4));
		System.out.println(path4.resolve(path3));

		//		src\main\target\classes
		//		target\classes\src\main

		System.out.println(path1.resolve(path3));
		System.out.println(path3.resolve(path1));

		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace\src\main
		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace
	}

	@Test
	public void testResolveSibling() {
		Path path1 = Paths.get("C:/Users/mramos/.babun/cygwin/home/mramos/workspace");
		Path path2 = Paths.get("C:/Users/mramos/Documents/Candidate");
		System.out.println(path1.resolveSibling(path2));
		System.out.println(path2.resolveSibling(path1));

		//		C:\Users\mramos\Documents\Candidate
		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace

		Path path3 = Paths.get("src/main");
		Path path4 = Paths.get("target/classes");
		System.out.println(path3.resolveSibling(path4));
		System.out.println(path4.resolveSibling(path3));

		//		src\target\classes
		//		target\src\main

		System.out.println(path1.resolveSibling(path3));
		System.out.println(path3.resolveSibling(path1));

		//		C:\Users\mramos\.babun\cygwin\home\mramos\src\main
		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace
	}

	@Test
	public void testSubPath() {
		Path path1 = Paths.get("C:/Users/mramos/.babun/cygwin/home/mramos/workspace");
		Path path2 = Paths.get("Users/mramos/Documents/Candidate");
		System.out.println(path1.subpath(1, 3));
		System.out.println(path2.subpath(1, 3));

		//		mramos\.babun
		//		mramos\Documents
	}

	@Test
	public void testToAbsolutePath() {
		Path path1 = Paths.get("C:/Users/mramos/.babun/cygwin/home/mramos/workspace");
		Path path2 = Paths.get("Users/mramos/Documents/Candidate");
		System.out.println(path1.toAbsolutePath());
		System.out.println(path2.toAbsolutePath());

		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace
		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace\ocjp8\Users\mramos\Documents\Candidate
	}

	@Test
	public void testToRealPath() throws IOException {
		Path path = Paths.get(".").toRealPath();
		System.out.println(path);

		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace\ocjp8

		Path path1 = Paths.get("C:/Users/mramos/.babun/cygwin/home/mramos/workspace");
		Path path2 = Paths.get("src/main");
		System.out.println(path1.toRealPath());
		System.out.println(path2.toRealPath());

		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace
		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace\ocjp8\src\main

		Path path3 = Paths.get("C:/Users/mramos/../mramos/.babun/cygwin/home/mramos/./workspace");
		System.out.println(path3.toRealPath());

		//		C:\Users\mramos\.babun\cygwin\home\mramos\workspace
	}

}
