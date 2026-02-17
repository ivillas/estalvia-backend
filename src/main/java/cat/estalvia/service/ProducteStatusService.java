package cat.estalvia.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import cat.estalvia.repository.ProducteRepository;

/**
 * Clase Service per l'ultima actualització dels productes
 */
@Service
public class ProducteStatusService {

	private final ProducteRepository repository;


	public ProducteStatusService(ProducteRepository repository) {
		this.repository = repository;
	}

	/**
	 * Metode per coneixer l'ultima actualització
	 * @return data ultim producte afegit o modificat
	 */
	public LocalDateTime getLastProducteUpdate() {
		return repository.findLastUpdate();
	}
}
