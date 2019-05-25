package ro.utcluj.dbassignment.service;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.utcluj.dbassignment.domain.Wine;
import ro.utcluj.dbassignment.repository.WineRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@Service
public class WineService {

    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public List<Wine> getAllWines() {
        return wineRepository.findAll().subList(0,1000);
    }

    public Optional<Wine> insert(Wine toBeInserted) {
        if (wineRepository.findByTitle(toBeInserted.getTitle()).isPresent()) {
            return Optional.empty();
        }
        toBeInserted.setId(null);
        return Optional.of(wineRepository.insert(toBeInserted));
    }

    public Optional<Wine> update(Wine wine) {
        if (wine.getId() == null || !wineRepository.findById(wine.getId()).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(wineRepository.save(wine));
    }

    public ResponseEntity<Void> delete(ObjectId objectId) {
        Optional<Wine> wine = wineRepository.findById(objectId);
        if (!wine.isPresent()) {
            return notFound().build();
        }
        wineRepository.delete(wine.get());
        return ok().build();
    }

    public ResponseEntity<List<Wine>> getAllByCountry(String country) {
        List<Wine> wines = wineRepository.findAllByCountry(country);
        if(wines.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(wines.subList(0, 100));
    }

    public ResponseEntity<List<Wine>> getAllByCountryAndVariety(WineDTO wineDTO) {
        List<Wine> wines = wineRepository.findAllByCountryAndVariety(wineDTO.getCountry(), wineDTO.getVariety());
        if(wines.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(wines.subList(0, 100));
    }
}
