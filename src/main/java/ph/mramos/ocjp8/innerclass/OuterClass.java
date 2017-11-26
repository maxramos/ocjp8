package ph.mramos.ocjp8.innerclass;

public class OuterClass {

	private static interface InnerStaticInterface {
	}

	private interface InnerInterface {
	}

	private static class InnerStaticClass implements InnerStaticInterface {
		private int a;
	}

	private class InnerClass implements InnerInterface {
		private int b;
	}

	private InnerStaticInterface isi = new InnerStaticInterface() {
	};

	private InnerInterface ii = new InnerInterface() {
	};

	public static void main(String[] args) {
		final int one = 1;
		final int two;
		two = 2;

		OuterClass.InnerStaticClass isc = new OuterClass.InnerStaticClass();
		int a = isc.a;
		OuterClass.InnerClass ic = new OuterClass().new InnerClass();
		int b = ic.b;
	}

}
