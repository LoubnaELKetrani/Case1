package UseCase1.example.UseCase1.Controller;

import UseCase1.example.UseCase1.Entities.Commande;
import UseCase1.example.UseCase1.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/all")
    public List<Commande>GetAllCommande(){
        return commandeService.GetAllCommandes();
    }

    @GetMapping("/{id}")
    public Optional GetCommandeById(Long idCommande){
       return commandeService.GetCommandeById(idCommande);
    }

    @PostMapping("/CreateCmd")
    public void CreateCommande(@RequestBody Commande commande){
        commandeService.CreateCommande(commande);
    }

    @PutMapping("/{id}")
    public void UpdateCommande(Long idCommande , Commande commande){
        commandeService.UpdateCommande(idCommande,commande);
    }
    @DeleteMapping("/{id}")
    public void DeleteCommande(Long idCommande){
        commandeService.DeleteCommande(idCommande);
    }
    @GetMapping("Latest")
    public List<Commande>getDernieresCommandes(){
       return commandeService.getDernieresCommandes();
    }

}
