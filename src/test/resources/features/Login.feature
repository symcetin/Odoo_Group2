@login
Feature: Login to Application

  Background:
    Given User is on the login page

  Scenario:
    When User logs in with valid credentials
    Then Page title should be "#Inbox - Odoo"

  Scenario:
    When User logs in with invalid credentials
    Then User should see error message