package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadorDTO;

@Service
public class RankingServiceImpl implements RankingService {

	@Autowired
	private JugadorService jugadorService;

	@Override
	public Integer rankingMedioPorcentajeExito() {
		Integer mediaPorcentajeExito;
		Integer total = 0;
		Integer contador = 0;
		List<JugadorDTO> jugadores = jugadorService.obtenerJugadoresPorcentaje();

		if (jugadores.isEmpty()) {
			return null;
		}
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getPorcentajeExito() != null) {
				total += jugadores.get(i).getPorcentajeExito();
				contador++;
			}

		}
		mediaPorcentajeExito = (int) (Double.valueOf(total) / Double.valueOf(contador));

		return mediaPorcentajeExito;
	}

	@Override
	public JugadorDTO peorJugador(List<JugadorDTO> jugadoresDTO) {
		return jugadoresDTO.get(0);
	}

	@Override
	public List<JugadorDTO> rankingPorcentajeExito() {
		List<JugadorDTO> nuevosJugadoresDTO = new ArrayList<>();
		List<JugadorDTO> jugadoresDTO = jugadorService.obtenerJugadoresPorcentaje();

		for (int i = 0; i < jugadoresDTO.size(); i++) {
			if (jugadoresDTO.get(i).getPorcentajeExito() != null) {
				nuevosJugadoresDTO.add(jugadoresDTO.get(i));
			}
		}

		Collections.sort(nuevosJugadoresDTO);

		return nuevosJugadoresDTO;
	}

	@Override
	public JugadorDTO mejorJugador(List<JugadorDTO> jugadoresDTO) {
		return jugadoresDTO.get(jugadoresDTO.size() - 1);
	}

}
