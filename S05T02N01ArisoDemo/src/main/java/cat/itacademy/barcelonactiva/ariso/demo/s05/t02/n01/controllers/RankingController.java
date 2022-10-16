package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.services.RankingService;

@RestController
@RequestMapping("/players/ranking")
public class RankingController {

	@Autowired
	private RankingService rankingService;

	@GetMapping
	public ResponseEntity<?> mostrarRankingsGlobals() {
		Integer media = rankingService.rankingMedioPorcentajeExito();

		return new ResponseEntity<>("La media de porcentaje de Exito es: " + media, HttpStatus.OK);
	}

	@GetMapping("/loser")
	public ResponseEntity<?> mostrarPitjorJugador() {
		return new ResponseEntity<>(rankingService.peorJugador(rankingService.rankingPorcentajeExito()), HttpStatus.OK);
	}

	@GetMapping("/winner")
	public ResponseEntity<?> mostrarMillorJugador() {

		return new ResponseEntity<>(rankingService.mejorJugador(rankingService.rankingPorcentajeExito()),
				HttpStatus.OK);
	}
}
