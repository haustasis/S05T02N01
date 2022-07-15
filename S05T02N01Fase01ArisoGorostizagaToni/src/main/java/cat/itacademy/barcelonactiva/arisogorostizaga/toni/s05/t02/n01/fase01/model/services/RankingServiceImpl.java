package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.repository.JugadorRepository;

public class RankingServiceImpl implements RankingService {
	
	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public Jugador millorJugadorGuanyatPercent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jugador pitjorJugadorGuanyatPercent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jugador> llistaJugadorsGuanyatPercent() {
		// TODO Auto-generated method stub
		return null;
	}

}
