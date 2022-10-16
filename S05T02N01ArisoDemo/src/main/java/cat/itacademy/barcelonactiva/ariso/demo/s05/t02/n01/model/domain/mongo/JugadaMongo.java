package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.mongo;

import lombok.Data;

@Data
public class JugadaMongo {
	private long id;

	private int dado1;
	private int dado2;
	private int ganada;
}
