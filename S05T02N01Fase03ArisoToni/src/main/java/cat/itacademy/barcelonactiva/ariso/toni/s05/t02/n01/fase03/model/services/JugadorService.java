package cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.model.domain.Jugador;

public interface JugadorService {
	
	public Jugador crearJugador(Jugador jugador);
	public Jugador existeixNomJugador(Jugador jugador);
	public List<Jugador> llistaJugadors();
	public Jugador obtenirJugadorPerID(Integer idJugador);
	public Jugador modificarNomJugador(Jugador jugador);
	public void eliminarJugadorPerID(Integer idJugador);

}
