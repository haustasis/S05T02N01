package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jocs")
public class Joc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idJoc")
	private int idJoc;
	
	@Column(name = "dau1")
	private int dau1;
	
	@Column(name = "dau2")
	private int dau2;
	
	@Column(name = "guanyat")
	private boolean guanyat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jugador_idJugador")
	private Jugador jugador;

	public Joc() {
		
	}

	public Joc(int idJoc, int dau1, int dau2, boolean guanyat, Jugador jugador) {
		super();
		this.idJoc = idJoc;
		this.dau1 = dau1;
		this.dau2 = dau2;
		this.guanyat = guanyat;
		this.jugador = jugador;
	}

	public int getIdJoc() {
		return idJoc;
	}

	public void setIdJoc(int idJoc) {
		this.idJoc = idJoc;
	}

	public int getDau1() {
		return dau1;
	}

	public void setDau1(int dau1) {
		this.dau1 = dau1;
	}

	public int getDau2() {
		return dau2;
	}

	public void setDau2(int dau2) {
		this.dau2 = dau2;
	}

	public boolean isGuanyat() {
		return guanyat;
	}

	public void setGuanyat(boolean guanyat) {
		this.guanyat = guanyat;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	
	
	

}
