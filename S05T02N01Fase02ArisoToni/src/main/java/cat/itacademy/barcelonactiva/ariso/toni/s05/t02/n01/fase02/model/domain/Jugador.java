package cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.domain;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection="jugadros")
public class Jugador {
	
	@MongoId(targetType = FieldType.OBJECT_ID)
	private Integer idJugador;
	
	private String nomJugador;	

	private LocalDateTime dataRegistre;

	private int guanyatTotal; 
	
	private double guanyatPercent;
	
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
	
	
	public List<Joc> getJocs() {
		return jocs;
	}

	public void setJocs(List<Joc> jocs) {
		this.jocs = jocs;
	}
	

	public int getGuanyatTotal() {
		
		return guanyatTotal;
	}

	public void setGuanyatTotal(int guanyatTotal) {
		this.guanyatTotal = guanyatTotal;
	}

	public double getGuanyatPercent() {
		guanyatPercent = guanyatPercent();
		return guanyatPercent;
	}

	public void setGuanyatPercent(double guanyatPercent) {
		this.guanyatPercent = guanyatPercent;
	}

	public double guanyatPercent() {
		
		double resultat = ((double) this.guanyatTotal / (double) jocs.size()) * 100;
		
		
		return resultat;
		
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nomJugador=" + nomJugador + ", dataRegistre=" + dataRegistre
				+ ", guanyatTotal=" + guanyatTotal + ", guanyatPercent=" + guanyatPercent + ", jocs=" + jocs
				+ ", getIdJugador()=" + getIdJugador() + ", getNomJugador()=" + getNomJugador() + ", getDataRegistre()="
				+ getDataRegistre() + ", getJocs()=" + getJocs() + ", getGuanyatTotal()=" + getGuanyatTotal()
				+ ", getGuanyatPercent()=" + getGuanyatPercent() + ", guanyatPercent()=" + guanyatPercent()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

	
	

}
