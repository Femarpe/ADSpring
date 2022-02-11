package ad2022.ADSpring.repository;

import ad2022.ADSpring.domain.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {

}
