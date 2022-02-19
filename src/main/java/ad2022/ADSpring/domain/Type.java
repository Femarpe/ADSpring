package ad2022.ADSpring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idType;
    private String typeName;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<Pokemon> pokemons = new HashSet<>();

    public Type() {
    }
}
