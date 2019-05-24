import javax.persistence.Entity;

@Entity(name = "Kierownik")
public class Kierownik extends Osoba {
    private String wyksztalcenie;
    private int pensja = 4800;

    public Kierownik(String imie, String nazwisko, String wyksztalcenie) {
        super(imie, nazwisko);
        this.wyksztalcenie = wyksztalcenie;
    }

    public Kierownik() {
    }

    public String getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(String wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    @Override
    public String toString() {
        return super.toString()+ ' '+this.wyksztalcenie+' '+this.pensja;
    }
}

