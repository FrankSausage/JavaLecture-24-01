package ch14_exception.sec09_class;


public class MyRuntimeException extends RuntimeException {

	public MyRuntimeException() {
	}

	public MyRuntimeException(String message) {
		super(message);
	}

}
