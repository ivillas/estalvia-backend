package cat.estalvia.request;

import java.util.List;

import cat.estalvia.entity.Visibilitat;

/**
 * Request de Crear llista
 */

public class CrearLlistaRequest {

	private Long usuariId;
	private String nombre;
	private String descripcion;
	private Visibilitat visibilidad;
	private List<ItemLlistaRequest> items;

	// getters & setters


	public Long getUsuariId() {
		return usuariId;
	}
	public void setUsuariId(Long usuariId) {
		this.usuariId = usuariId;
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
	public Visibilitat getVisibilidad() {
		return visibilidad;
	}
	public void setVisibilidad(Visibilitat visibilidad) {
		this.visibilidad = visibilidad;
	}
	public List<ItemLlistaRequest> getItems() {
		return items;
	}
	public void setItems(List<ItemLlistaRequest> items) {
		this.items = items;
	}


}