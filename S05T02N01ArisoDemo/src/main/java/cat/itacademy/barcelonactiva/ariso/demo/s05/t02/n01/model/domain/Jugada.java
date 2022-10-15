package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jugadas")
public class Jugada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int dado1;
	private int dado2;
	private int ganada;
//	private double ganadasTotal;
//	private double jugadasTotal;
//	private double porcentajeGanadas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jugador_id", nullable = false)
	private Jugador jugador;

}
