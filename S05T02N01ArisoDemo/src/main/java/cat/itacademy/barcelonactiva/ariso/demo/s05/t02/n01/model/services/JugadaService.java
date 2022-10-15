package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadaDTO;

public interface JugadaService {

	public JugadaDTO crearJugada(long jugadorId, JugadaDTO jugadaDTO);

	public List<JugadaDTO> obtenerJugadasPorJugadorId(long jugadorId);

	public void eliminarJugadasPorJugadorId(long jugadorId);
}
