package cat.estalvia.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


/**
 * Entitat llista
 */
@Entity
@Table(name = "llistes")
public class Llista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "llista_id") // <-- AÑADE ESTO para que coincida con la DB
	private Long listaId;

	@Column(name = "nom_llista", nullable = false)
	private String nombre;

	private String descripcion;

	@Column(name = "visibilitat")
	private String visibilitat; 

	@ManyToOne
	@JoinColumn(name = "usuari_id", nullable = false)
	private Usuari usuari;

	private LocalDateTime dataCreacio;

	@OneToMany(mappedBy = "llista", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemLlista> items = new ArrayList<>();




	// getters & setters

	public Long getListaId() {
		return listaId;
	}

	public void setListaId(Long listaId) {
		this.listaId = listaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVisibilitat() {
		return visibilitat;
	}

	public void setVisibilitat(String visibilitat) {
		this.visibilitat = visibilitat;
	}

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public LocalDateTime getDataCreacio() {
		return dataCreacio;
	}

	public void setDataCreacio(LocalDateTime dataCreacio) {
		this.dataCreacio = dataCreacio;
	}

	public List<ItemLlista> getItems() {
		return items;
	}

	public void setItems(List<ItemLlista> items) {
		this.items = items;
	}





}
