package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Joc;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.repository.JocRepository;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s05.t02.n01.fase01.model.repository.JugadorRepository;

@Service
public class JocServiceImpl implements JocService {
	
	@Autowired
	private JocRepository jocRepository;
	
	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public Joc tiradaDaus(Joc joc) {
		return jocRepository.save(joc);
	}

}
