# 🛒 Hybrid NopCommerce Automation Framework

Automation testing framework for the [nopCommerce demo website](https://demo.nopcommerce.com), built with **Java + Selenium WebDriver + TestNG**, following **Hybrid Framework** architecture combining Page Object Model, Page UI pattern, and reusable base utilities.

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Log4j2
- Extent Report 5
- IntelliJ IDEA
- Chrome / Firefox

---

## ⚙️ Prerequisites

Before running the project, make sure you have installed:

- ✅ **JDK 11 or higher** – [Download here](https://www.oracle.com/java/technologies/downloads/)
- ✅ **IntelliJ IDEA** – [Download here](https://www.jetbrains.com/idea/)
- ✅ **Google Chrome** (or Firefox) – latest version
- ✅ **ChromeDriver** matching your Chrome version – [Download here](https://chromedriver.chromium.org/)
- ✅ **Git** – to clone the repository

---

## 📁 Project Structure

```
hybrid-nopcommerce-framework/
│
├── actions/
├── htmlExtent/
├── interface/pageUIs/
├── libExtent5/
├── libLog4J2/
├── libraries/
├── resources/
├── sourceDocs/
├── testcase/com/nopcommerce/
├── .gitignore
└── hybrid-nopcommerce-framework.iml
```

---

## ▶️ How to Run

### 1. Clone the repository
```bash
git clone <your-repo-link>
```

### 2. Open in IntelliJ IDEA
- File → Open → select the project folder
- Wait for IntelliJ to index the project

### 3. Configure the test environment
- Open `resources/` folder
- Update browser type and base URL in the config file if needed

### 4. Run the tests

- Right-click on `testng.xml` → Run

---

## 📊 Reporting & Logging

- **Extent Report 5** – after each run, an HTML report is generated in the `htmlExtent/` folder
- **Log4j2** – execution logs are printed to console and/or log file, configured via `libLog4J2/`

To view the report:
```
Open: htmlExtent/ExtentReport.html in any browser
```

---

## 🎯 Project Purpose

This project was built for **learning and practicing automation testing**, with a focus on:

- Designing a clean and maintainable framework architecture
- Applying best practices in Selenium + TestNG
- Separating locators from logic (Page UI pattern)
- Writing reusable and scalable test scripts

---

## 👤 Author

- **GitHub:** [quynh073](https://github.com/quynh073)
- Built for learning purposes — contributions and feedback are welcome!
