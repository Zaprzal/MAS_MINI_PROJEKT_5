import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Osoba")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Osoba {

    private Integer id;
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.nazwisko = nazwisko;
        this.imie = imie;
    }
    public Osoba() {
    }


    public String getNazwisko() {
        return nazwisko;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return this.imie+' '+this.nazwisko;
    }
}
