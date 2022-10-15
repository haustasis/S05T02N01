package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Jugada;

public interface JugadaRepository extends JpaRepository<Jugada, Long> {

}
