package ro.utcluj.dbassignment.api;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcluj.dbassignment.domain.Wine;
import ro.utcluj.dbassignment.service.WineDTO;
import ro.utcluj.dbassignment.service.WineService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/wine")
public class WineResource {

    private final WineService wineService;

    public WineResource(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping
    public ResponseEntity<List<Wine>> getAllWines() {
        return ok(wineService.getAllWines().subList(0, 5));
    }

    @PostMapping
    public ResponseEntity<Wine> insertWine(@RequestBody Wine wine) {
        Optional<Wine> optional = wineService.insert(wine);
        if (!optional.isPresent()) {
            return badRequest().build();
        }
        return ok(optional.get());
    }

    @PutMapping
    public ResponseEntity<Wine> updateWine(@RequestBody Wine wine) {
        Optional<Wine> optional = wineService.update(wine);
        if (!optional.isPresent()) {
            return badRequest().build();
        }
        return ok(optional.get());
    }

    @DeleteMapping("/{objectId}")
    public ResponseEntity<Void> deleteWine(@PathVariable ObjectId objectId) {
        return wineService.delete(objectId);
    }

    @GetMapping("/find/{country}")
    public ResponseEntity<List<Wine>> getByCountry(@PathVariable String country) {
        return wineService.getAllByCountry(country);
    }

    @PostMapping("/find")
    public ResponseEntity<List<Wine>> getByCountryAndVariety(@RequestBody WineDTO wineDTO) {
        return wineService.getAllByCountryAndVariety(wineDTO);
    }
}

