package cat.estalvia.service;

import cat.estalvia.dto.SupermercatsDTO;
import cat.estalvia.repository.SupermercatRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SupermercatService {
   private final SupermercatRepository repository;

   public SupermercatService(SupermercatRepository repository) {
      this.repository = repository;
   }

   public List<SupermercatsDTO> getAllSupermercats() {
      return this.repository.findAll().stream().map((s) -> {
         return new SupermercatsDTO(s.getSupermercatId(), s.getNom(), s.getWeb(), Boolean.TRUE.equals(s.getActiu()));
      }).toList();
   }
}
