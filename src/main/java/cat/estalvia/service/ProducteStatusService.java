package cat.estalvia.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import cat.estalvia.repository.ProducteRepository;

@Service
public class ProducteStatusService {

    private final ProducteRepository repository;

    public ProducteStatusService(ProducteRepository repository) {
        this.repository = repository;
    }

    public LocalDateTime getLastProducteUpdate() {
        return repository.findLastUpdate();
    }
}
