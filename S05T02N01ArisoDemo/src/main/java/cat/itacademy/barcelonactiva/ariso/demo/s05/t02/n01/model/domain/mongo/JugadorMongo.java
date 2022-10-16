package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.mongo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;
import lombok.Data;

@Data
@Document
public class JugadorMongo {
	@Id
	private Long id;
	private String nombre;
	private LocalDateTime fechaRegistro;

	private List<Jugada> jugadas = new ArrayList<>();
}
