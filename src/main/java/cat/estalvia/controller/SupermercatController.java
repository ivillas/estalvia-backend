package cat.estalvia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.estalvia.dto.ProductePreusDTO;
import cat.estalvia.dto.SupermercatsDTO;
import cat.estalvia.service.ProducteService;
import cat.estalvia.service.SupermercatService;

@RestController
@RequestMapping("/api/supermercats")
public class SupermercatController {

    private final SupermercatService service;

    public SupermercatController(SupermercatService service) {
        this.service = service;
    }

    @GetMapping
    public List<SupermercatsDTO> getSupermercats() {
        return service.getAllSupermercats();
    }

    @GetMapping("/ping")
    public String ping() {
        return "OK";
    }
}

