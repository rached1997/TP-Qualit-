Feature: Is it possible to refund?
  Client wants to know is it possible to get refund

  Scenario: Client can't get refunds
      Given Product is Normal
      When Client asks to get refunds
      Then I should tell "Nope"

  Scenario: Client can get refunds
        Given Product is Defective
        When Client asks to get refunds
        Then I should tell "Yes"

  Scenario: Product is Defective
          Given Product can be repaired
          When Client asks about solution
          Then I should propose "Repaired"

  Scenario: Product is Defective
            Given Product can be replaced
            When Client asks about solution
            Then I should propose "Replaced"