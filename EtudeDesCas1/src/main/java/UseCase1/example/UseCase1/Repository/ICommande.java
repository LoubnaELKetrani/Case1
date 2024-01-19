package UseCase1.example.UseCase1.Repository;

import UseCase1.example.UseCase1.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICommande extends JpaRepository< Commande,Long> {
    List<Commande> findByDateAfter(LocalDate date);
    List<Commande> findCommandeByDateAfter(LocalDate date);
    List<Commande> findAllByDateAfter(LocalDate date);

}
