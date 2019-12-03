package refunds;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

class Defectueux {
    static String defectueux(String etat, String garantie) {
        return "défectueux".equals(etat)&& "valide".equals(garantie) ? "oui" : "non";
    }
}

class Remplacable {
    static String remplacable(String solution,String garantie) {
        if ("epuise".equals(garantie))
            return "garantie épuisé";
        else
        return "remplacé".equals(solution) ? "remplacé" : "réparé";
    }
}


public class Stepdefs {
    private String etat;
    private String garantie;
    private String solution;
    private String remboursement;
    private String reparation;

    @Given("Le produit est défectueux et le garantie est épuisé")
    public void produit_defectueux_garantie_epuise() {
        this.etat = "défectueux";
        this.garantie = "epuise";
    }

    @Given("Le produit est défectueux et le garantie est valide")
    public void produit_defectueux_garantie_valide() {
        this.etat = "défectueux";
        this.garantie = "valide";
    }

    @Given("Le produit est normal")
    public void produit_normal() {
        this.etat = "normal";
    }

    @When("Le client demande à être remboursé")
    public void Client_demande_un_remboursement() {
        remboursement = Defectueux.defectueux(etat,garantie);
    }

    @Then("Je devrais dire {string}")
    public void je_devrais_dire(String expectedAnswer) {
        assertEquals(expectedAnswer, remboursement);
    }

    @Given("Le produit peut être réparé et le garantie est valide")
    public void produit_peut_etre_repare() {
        this.solution = "réparé";
        this.garantie= "valide";
    }

    @Given("Le produit peut être remplacé et le garantie est valide")
    public void produit_peut_etre_remplace() {
        this.solution = "remplacé";
        this.garantie = "valide";
    }

    @Given("Le produit peut être réparé et le garantie est épuisé")
    public void garantie_epuise_pour_reparation() {
        this.solution = "réparé";
        this.garantie = "epuise";
    }

    @Given("Le produit peut être remplacé et le garantie est épuisé")
    public void garantie_epuise_pour_remplacement() {
        this.solution = "remplacé";
        this.garantie = "epuise";
    }

    @When("Le client demande une solution")
    public void Client_demande_une_solution() {
        reparation = Remplacable.remplacable(solution,garantie);
    }

    @Then("Je devrais proposer {string}")
    public void je_devrais_proposer(String expectedAnswer) {
        assertEquals(expectedAnswer, reparation);
    }
}