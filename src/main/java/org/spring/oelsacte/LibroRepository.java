package org.spring.oelsacte;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "Libro", path="libro")
public interface LibroRepository extends MongoRepository<Libro, Long> {
}
