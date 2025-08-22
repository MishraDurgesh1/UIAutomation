Feature: Automate Sauce Demo Application

  Scenario Outline: Login to the application
    Given Open the browser and navigate to the application
    When Enter the "<username>" and "<password>" and click on login
    Then Verify the title of the page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |