package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadorDTO;

public interface RankingService {

	public Integer rankingMedioPorcentajeExito();

	public JugadorDTO peorJugador(List<JugadorDTO> jugadoresDTO);

	public List<JugadorDTO> rankingPorcentajeExito();

	public JugadorDTO mejorJugador(List<JugadorDTO> jugadoresDTO);

}
