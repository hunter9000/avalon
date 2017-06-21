package avalon.model.dungeons;

import avalon.model.pathing.node.Travelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import avalon.model.CellEntity;

import javax.persistence.*;

// has fk to the map it's in
@Entity
@Table(name="cell")
@JsonIgnoreProperties(value="map")
public class DungeonCell implements Travelable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="map_id")
    private DungeonMap map;

    @Column(name="cell_x")
    private int x;

    @Column(name="cell_y")
    private int y;

    @Enumerated(EnumType.STRING)
    private GroundType groundType;

    @Transient
    private CellEntity cellEntity; // set when building the map by "placing" each entity on it's cell

    public DungeonCell() {

    }

    public DungeonCell(DungeonMap map, int x, int y, GroundType groundType) {
        this.map = map;
        this.x = x;
        this.y = y;
        this.groundType = groundType;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public DungeonMap getMap() {
        return map;
    }
    public void setMap(DungeonMap map) {
        this.map = map;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public GroundType getGroundType() {
        return groundType;
    }
    public void setGroundType(GroundType groundType) {
        this.groundType = groundType;
    }

    /** Travelable interface */
	@Override
	public double getEnterWeight() {
		return groundType.enterWeight;
	}

	@Override
	public boolean isPassable() {
		return true;
	}

}