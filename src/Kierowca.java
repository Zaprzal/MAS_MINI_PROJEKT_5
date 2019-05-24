import javax.persistence.Entity;

@Entity(name = "Kierowca")
public class Kierowca extends Osoba{
    private int pensja = 3200;
    private char dl;
    private int staz;

    public Kierowca(String imie, String nazwisko, char dl, int staz) {
        super(imie, nazwisko);
        this.dl = dl;
        this.staz = staz;
    }

    public Kierowca() {
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public char getDl() {
        return dl;
    }

    public void setDl(char dl) {
        this.dl = dl;
    }

    public int getStaz() {
        return staz;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    @Override
    public String toString() {
        return super.toString() + ' '+this.dl+' '+this.pensja;
    }
}
