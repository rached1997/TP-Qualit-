Feature: Est-il possible de rembourser?
  Le client veut savoir s'il est possible d'obtenir un remboursement

  Scenario: Le client ne peut pas obtenir de remboursement
        Given Le produit est défectueux et le garantie est épuisé
        When  Le client demande à être remboursé
        Then  Je devrais dire "non"

  Scenario: Le client peut obtenir de remboursement
    Given Le produit est défectueux et le garantie est valide
    When  Le client demande à être remboursé
    Then  Je devrais dire "oui"

  Scenario: Le client ne peut pas obtenir de remboursement
    Given Le produit est normal
    When  Le client demande à être remboursé
    Then  Je devrais dire "non"

  Scenario: Le produit est défectueux et garantie valide
          Given Le produit peut être réparé et le garantie est valide
          When  Le client demande une solution
          Then  Je devrais proposer "réparé"

  Scenario: Le produit est défectueux et garantie valide
            Given Le produit peut être remplacé et le garantie est valide
            When  Le client demande une solution
            Then  Je devrais proposer "remplacé"

  Scenario: Le produit est défectueux et garantie épuisé
    Given Le produit peut être réparé et le garantie est épuisé
    When  Le client demande une solution
    Then  Je devrais proposer "garantie épuisé"

  Scenario: Le produit est défectueux et garantie épuisé
    Given Le produit peut être remplacé et le garantie est épuisé
    When  Le client demande une solution
    Then  Je devrais proposer "garantie épuisé"