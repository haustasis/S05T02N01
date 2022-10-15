package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {

	private Long id;
	private String nombre;
	private LocalDateTime fechaRegistro;
}
