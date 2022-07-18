package cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.model.domain.Jugador;

public interface RankingService {
	
	public Jugador millorJugadorGuanyatPercent();
	public Jugador pitjorJugadorGuanyatPercent();
	public List<Jugador> llistaJugadorsGuanyatPercent();

}
