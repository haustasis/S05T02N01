package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
	List<Jugador> findByNombre(String nombre);
}
