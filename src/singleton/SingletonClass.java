package singleton;

public class SingletonClass {

	private static SingletonClass instance = null;

	/* constructor of the class should be private */
	private SingletonClass() throws Exception {
		if (instance != null)
			throw new Exception("instance already exists");
	}

	public synchronized static SingletonClass getInstance() {
		if (instance == null) {
			try {
				instance = new SingletonClass();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}