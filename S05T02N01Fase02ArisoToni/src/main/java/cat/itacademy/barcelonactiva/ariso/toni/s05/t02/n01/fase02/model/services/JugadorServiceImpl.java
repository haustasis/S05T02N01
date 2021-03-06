package cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.domain.Jugador;
import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase02.model.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public Jugador crearJugador(Jugador jugador) {
		return jugadorRepository.save(jugador);
	}

	@Override
	public Jugador existeixNomJugador(Jugador jugador) {
		List<Jugador> llistaJugadors = jugadorRepository.findAll();
		if (jugador.getNomJugador() != null) {
			for (int i = 0; i < llistaJugadors.size(); i++) {
				if (jugador.getNomJugador().equalsIgnoreCase(llistaJugadors.get(i).getNomJugador())) {
					jugador.setNomJugador("ANÒNIM");
				}
			}
		} 

		return jugador;
	}

	@Override
	public List<Jugador> llistaJugadors() {
		return (List<Jugador>) jugadorRepository.findAll();
	}

	@Override
	public Jugador obtenirJugadorPerID(Integer idJugador) {
		return jugadorRepository.findById(idJugador).orElse(null);
	}

	@Override
	public Jugador modificarNomJugador(Jugador jugador) {
		return jugadorRepository.save(jugador);
	}

	@Override
	public void eliminarJugadorPerID(Integer idJugador) {
		jugadorRepository.deleteById(idJugador);

	}

	/*
	 * @Override public Jugador existeixNomJugador(Jugador jugador) {
	 * 
	 * if(jugador.getNomJugador() == null) { jugador.setNomJugador("ANÒNIM"); }
	 * 
	 * if(jugador.getDataRegistre() == null) {
	 * jugador.setDataRegistre(LocalDateTime.now()); }
	 * 
	 * List<Jugador> llistaJugadors = jugadorRepository.findAll(); for(Jugador j :
	 * llistaJugadors) {
	 * if((j.getNomJugador().equalsIgnoreCase(jugador.getNomJugador()))) {
	 * jugador.setNomJugador("ANÒNIM"); }
	 * 
	 * } return jugador; }
	 */

}
