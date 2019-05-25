package ro.utcluj.dbassignment.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.utcluj.dbassignment.domain.Wine;

import java.util.List;
import java.util.Optional;

@Repository
public interface WineRepository extends MongoRepository<Wine, ObjectId> {

    Optional<Wine> findByTitle(String title);

    List<Wine> findAllByCountry(String country);

    List<Wine> findAllByCountryAndVariety(String country, String variety);

}
