package ad2022.ADSpring.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String effect;

    @ManyToMany
    @JoinTable(name = "pokemon_ability", joinColumns = @JoinColumn(name = "id_ability"), inverseJoinColumns = @JoinColumn(name = "id_pokemon"))
    private Set<Pokemon>pokemons = new HashSet<>();

    public Ability(Long id, String name, String effect, Set<Pokemon> pokemons) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        this.pokemons = pokemons;
    }

    public Ability( String name, String effect) {
        this.name = name;
        this.effect = effect;
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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    @Override
    public String toString() {
        return "Tramite [idAbility= " + id + ", nombreAbility= " + name + ", efecto =" + effect + "]";
    }
}
