@PlayMusic
Feature: Play Music in Youtube Music

  @PlayMusicSuccess
  Scenario Outline: Play music success after find artist name
    Given User success access Youtube Music
    When User find girl group name
    And User click Shuffle button
    Then Verify music playing successfully

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |