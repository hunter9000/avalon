package avalon.model.items;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="material")
public class MaterialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    private String icon;

    @OneToMany(mappedBy = "materialModel", cascade = CascadeType.ALL)
    private List<MaterialEffectModel> effectList;

    public long getId() {
        return id;
    }
    public void setId(long id) {
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