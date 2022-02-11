package ad2022.ADSpring.domain;

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
    private Set<Pokemon> pokemons = new HashSet<>();
}
