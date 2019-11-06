Feature: CodersGuru account registration

  Scenario: user can log in


    Given an open browser with https://tester.codersguru.pl/
    When user click on "Załóż konto" button
    Then fill registration form, log in
    And close browser

