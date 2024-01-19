package UseCase1.example.UseCase1.Service;

import UseCase1.example.UseCase1.Entities.Commande;
import UseCase1.example.UseCase1.Repository.ICommande;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RefreshScope
public class CommandeService {

    @Autowired
    private ICommande iCommande;
    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    public CommandeService(ICommande commande){
        this.iCommande=commande;
    }
    public List<Commande>GetAllCommandes(){
        return iCommande.findAll();
    }
    public Optional<Commande> GetCommandeById(Long idCommande){
        return iCommande.findById(idCommande);
    }

    public void CreateCommande(Commande commande){
        iCommande.save(commande);
    }

    public void UpdateCommande(Long idCommande , Commande Updcommande){
        if (iCommande.existsById(idCommande)){
            Updcommande.setId_commande(idCommande);
            iCommande.save(Updcommande);
        }
        else {
            System.out.println("No Existing commande");
        }

    }

    public void DeleteCommande(Long idCommande){
        iCommande.deleteById(idCommande);
    }



    public List<Commande> getDernieresCommandes() {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateLimite = currentDate.minusDays(commandesLast);
        List<Commande> result = iCommande.findByDateAfter(dateLimite);
        return result;

    }
}
