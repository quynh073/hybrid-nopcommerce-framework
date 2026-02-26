# Hybrid NopCommerce Automation Framework

This project is a Selenium WebDriver automation framework built using Java and TestNG to automate core features of the nopCommerce demo website.

The framework is designed based on Hybrid Framework architecture combining:
- Page Object Model (POM)
- Page UI pattern
- BasePage abstraction
- Reusable utilities
- Logging and reporting integration

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven (if using)
- Log4j2
- Extent Report 5
- Page Object Model

  ## 📁 Project Structure

hybrid-nopcommerce-framework
│
├── actions/                # Base classes (BasePage, BaseTest, PageGeneratorManager)
├── interface/pageUIs/      # UI locators (Page UI classes)
├── testcase/com/nopcommerce/ # Test classes
├── htmlExtent/             # Generated reports
├── libExtent5/             # Extent Report libraries
├── libLog4J2/              # Log configuration
├── resources/              # Config files
├── sourceDocs/             # Documentation
└── libraries/              # External libraries

## 🏗 Framework Architecture

This framework follows Hybrid design pattern:

- Page Object Model for page interaction
- Page UI pattern for locator separation
- BasePage for reusable WebDriver methods
- BaseTest for setup/teardown management
- PageGeneratorManager for centralized page initialization

  ## ✅ Automated Features

- User Registration
- Login
- Search Product
- Add to Cart
- Sort Product (Name A-Z, Z-A)
- Sort Product by Price
- Display Product (Grid/List mode)

  ## ▶️ How to Run the Project

1. Clone the repository:
   git clone <your-repo-link>
2. Open project in IntelliJ IDEA
3. Run testng.xml file
Or run test class directly from IDE.

## 📊 Reporting

- Extent Report 5 integrated
- HTML report generated in htmlExtent folder
- Log4j2 for logging execution steps

  ## 🎯 Project Purpose

This project was built for learning and practicing automation testing, focusing on:
- Designing maintainable framework architecture
- Writing clean and reusable test scripts
- Implementing best practices in Selenium automation
