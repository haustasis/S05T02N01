package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.mongo.JugadaMongo;

public interface JugadaMongoRepository extends MongoRepository<JugadaMongo, Long> {

}
