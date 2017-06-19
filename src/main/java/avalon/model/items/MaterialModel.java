package avalon.model.items;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="material")
public class MaterialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    private String icon;

    @OneToMany(mappedBy = "materialModel", cascade = CascadeType.ALL)
    private List<MaterialEffectModel> effectList;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MaterialEffectModel> getEffectList() {
        return effectList;
    }
    public void setEffectList(List<MaterialEffectModel> effectList) {
        this.effectList = effectList;
    }
}
