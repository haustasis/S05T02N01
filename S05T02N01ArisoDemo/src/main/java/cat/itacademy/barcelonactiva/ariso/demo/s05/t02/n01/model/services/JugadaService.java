package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;

public interface JugadaService {

	public Jugada crearJugada(Jugada jugada, long id);

	public boolean jugar(long id);
}
