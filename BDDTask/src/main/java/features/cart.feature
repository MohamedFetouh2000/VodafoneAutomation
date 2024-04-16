Feature: user can add items to cart from search and from home page

Scenario: User selects 3 items and add it to the cart one of them from search
  Given User surfs on home page and login valid mobile and valid password
  When selects item and add it to cart
  And Selects another item and add it to cart
  And Search for an item and add it to cart
  Then items in the cart is 3 items