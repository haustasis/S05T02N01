package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO implements Comparable<JugadorDTO> {

	private Long id;
	private String nombre;
	private LocalDateTime fechaRegistro;
	private Integer porcentajeExito;

	public void porcentajeExito(List<Jugada> jugadas) {

		int ganadasTotal = 0;
		if (jugadas.size() > 0) {
			for (int i = 0; i < jugadas.size(); i++) {
				if (jugadas.get(i).getGanada() == 1) {
					ganadasTotal++;
				}
			}
			this.porcentajeExito = (int) ((Double.valueOf(ganadasTotal) / Double.valueOf(jugadas.size())) * 100);
		} else {
			this.porcentajeExito = null;
		}
	}

	@Override
	public int compareTo(JugadorDTO jugadorDTO) {
		int comparador = -1;
		if (this.porcentajeExito == jugadorDTO.porcentajeExito) {
			comparador = 0;
		} else if (this.porcentajeExito > jugadorDTO.porcentajeExito) {
			comparador = 1;
		}
		return comparador;
	}

}
