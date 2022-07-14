package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String dataRegistre;
	
	public Jugador() {
		
	}

	public Jugador(Integer idJugador, String nomJugador, String dataRegistre) {
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

	public String getDataRegistre() {
		return dataRegistre;
	}

	public void setDataRegistre(String dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nomJugador=" + nomJugador + ", dataRegistre=" + dataRegistre
				+ ", getIdJugador()=" + getIdJugador() + ", getNomJugador()=" + getNomJugador() + ", getDataRegistre()="
				+ getDataRegistre() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}