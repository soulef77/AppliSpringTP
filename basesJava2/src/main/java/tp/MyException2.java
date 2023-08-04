package tp;
//hérite de runtimeException et donc le try/catch est facultatif, 'uncheck option"

//public class MyException2 extends Exception {
public class MyException2 extends RuntimeException {
	public MyException2() {
		// TODO Auto-generated constructor stub
	}

	public MyException2(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyException2(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MyException2(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyException2(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
