package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2840413998075602116L;
	private String nombreRecurso;
	private String nombreCampo;
	private long valorCampo;

	public ResourceNotFoundException(String nombreRecurso, String nombreCampo, long valorCampo) {
		super(String.format("%s No encontrado con : %s : '%s'", nombreRecurso, nombreCampo, valorCampo));
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.valorCampo = valorCampo;
	}

}
