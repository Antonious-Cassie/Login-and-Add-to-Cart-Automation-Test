Selenium Automation Framework

This project is a basic Selenium automation framework built using Java, TestNG, and the Page Object Model (POM) design pattern.

Features Implemented
Login functionality
Add to Cart functionality
Page Object Model structure
Explicit waits for synchronization

Tech Stack
Java
Selenium WebDriver
TestNG
Maven (if applicable)

Project Structure
pages/ → Page classes (LoginPage, ProductPage)
tests/ → Test classes (LoginTest, addToCartTest)

Notes on Test Coverage

The automation was performed on a Shopify demo site:

https://sauce-demo.myshopify.com/

While login and add-to-cart flows were successfully automated, some scenarios such as:

Remove from cart
Logout functionality

were not completed due to instability and flakiness of the demo website, including:

Slow or incomplete page loading
Popups blocking interactions
Inconsistent navigation behavior during automation

Learning Outcomes
Implemented Page Object Model (POM)
Practiced element locating strategies (ID, className, etc.)
Used explicit waits to handle dynamic elements
Learned to handle real-world issues like flaky test environments

Future Improvements
Add remove-from-cart test
Add logout test
Improve test reliability on a more stable environment
Extend framework with more test cases
