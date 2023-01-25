package dasPortefeuillecom.example.dasPortefeuille;

import org.springframework.boot.CommandLineRunner;

public interface EnvLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Dotenv dotenv = Dotenv.configure().directory("src/main/resources/.env").load();
    }
}
