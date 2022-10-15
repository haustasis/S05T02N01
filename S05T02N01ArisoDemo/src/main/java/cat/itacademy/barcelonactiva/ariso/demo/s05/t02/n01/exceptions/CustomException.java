package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.exceptions;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -2679186254778837334L;

	public CustomException(String str) {
		super(str);
	}
}
