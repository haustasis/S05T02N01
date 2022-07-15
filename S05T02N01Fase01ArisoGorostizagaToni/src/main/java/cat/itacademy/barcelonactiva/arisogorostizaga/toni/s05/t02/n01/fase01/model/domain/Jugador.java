package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jugadors")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idJugador")
	private Integer idJugador;
	
	@Column(name = "nomJugador")
	private String nomJugador;
	
	@Column(name = "dataRegistre")
	private LocalDateTime dataRegistre;

	@Column(name = "guanyatTotal")
	private int guanyatTotal; 
	
	@Column(name="guanyatPercent")
	private double guanyatPercent;
	
	@OneToMany(mappedBy = "jugador")
	private List<Joc> jocs;
	
	
	
	public Jugador() {
		
	}

	public Jugador(Integer idJugador, String nomJugador, LocalDateTime dataRegistre) {
		super();
		this.idJugador = idJugador;
		this.nomJugador = nomJugador;
		this.dataRegistre = dataRegistre;
	}

	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public String getNomJugador() {
		return nomJugador;
	}

	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}

	public LocalDateTime getDataRegistre() {
		return dataRegistre;
	}

	public void setDataRegistre(LocalDateTime dataRegistre) {
		this.dataRegistre = dataRegistre;
	}
	
	public double guanyatPercent() {
		
		double resultat = ((double) this.guanyatTotal / (double) jocs.size()) * 100;
		
		return resultat;
		
	}

}
