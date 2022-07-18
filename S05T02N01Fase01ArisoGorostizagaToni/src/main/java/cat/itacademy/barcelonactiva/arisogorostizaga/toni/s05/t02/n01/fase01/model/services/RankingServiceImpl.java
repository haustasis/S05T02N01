package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.repository.JugadorRepository;

@Service
public class RankingServiceImpl implements RankingService {
	
	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public Jugador millorJugadorGuanyatPercent() {
		List<Jugador> jugadors = jugadorRepository.findAll();
		jugadors.sort(Comparator.comparing(Jugador::getGuanyatPercent));
		
		return jugadors.get(0);
	}

	@Override
	public Jugador pitjorJugadorGuanyatPercent() {
		List<Jugador> jugadors = jugadorRepository.findAll();
		jugadors.sort(Comparator.comparing(Jugador::getGuanyatPercent));
		
		return jugadors.get(jugadors.size() - 1);
	}

	@Override
	public List<Jugador> llistaJugadorsGuanyatPercent() {
		
		List<Jugador> jugadors = jugadorRepository.findAll();
		jugadors.sort(Comparator.comparing(Jugador::getGuanyatPercent));
		
		return jugadors;
	}

}
