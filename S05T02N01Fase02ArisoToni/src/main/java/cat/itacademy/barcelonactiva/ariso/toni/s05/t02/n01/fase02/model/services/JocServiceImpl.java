package cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.domain.Joc;
import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.domain.Jugador;
import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.repository.JocRepository;
import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.repository.JugadorRepository;

@Service
public class JocServiceImpl implements JocService {
	
	@Autowired
	private JocRepository jocRepository;
	
	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public Joc tiradaDaus(Jugador jugador) {

		Joc joc = new Joc(jugador);
		return jocRepository.save(joc);
	}

	@Override
	public List<Joc> llistaJocsPerJugadorID(int idJugador) {
		Optional<Jugador> op = jugadorRepository.findById(idJugador);
		Jugador jugador = op.get();
		return jugador.getJocs();
	}

	@Override
	public void eliminarJocs(Jugador jugador) {
		jocRepository.deleteAll(jugador.getJocs());
		
	}


}
