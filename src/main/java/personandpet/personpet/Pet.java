package personandpet.personpet;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long age;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="person_id")
    private Person person;


    public Pet() {
    }



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

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
