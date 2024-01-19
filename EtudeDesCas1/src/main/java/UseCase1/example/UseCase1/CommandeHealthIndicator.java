package UseCase1.example.UseCase1;


import UseCase1.example.UseCase1.Repository.ICommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }





    @Autowired
    private ICommande iCommande;

    @Override
    public Health health() {
        if (commandesExist()) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("Reason", "pas de commande").build();
        }
    }

    private boolean commandesExist() {
        return !iCommande.findAll().isEmpty();
    }
}
