package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.exceptions.CustomException;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.JugadaRepository;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.JugadorRepository;

@Service
public class JugadaServiceImpl implements JugadaService {

	@Autowired
	private JugadaRepository jugadaRepository;

	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public Jugada crearJugada(Jugada jugada, long id) {
		Jugador jugador = jugadorRepository.findById(id)
				.orElseThrow(() -> new CustomException("No existe el jugador."));

		return jugadaRepository.save(jugada);

	}

	@Override
	public boolean jugar(long id) {
		jugadorRepository.findById(id).orElseThrow(() -> new CustomException("No existe el jugador."));

		Jugada jugada = new Jugada();

		boolean resultado = false;

		jugada.setDado1((int) (Math.floor(Math.random() * 6) + 1));
		jugada.setDado2((int) (Math.floor(Math.random() * 6) + 1));

		if ((jugada.getDado1() + jugada.getDado2()) == 7) {
			resultado = true;
		}

		jugada.setGanada(resultado);

		jugadaRepository.save(jugada);

		return resultado;
	}

}
