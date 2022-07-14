package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService {
	
	@Autowired
	private JugadorRepository jugadorRepository; 

	@Override
	public Jugador crearJugador(Jugador jugador) {
		return jugadorRepository.save(jugador);
	}

}
