import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {

    public static void main(String args[]) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            System.out.println("Tworzenie osób:");
            var osoba = new Kierowca("Patryk" , "Zaprzaluk" , 'B' , 2);
            System.out.println(osoba);
            session.save(osoba);
            List<Osoba> osobaFromDb = session.createQuery("from Osoba").list();
            for ( var osoby : osobaFromDb) {
                System.out.println(osoby);
            }
            System.out.println("Tworzenie samochodu:");
            Samochod samochod = new Samochod("Audi" , "A6" , 250000);
            session.save(samochod);
            List<Samochod> samochodyZBazy = session.createQuery("from Samochod").list();
            for (var tmp : samochodyZBazy){
                System.out.println(tmp);
            }
            samochod.getKierowcy().add(osoba);

            List<Samochod> samochodyDB = session.createQuery("from Samochod").list();
            for (var tmp : samochodyDB){
                System.out.println(tmp);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}