Feature: Amazon login

Scenario: the user buys a product successfully
Given the user enters the Amazon Webpage
When the searches for the particular product 
And the user enters the viewpage of the product
And the user adds the product to the cart
Then the user searches for few more products
And the user adds them to the cart
Then the user proceeds to checkout
  
