package main.java.com.savelocation.model;

import javax.persistence.*;

@Entity
@Table(name = "State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameState")
    private String state;

    @OneToMany(name = "city_id")
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnameState() {
        return state;
    }

    public void setnameState(String state) {
        this.state = state;
    }


}
