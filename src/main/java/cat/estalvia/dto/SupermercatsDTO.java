package cat.estalvia.dto;

public class SupermercatsDTO {

    private Long supermercatId;
    private String nom;
    private String web;
    private boolean actiu;

    public SupermercatsDTO(Long supermercatId, String nom, String web, boolean actiu) {
        this.supermercatId = supermercatId;
        this.nom = nom;
        this.web = web;
        this.actiu = actiu;
    }

    public Long getSupermercatId() { return supermercatId; }
    public String getNom() { return nom; }
    public String getWeb() { return web; }
    public boolean isActiu() { return actiu; }
}


