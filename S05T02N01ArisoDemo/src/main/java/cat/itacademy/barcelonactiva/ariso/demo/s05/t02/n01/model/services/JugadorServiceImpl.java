package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.exceptions.CustomException;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public Jugador crearJugador(Jugador jugador) {
		if (jugador.getNombre() == null || jugador.getNombre().equals("")
				|| jugador.getNombre().equalsIgnoreCase("ANONIM")) {
			jugador.setNombre("ANONIM");

		} else if (jugadorExiste(jugador)) {
			throw new CustomException("El jugador ya existe con este nombre.");
		}
		jugador.setFechaRegistro(LocalDate.now());
		return jugadorRepository.save(jugador);
	}

	public boolean jugadorExiste(Jugador jugador) {
		boolean existe = false;

		List<Jugador> jugadores = jugadorRepository.findByNombre(jugador.getNombre());

		if (jugadores.size() > 0) {
			existe = true;
		}

		return existe;
	}

	@Override
	public Jugador actualizarJugador(Jugador jugador, long id) {
		Jugador jugadorActualizado = jugadorRepository.findById(id)
				.orElseThrow(() -> new CustomException("Error al actualizar el jugador."));

		jugadorActualizado.setNombre(jugador.getNombre());
		return jugadorRepository.save(jugador);
	}

}
