package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Joc;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Jugador;



public interface JocService {
	
	public Joc tiradaDaus(Jugador jugador);
	public List<Joc> llistaJocsPerJugadorID(int idJugador);
	public void eliminarJocs(Jugador jugador);
	

}
