package ad2022.ADSpring.controler;

import ad2022.ADSpring.domain.Pokemon;
import ad2022.ADSpring.repository.PokemonRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonRestControler {
    private final Log log = LogFactory.getLog(PokemonRestControler.class);

    private final PokemonRepository pokemonRepository;

    public PokemonRestControler(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping("/pokemons")
    List<Pokemon> getAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @GetMapping("/pokemons/{id}")
    Pokemon one(@PathVariable Long id) throws PokemonNotFoundException {
        return pokemonRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new PokemonNotFoundException(id));
    }

    @GetMapping("/")
    public String showDocumenation(Model model) {
        return "index";
    }

    @GetMapping("/view/pokemons")
    public String getPokemons(Model model){
        model.addAttribute("pokemons",pokemonRepository.findAll());
        return "pokemon/list";
    }

    @GetMapping("/view/addpokemon")
    public String addPokemon(Model model){
        model.addAttribute("pokemon", new Pokemon());
        return "pokemon/add-pokemon";
    }

    @PostMapping("/view/createdpokemon")
    public String addPokemon(@ModelAttribute Pokemon pokemon, Model model){
        pokemonRepository.save(pokemon);
        model.addAttribute("pokemon", pokemon);
        return "pokemon/result";
    }

    @PostMapping("/pokemons")
    Pokemon newPokemon(@RequestBody Pokemon newPokemon) {
        log.info("newPokemon");
        return pokemonRepository.save(newPokemon);
    }


    @PutMapping("/pokemons/{id}")
    Pokemon replacePokemon(@RequestBody Pokemon newPokemon, @PathVariable Long id) {
        return pokemonRepository.findById(Math.toIntExact(id)).map(pokemon -> {
            pokemon.setName(newPokemon.getName());
            pokemon.setPower(newPokemon.getPower());
            return pokemonRepository.save(pokemon);
        }).orElseGet(() -> {
            newPokemon.setId(id);
            return pokemonRepository.save(newPokemon);
        });
    }

    @DeleteMapping("/pokemons/{id}")
    void deletePokemon(@PathVariable long id) {
        pokemonRepository.deleteById(Math.toIntExact(id));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private class PokemonNotFoundException extends RuntimeException {
        public PokemonNotFoundException(Long id) {
            System.out.println("pokemon con id:" + id + "no locolizado");
        }
    }
}
