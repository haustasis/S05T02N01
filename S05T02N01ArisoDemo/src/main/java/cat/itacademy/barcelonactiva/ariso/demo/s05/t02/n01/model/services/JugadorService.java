package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadorDTO;

public interface JugadorService {

	public JugadorDTO crearJugador(JugadorDTO jugadorDTO);

	public List<JugadorDTO> obtenerJugadores();

	public List<JugadorDTO> obtenerJugadoresPorcentaje();

	public JugadorDTO obtenerJugadorPorId(long id);

	public JugadorDTO actualizarJugador(JugadorDTO jugadorDTO, long id);

	public void eliminarJugador(long id);
}
