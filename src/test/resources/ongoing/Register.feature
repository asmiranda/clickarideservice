# feature/Register.feature
Feature: Register
  @Register

  Scenario Outline: Register
    Given actor
    When actor is <type> and typed <username>, <password>, <firstName>, <lastName>
    Then the actor will be <type>

    Examples:
      | sub-scenario | type               | username | password | firstName | lastName |
      | l-1.10       | passenger          | passen1  | 123456   | Pass_1    | Pass_1   |
      | l-1.11       | passenger          | passen2  | 123456   | Pass_2    | Pass_2   |
      | l-1.12       | driver             | driver1  | 123456   | Driv_1    | Driv_1   |
      | l-1.13       | driver             | driver2  | 123456   | Driv_2    | Driv_2   |
