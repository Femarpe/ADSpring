package ad2022.ADSpring.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private double power;

    @ManyToMany(mappedBy = "pokemons")
    private Set<Ability> abilities = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idType")
    private Type type;

    public Pokemon() {
    }

    public Pokemon(long id, String name, double power, Set<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.abilities = abilities;
    }


    public Pokemon(String name, double power) {
        this.name = name;
        this.power = power;
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

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "Pokemon [idPokemon= " + id + ", nombrePokemon= " + name + ", poder=" + power + "]";
    }
}
