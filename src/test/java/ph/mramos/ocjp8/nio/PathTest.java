package ph.mramos.ocjp8.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PathTest {

	@Test
	public void testRelativize() {
		Path path1 = Paths.get("C:\\Users\\mramos\\.babun\\cygwin\\home\\mramos\\workspace");
		Path path2 = Paths.get("C:\\Users\\mramos\\Documents\\Candidate");
		System.out.println(path1.relativize(path2));
		System.out.println(path2.relativize(path1));

		Path path3 = Paths.get("src\\main");
		Path path4 = Paths.get("target\\classes");
		System.out.println(path3.relativize(path4));
		System.out.println(path4.relativize(path3));
	}

	@Test
	public void testNormalize() {
		Path path = Paths.get("C:\\Users\\mramos\\.babun\\..\\cygwin\\home\\mramos\\.\\workspace");
		System.out.println(path.normalize());
	}

	@Test
	public void testRealPath() throws IOException {
		Path path = Paths.get(".").toRealPath();
		System.out.println(path);
	}

}
