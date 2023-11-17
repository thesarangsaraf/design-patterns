package design.patterns.singleton;

public class SingletonClass {

	private static SingletonClass instance = null;

	/* constructor of the class should be private */
	private SingletonClass() {
	}

	// public static method to get instance of this class
	public static SingletonClass getInstance() {
		// making specific block synchronized makes
		// avoids entire method locking
		synchronized (SingletonClass.class) {
			if (instance == null) {
				instance = new SingletonClass();
			}
		}
		return instance;
	}

}