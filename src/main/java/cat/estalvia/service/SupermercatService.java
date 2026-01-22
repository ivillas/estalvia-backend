package cat.estalvia.service;


import java.util.List;
import org.springframework.stereotype.Service;

import cat.estalvia.dto.SupermercatsDTO;
import cat.estalvia.repository.SupermercatRepository;

@Service
public class SupermercatService {

    private final SupermercatRepository repository;

    public SupermercatService(SupermercatRepository repository) {
        this.repository = repository;
    }

    public List<SupermercatsDTO> getAllSupermercats() {
        return repository.findAll()
                .stream()
                .map(s -> new SupermercatsDTO(
                        s.getSupermercatId(),
                        s.getNom(),
                        s.getWeb(),
                        Boolean.TRUE.equals(s.getActiu())
                ))
                .toList();
    }
}
