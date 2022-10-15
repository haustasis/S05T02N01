package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadaDTO;

public interface JugadaService {

	public JugadaDTO crearJugada(long jugadorId, JugadaDTO jugadaDTO);

	public List<JugadaDTO> obtenerJugadasPorJugadorId(long jugadorId);

	public List<Jugada> obtenerJugadas();

	public void eliminarJugadasPorJugadorId(long jugadorId);
}
