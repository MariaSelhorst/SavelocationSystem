package main.java.com.savelocation.model;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameCity")
    private String city;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnameCity() {
        return city;
    }

    public void setnameCity(String city) {
        this.city = city;
    }

}

