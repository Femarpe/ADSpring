package ad2022.ADSpring.Domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String effect;

    @ManyToMany
    @JoinTable(name = "Pokemon_ability", joinColumns = @JoinColumn(name = "id_ability"), inverseJoinColumns = @JoinColumn(name = "id_pokemon"))

    private Set<Pokemon>pokemons = new HashSet<>();

    public Ability(Long id, String name, String effect, Set<Pokemon> pokemons) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        this.pokemons = pokemons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
