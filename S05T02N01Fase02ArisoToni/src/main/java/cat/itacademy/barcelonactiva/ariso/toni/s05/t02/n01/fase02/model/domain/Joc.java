package cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.domain;

import java.util.Random;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection="jocs")
public class Joc {
	
	@MongoId(targetType = FieldType.OBJECT_ID)
	private int idJoc;
	
	private int dau1;
	
	private int dau2;
	
	private boolean guanyat;
	
	private Jugador jugador;


	public Joc(Jugador jugador) {
		this.dau1 = getRandomDaus();
		this.dau2 = getRandomDaus();
		this.guanyat = suma7();
		this.jugador = jugador;
	}
	
    public int getRandomDaus(){
    	Random random = new Random();
        return random.nextInt(6) + 1;
    }
    
    public boolean suma7() {
    	return (this.dau1 + this.dau2 == 7) ? true : false; 
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
