package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugador;

public interface JugadorService {

	public Jugador crearJugador(Jugador jugador);

	public Jugador actualizarJugador(Jugador jugador, long id);
}
