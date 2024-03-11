Feature:Login and Product Listing
  Scenario:User logs in and verifies product listing
    Given User is on the login page
    When user logs in with valid credentials
Then product listing is displayed


Scenario: User sorts product listing and adds to cart
Given user sorts product listing by "Price (low to high)"
  When user adds first 3 low-priced products to cart
And user proceeds to checkout
Then verify cart contains 3 items
