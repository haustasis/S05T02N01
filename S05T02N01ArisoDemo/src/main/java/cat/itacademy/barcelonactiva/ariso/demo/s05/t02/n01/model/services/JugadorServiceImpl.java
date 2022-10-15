package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.exceptions.CustomException;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JugadorDTO;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	private JugadorRepository jugadorRepository;

	@Autowired
	private JugadaService jugadaService;

	@Override
	public JugadorDTO crearJugador(JugadorDTO jugadorDTO) {

		if (jugadorDTO.getNombre() == null || jugadorDTO.getNombre().equals("")
				|| jugadorDTO.getNombre().equalsIgnoreCase("ANONIM")) {
			jugadorDTO.setNombre("ANONIM");

		} else if (jugadorExiste(jugadorDTO)) {
			throw new CustomException("El jugador ya existe con este nombre.");
		}

		jugadorDTO.setFechaRegistro(LocalDateTime.now());

		Jugador jugador = mapearEntity(jugadorDTO);
		Jugador nuevoJugador = jugadorRepository.save(jugador);

		JugadorDTO jugadorRespuesta = mapearDTO(nuevoJugador);

		return jugadorRespuesta;

	}

	public boolean jugadorExiste(JugadorDTO jugadorDTO) {
		boolean existe = false;
		List<Jugador> jugadores = jugadorRepository.findByNombre(jugadorDTO.getNombre());
		if (jugadores.size() > 0) {
			existe = true;
		}
		return existe;
	}

	@Override
	public List<JugadorDTO> obtenerJugadores() {
		List<Jugador> jugadores = jugadorRepository.findAll();
		return jugadores.stream().map(jugador -> mapearDTO(jugador)).collect(Collectors.toList());
	}

	// Convertir Entity a DTO -- Response DB
	private JugadorDTO mapearDTO(Jugador jugador) {
		JugadorDTO jugadorDTO = new JugadorDTO();
		jugadorDTO.setId(jugador.getId());
		jugadorDTO.setNombre(jugador.getNombre());
		jugadorDTO.setFechaRegistro(jugador.getFechaRegistro());

		return jugadorDTO;
	}

	// Convertir DTO a Entity -- Request Front
	private Jugador mapearEntity(JugadorDTO jugadorDTO) {
		Jugador jugador = new Jugador();
		jugador.setId(jugadorDTO.getId());
		jugador.setNombre(jugadorDTO.getNombre());
		jugador.setFechaRegistro(jugadorDTO.getFechaRegistro());

		return jugador;
	}

	@Override
	public JugadorDTO obtenerJugadorPorId(long id) {
		Jugador jugador = jugadorRepository.findById(id)
				.orElseThrow(() -> new CustomException("Jugador no existe con este id."));
		return mapearDTO(jugador);
	}

	@Override
	public JugadorDTO actualizarJugador(JugadorDTO jugadorDTO, long id) {
		Jugador jugador = jugadorRepository.findById(id)
				.orElseThrow(() -> new CustomException("Jugador no existe con este id."));

		if (jugadorDTO.getNombre() == null || jugadorDTO.getNombre().equals("")) {
			throw new CustomException("Elija otro nombre.");
		} else if (jugadorExiste(jugadorDTO) && !jugadorDTO.getNombre().equalsIgnoreCase("ANONIM")) {
			throw new CustomException("Elija otro nombre.");
		}

		jugador.setNombre(jugadorDTO.getNombre());

		Jugador jugadorActualizado = jugadorRepository.save(jugador);

		return mapearDTO(jugadorActualizado);

	}

	@Override
	public void eliminarJugador(long id) {
		Jugador jugador = jugadorRepository.findById(id)
				.orElseThrow(() -> new CustomException("Jugador no existe con este id."));
		jugadorRepository.delete(jugador);

	}

	@Override
	public List<JugadorDTO> obtenerJugadoresPorcentaje() {

		// LLISTAT DE JUGADORS DTO
		List<JugadorDTO> jugadoresDTO = obtenerJugadores();

		// LLISTAT DE JUGADES DEL SISTEMA
		List<Jugada> jugadasDAO = jugadaService.obtenerJugadas();

		// LLISTAT DE JUGADES D'UN JUGADOR
		List<Jugada> jugadasJugador = new ArrayList<>();

		int contador = 0;
		while (contador < jugadoresDTO.size()) {
			for (int i = 0; i < jugadasDAO.size(); i++) {
				if (jugadasDAO.get(i).getJugador().getId() == jugadoresDTO.get(contador).getId()) {
					jugadasJugador.add(jugadasDAO.get(i));
				}
			}
			jugadoresDTO.get(contador).porcentajeExito(jugadasJugador);
			jugadasJugador.clear();
			contador++;
		}

		return jugadoresDTO;
	}

}
