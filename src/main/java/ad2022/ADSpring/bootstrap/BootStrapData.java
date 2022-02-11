package ad2022.ADSpring.bootstrap;



import ad2022.ADSpring.domain.Ability;
import ad2022.ADSpring.domain.Pokemon;
import ad2022.ADSpring.repository.AbilityRepository;
import ad2022.ADSpring.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final PokemonRepository pokemonRepository;
    private final AbilityRepository abilityRepository;

    public BootStrapData(PokemonRepository pokemonRepository, AbilityRepository abilityRepository) {
        this.pokemonRepository = pokemonRepository;
        this.abilityRepository = abilityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Pokemon charmander = new Pokemon("Carmander", 200);
        Ability blaze = new Ability("blaze", "Powes up fire");

        charmander.getAbilities().add(blaze);
        blaze.getPokemons().add(charmander);

        pokemonRepository.save(charmander);
        abilityRepository.save(blaze);

        System.out.println("numero de pokemons: " + pokemonRepository.count());
        System.out.println("numero de abilidades: " + abilityRepository.count());
    }
}
