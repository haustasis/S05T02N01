package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadaDTO;

public interface JugadaService {

	public JugadaDTO crearJugada(long jugadorId, JugadaDTO jugadaDTO);

	// public boolean jugar(long id);
}
