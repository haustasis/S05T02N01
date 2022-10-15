package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadaDTO {
	private long id;

	private int dado1;
	private int dado2;
	private int ganada;
//	private double ganadasTotal;
//	private double jugadasTotal;
//	private double porcentajeGanadas;
}
