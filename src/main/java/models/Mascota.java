package models;

import java.util.List;

public class Mascota {
    private Integer id;
    private Categoria category;
    private String name;
    private List<String> photoUrls;
    private List<Etiqueta> tags;
    private String status;

    public Mascota() {
        this.category = new Categoria();
        this.tags = List.of(new Etiqueta());
    }

    // Getters y Setters
    public long getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Categoria getCategory() { return category; }
    public void setCategory(Categoria category) { this.category = category; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(List<String> photoUrls) { this.photoUrls = photoUrls; }

    public List<Etiqueta> getTags() { return tags; }
    public void setTags(List<Etiqueta> tags) { this.tags = tags; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
