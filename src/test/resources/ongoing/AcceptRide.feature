# feature/Register.feature
Feature: AcceptRide
  @AcceptRide

  Scenario Outline: AcceptRide
    Given drivers and passenger registered
      | type               | username | password | firstName | lastName |
      | passenger          | passen1  | 123456   | Pass_1    | Pass_1   |
      | passenger          | passen2  | 123456   | Pass_2    | Pass_2   |
      | driver             | driver1  | 123456   | Driv_1    | Driv_1   |
      | driver             | driver2  | 123456   | Driv_2    | Driv_2   |
    When passenger <paction>
    And driver <daction>
    Then the ride will be <status>

    Examples:
      | sub-scenario | passenger | driver   | paction1 | daction1 | status1 | paction2 | daction2 | status2 |
      | l-1.10       | passen1   | driver1  | request  | accept   | accept  | request  | accept   | accept  |
