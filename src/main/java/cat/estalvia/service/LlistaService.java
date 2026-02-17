package cat.estalvia.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import cat.estalvia.dto.ItemLlistaDTO;
import cat.estalvia.dto.LlistaDTO;
import cat.estalvia.entity.ItemLlista;
import cat.estalvia.entity.Llista;
import cat.estalvia.entity.Producte;
import cat.estalvia.entity.Supermercat;
import cat.estalvia.entity.Usuari;
import cat.estalvia.entity.Visibilitat;
import cat.estalvia.repository.LlistaRepository;
import cat.estalvia.repository.ProducteRepository;
import cat.estalvia.repository.SupermercatRepository;
import cat.estalvia.repository.UsuariRepository;
import cat.estalvia.request.CrearLlistaRequest;
import cat.estalvia.request.ItemLlistaRequest;

/**
 * Clase Service per les llistes
 */

@Service
@Transactional
public class LlistaService {

	private final LlistaRepository llistaRepo;
	private final UsuariRepository usuariRepo;
	private final ProducteRepository producteRepo;
	private final SupermercatRepository supermercatRepo;
	private static final List<String> VISIBILITATS_VALIDES = List.of("PUBLICA", "PRIVADA");

	public LlistaService(
			LlistaRepository llistaRepo,
			UsuariRepository usuariRepo,
			ProducteRepository producteRepo,
			SupermercatRepository supermercatRepo) {

		this.llistaRepo = llistaRepo;
		this.usuariRepo = usuariRepo;
		this.producteRepo = producteRepo;
		this.supermercatRepo = supermercatRepo;
	}

	/**
	 * Metode per crear una llista
	 * @param req
	 * @return
	 */

	public Llista crearLlista(CrearLlistaRequest req) {

		if (req.getVisibilidad() == null || !VISIBILITATS_VALIDES.contains(req.getVisibilidad().name())) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"Visibilitat inválida. Valores permitidos: PUBLICA, PRIVADA"
					);
		}

		Usuari usuari = usuariRepo.findById(req.getUsuariId())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		Llista llista = new Llista();
		llista.setNombre(req.getNombre());
		llista.setDescripcion(req.getDescripcion());
		llista.setVisibilitat(req.getVisibilidad().name());
		llista.setUsuari(usuari);
		llista.setDataCreacio(LocalDateTime.now());

		for (ItemLlistaRequest itemReq : req.getItems()) {

			Producte producte = producteRepo.findById(itemReq.getProductoId())
					.orElseThrow(() -> new RuntimeException("Producto no encontrado"));

			ItemLlista item = new ItemLlista();
			item.setLlista(llista);
			item.setProducte(producte);
			item.setQuantitat(itemReq.getCantidad());
			item.setUnitat(itemReq.getUnidad());

			if (itemReq.getSupermercadoPreferidoId() != null) {
				Supermercat s = supermercatRepo
						.findById(itemReq.getSupermercadoPreferidoId())
						.orElseThrow(() -> new RuntimeException("Supermercado no encontrado"));
				item.setSupermercatPreferit(s);
			}

			llista.getItems().add(item);
		}

		return llistaRepo.save(llista);
	}


	/**
	 * Metode per obtenir les llistes publiques
	 * @return Llista de llistes
	 */

	public List<LlistaDTO> obtenirPubliques() {
		// Pasamos el Enum como String para el SQL nativo
		List<Llista> llistes = llistaRepo.findByVisibilitat(Visibilitat.PUBLICA.name());
		return llistes.stream().map(this::toDTO).collect(Collectors.toList());
	}

	/**
	 * Metode per obtenir el nombre total de llistes privades
	 * @return Numero de llistes
	 */

	public int TotalPrivades() {
		// Retornamos el tamaño de la lista de privadas para obtener el número total
		List<Llista> llistes = llistaRepo.findByVisibilitat(Visibilitat.PRIVADA.name());
		return llistes.size();
	}

	/**
	 * Metode per obtenir les llistes d'un usuari
	 * @param userId
	 * @return Llista de llistes
	 */
	public List<Llista> obtenirLlistesUsuari(Long userId) {
		// Cambiamos UsuariId por UserId para que coincida con el @Query del repositorio
		return llistaRepo.findByUsuari_UserId(userId);
	}

	/**
	 * Metode per passar una llista a DTO
	 * @param llista
	 * @return
	 */
	public LlistaDTO toDTO(Llista llista) {
		if (llista == null) return null;

		LlistaDTO dto = new LlistaDTO();
		// Revisa si en la Clase Llista se llama getListaId() o getId()
		dto.setListaId(llista.getListaId()); 
		dto.setNombre(llista.getNombre());
		dto.setDescripcion(llista.getDescripcion());
		dto.setVisibilitat(Visibilitat.valueOf(llista.getVisibilitat()));
		dto.setDataCreacio(llista.getDataCreacio());
		dto.setNomAutor(llista.getUsuari().getUsername());

		if (llista.getItems() != null) {
			List<ItemLlistaDTO> items = llista.getItems().stream().map(item -> {
				ItemLlistaDTO i = new ItemLlistaDTO();
				i.setItemId(item.getItemId());
				i.setProductoId(item.getProducte().getProducteId());
				i.setNombreProducto(item.getProducte().getNomProducte());
				i.setCantidad(item.getQuantitat());
				i.setUnidad(item.getUnitat());
				i.setMarcada(item.isMarcada());

				if (item.getSupermercatPreferit() != null) {
					i.setSupermercadoPreferidoId(item.getSupermercatPreferit().getSupermercatId());
				}
				return i;
			}).toList();
			dto.setItems(items);
		}
		return dto;
	}


	/**
	 * Metode per coneixer el nombre total dellistes d ecada tipus d'un usari
	 * @param userId
	 * @return Mapa amb el nombre de llistes (publiques i privades)
	 */
	public Map<String, Long> estadistiquesUsuari(Long userId) {
		return Map.of(
				"publiques", llistaRepo.countByUsuari_UserIdAndVisibilitat(userId, Visibilitat.PUBLICA.name()),
				"privades", llistaRepo.countByUsuari_UserIdAndVisibilitat(userId, Visibilitat.PRIVADA.name())
				);
	}

	/**
	 * Metode per eliminar una llista d'un usari
	 * @param llistaId
	 * @param usuariId
	 */
	public void eliminarLlistaSegura(Long llistaId, Long usuariId) {
		llistaRepo.deleteByIdAndUsuariId(llistaId, usuariId);
	}


}