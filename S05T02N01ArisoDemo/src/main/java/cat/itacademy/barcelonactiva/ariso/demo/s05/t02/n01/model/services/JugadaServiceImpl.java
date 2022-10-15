package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.exceptions.CustomException;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadaDTO;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.JugadaRepository;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.JugadorRepository;

@Service
public class JugadaServiceImpl implements JugadaService {

	@Autowired
	private JugadaRepository jugadaRepository;

	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public JugadaDTO crearJugada(long jugadorId, JugadaDTO jugadaDTO) {
		Jugada jugada = mapearEntity(jugadaDTO);
		Jugador jugador = jugadorRepository.findById(jugadorId)
				.orElseThrow(() -> new CustomException("Jugador no existe con este id."));

		jugada.setJugador(jugador);
		jugada.setDado1((int) (Math.floor(Math.random() * 6) + 1));
		jugada.setDado2((int) (Math.floor(Math.random() * 6) + 1));

		Jugada nuevaJugada = jugadaRepository.save(jugada);

		if ((nuevaJugada.getDado1() + nuevaJugada.getDado2()) == 7) {
			nuevaJugada.setGanada(1);
//			nuevaJugada.setJugadasTotal(jugada.getJugadasTotal() + 1);
//			nuevaJugada.setGanadasTotal(jugada.getGanadasTotal() + 1);
//			nuevaJugada.setPorcentajeGanadas((jugada.getGanadasTotal() + 1) / (jugada.getJugadasTotal() + 1));
		} else {
			nuevaJugada.setGanada(0);
//			nuevaJugada.setJugadasTotal(jugada.getJugadasTotal() + 1);
//			nuevaJugada.setGanadasTotal(jugada.getGanadasTotal());
//			nuevaJugada.setPorcentajeGanadas((jugada.getGanadasTotal()) / (jugada.getJugadasTotal() + 1));
		}

		nuevaJugada = jugadaRepository.save(jugada);
		return mapearDTO(nuevaJugada);
	}

	private JugadaDTO mapearDTO(Jugada jugada) {
		JugadaDTO jugadaDTO = new JugadaDTO();
		jugadaDTO.setId(jugada.getId());
		jugadaDTO.setDado1(jugada.getDado1());
		jugadaDTO.setDado2(jugada.getDado2());
		jugadaDTO.setGanada(jugada.getGanada());
//		jugadaDTO.setGanadasTotal(jugada.getGanadasTotal());
//		jugadaDTO.setJugadasTotal(jugada.getJugadasTotal());
//		jugadaDTO.setPorcentajeGanadas(jugada.getPorcentajeGanadas());

		return jugadaDTO;
	}

	private Jugada mapearEntity(JugadaDTO jugadaDTO) {
		Jugada jugada = new Jugada();
		jugada.setId(jugadaDTO.getId());
		jugada.setDado1(jugadaDTO.getDado1());
		jugada.setDado2(jugadaDTO.getDado2());
		jugada.setGanada(jugadaDTO.getGanada());
//		jugada.setGanadasTotal(jugadaDTO.getGanadasTotal());
//		jugada.setJugadasTotal(jugadaDTO.getJugadasTotal());
//		jugada.setPorcentajeGanadas(jugadaDTO.getPorcentajeGanadas());
		return jugada;
	}

	@Override
	public List<JugadaDTO> obtenerJugadasPorJugadorId(long jugadorId) {
		List<Jugada> jugadas = jugadaRepository.findByJugadorId(jugadorId);
		return jugadas.stream().map(jugada -> mapearDTO(jugada)).collect(Collectors.toList());
	}

	@Override
	public void eliminarJugadasPorJugadorId(long jugadorId) {
		List<Jugada> jugadas = jugadaRepository.findByJugadorId(jugadorId);
		jugadas.stream().forEach(j -> jugadaRepository.deleteById(j.getId()));

	}

	@Override
	public List<Jugada> obtenerJugadas() {
		return jugadaRepository.findAll();
	}

}
