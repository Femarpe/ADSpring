package ad2022.ADSpring.Repository;

import ad2022.ADSpring.Domain.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {
}
