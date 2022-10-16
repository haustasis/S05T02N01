package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.exceptions;

import org.springframework.http.HttpStatus;

public class PlayersException extends RuntimeException {

	private static final long serialVersionUID = -8540745505237029512L;
	private HttpStatus status;
	private String message;

	public PlayersException(HttpStatus status, String message) {

		this.status = status;
		this.message = message;
	}

	public PlayersException(String message, HttpStatus status, String message1) {
		super(message);
		this.status = status;
		this.message = message1;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
