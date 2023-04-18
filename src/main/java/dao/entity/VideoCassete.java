package dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class VideoCassete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identyfikator;
    private String tytul;
    public LocalDate rokProdukcji;

    public long getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(long identyfikator) {
        this.identyfikator = identyfikator;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public LocalDate getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(LocalDate rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public VideoCassete(long identyfikator, String tytul, LocalDate rokProdukcji) {
        this.identyfikator = identyfikator;
        this.tytul = tytul;
        this.rokProdukcji = rokProdukcji;
    }

    public VideoCassete() {
    }
}
