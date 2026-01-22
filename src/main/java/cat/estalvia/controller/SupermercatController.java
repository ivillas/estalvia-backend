package cat.estalvia.controller;

import cat.estalvia.dto.SupermercatsDTO;
import cat.estalvia.service.SupermercatService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/supermercats"})
public class SupermercatController {
   private final SupermercatService service;

   public SupermercatController(SupermercatService service) {
      this.service = service;
   }

   @GetMapping
   public List<SupermercatsDTO> getSupermercats() {
      return this.service.getAllSupermercats();
   }

   @GetMapping({"/ping"})
   public String ping() {
      return "OK";
   }
}
