package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supermercats")
public class Supermercat {

    @Id
    @Column(name = "supermercat_id") // Nombre exacto en la tabla del NAS
    private Long supermercatId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "web")
    private String web;

    @Column(name = "actiu")
    private Boolean actiu;

    // Constructor vacío (obligatorio para JPA)
    public Supermercat() {}

    // Constructor útil si quieres crear objetos con id y nombre
    public Supermercat(Long supermercatId, String nom) {
        this.supermercatId = supermercatId;
        this.nom = nom;
    }

    // Getters y Setters
    public Long getSupermercatId() {
        return supermercatId;
    }

    public void setSupermercatId(Long supermercatId) {
        this.supermercatId = supermercatId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Boolean getActiu() {
        return actiu;
    }

    public void setActiu(Boolean actiu) {
        this.actiu = actiu;
    }
}
