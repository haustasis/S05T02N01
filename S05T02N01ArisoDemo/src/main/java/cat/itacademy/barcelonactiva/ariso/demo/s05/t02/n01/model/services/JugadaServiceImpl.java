package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

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
		Jugada nuevaJugada = jugadaRepository.save(jugada);
		return mapearDTO(nuevaJugada);
	}

	private JugadaDTO mapearDTO(Jugada jugada) {
		JugadaDTO jugadaDTO = new JugadaDTO();
		jugadaDTO.setId(jugada.getId());
		jugadaDTO.setDado1(jugada.getDado1());
		jugadaDTO.setDado2(jugada.getDado2());
		jugadaDTO.setGanada(jugada.getGanada());

		return jugadaDTO;
	}

	private Jugada mapearEntity(JugadaDTO jugadaDTO) {
		Jugada jugada = new Jugada();
		jugada.setId(jugadaDTO.getId());
		jugada.setDado1(jugadaDTO.getDado1());
		jugada.setDado2(jugadaDTO.getDado2());
		jugada.setGanada(jugadaDTO.getGanada());

		return jugada;
	}

//	@Override
//	public boolean jugar(long id) {
//		jugadorRepository.findById(id).orElseThrow(() -> new CustomException("No existe el jugador."));
//
//		Jugada jugada = new Jugada();
//
//		boolean resultado = false;
//
//		jugada.setDado1((int) (Math.floor(Math.random() * 6) + 1));
//		jugada.setDado2((int) (Math.floor(Math.random() * 6) + 1));
//
//		if ((jugada.getDado1() + jugada.getDado2()) == 7) {
//			resultado = true;
//		}
//
//		jugada.setGanada(resultado);
//
//		jugadaRepository.save(jugada);
//
//		return resultado;
//	}

}
