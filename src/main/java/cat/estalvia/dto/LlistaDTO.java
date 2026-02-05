package cat.estalvia.dto;

import java.time.LocalDateTime;
import java.util.List;

import cat.estalvia.entity.Visibilitat;

public class LlistaDTO {

    private Long listaId;
    private String nombre;
    private String descripcion;
    private Visibilitat visibilitat;
    private LocalDateTime dataCreacio;
    private List<ItemLlistaDTO> items;
    private String nomAutor;
    
    
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
	public Visibilitat getVisibilitat() {
		return visibilitat;
	}
	public void setVisibilitat(Visibilitat visibilitat) {
		this.visibilitat = visibilitat;
	}
	public LocalDateTime getDataCreacio() {
		return dataCreacio;
	}
	public void setDataCreacio(LocalDateTime dataCreacio) {
		this.dataCreacio = dataCreacio;
	}
	public List<ItemLlistaDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemLlistaDTO> items) {
		this.items = items;
	}
	public String getNomAutor() {
		return nomAutor;
	}
	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	

    // getters & setters
    
    
    
}