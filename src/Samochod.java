import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Samochod")
public class Samochod {

    public enum CarType {Unknown, Terenowy, Osobowy}
    private Integer id;
    private String marka;
    private String model;
    private int przebieg;
    private CarType type;
    private List<Kierowca> kierowcy = new ArrayList<>();




    public Samochod(String marka, String model, int przebieg) {
        this.marka = marka;
        this.model = model;
        this.przebieg = przebieg;
    }
    public Samochod() {
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Kierowca> getKierowcy() {
        return kierowcy;
    }

    public void setKierowcy(List<Kierowca> kierowcy) {
        this.kierowcy = kierowcy;
    }

    @Override
    public String toString() {
        return "id:" + this.id+' '+this.marka + ' '+ this.model+' '+this.przebieg + ' '+this.getKierowcy();
    }
}
