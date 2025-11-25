# 🐾 JPetStore Automation Framework

A fully automated end-to-end test framework for the JPetStore demo application, designed using:

- ✅ BDD (Cucumber + Gherkin)
- ✅ Selenium WebDriver
- ✅ Java
- ✅ Page Object Model (POM)
- ✅ CI/CD with GitHub Actions
- ✅ Docker Execution
- ✅ Dynamic test data & flows

---

## 1️⃣ Project Goals

- **Automate realistic user journeys** on JPetStore.
- **Use modern testing best practices** (BDD + POM).
- **Generate professional HTML reports.**
- **Support CI execution** on GitHub runners.
- **Support isolated execution** in Docker.
- **Ensure randomness & dynamic behavior** to reduce hard-coding.

---

## 2️⃣ Tech Stack

| Component | Tool |
| :--- | :--- |
| **Language** | Java 17 |
| **UI Automation** | Selenium WebDriver |
| **BDD Framework** | Cucumber |
| **Design Pattern** | Page Object Model (POM) |
| **Build Tool** | Maven |
| **Reporting** | Masterthought HTML + Allure |
| **CI/CD** | GitHub Actions |
| **Containerization** | Docker |
| **Driver Manager** | WebDriverManager |

---

## 3️⃣ Architecture

```text
jpetstore-cucumber
│
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── hooks
│   │   │   ├── pages
│   │   │   ├── runners
│   │   │   ├── stepdefinitions
│   │   │   └── utils
│   │   └── resources
│   │       ├── features
│   │       └── config
│   │
│   └── main
│       └── java   ✅ (empty – UI tests only, no application code)
│
├── pom.xml
├── Dockerfile
└── .github
    └── workflows
        └── ci.yml
```

# 4️⃣ Framework Highlights (IMPORTANT)

# ⭐ BDD with Cucumber + Selenium
- Test logic is written in plain English Gherkin
- Step definitions map behavior to Selenium actions
- Easy to read, easy to maintain

### ⭐ Page Object Model (POM)
- Each page has its own class
- Locators, The action is performed in stepdefinintions for purposes
- Cleaner, reusable code

### ⭐ Explicit Waits
- All page interactions use explicit waits to avoid flaky timing issues
- Ensures elements are ready before interacting and it is done in POM

### ⭐ Sleep in Step Layer (On Purpose)
- Some site actions require human-like pacing.
- A short sleep simulates realistic behavior and prevents random failures.
- Not best practice normally — but better than having random failures

### ⭐ Random & Dynamic Behavior
Every run:
- Generates a new user
- Randomly selects a category
- Randomly selects a product & variant
- ✅ No hardcoding
- ✅ More realistic testing
- ✅ Higher coverage

---

## 5️⃣ Reporting

### ⭐ Masterthought HTML Report
Chosen because it is clean, visual, and easy to share.

**How it's generated:**
- Cucumber produces `cucumber.json`
- After tests, a Java utility builds: `target/cucumber-html-reports/`

### ⭐ Allure Report (Optional second report)
Captures steps & attachments.
**Stored in:**
- `target/allure-results/`
- `target/allure-report/`

---

## 6️⃣ Running Tests Locally

### ✅ Prerequisites
- Java 17+
- Maven installed
- Chrome installed

### ✅ Run tests
From Eclipse using righ click on the test runner then run as junit test 
or right click on pom.xml then run as mvn test or from cmd
```bash
mvn test -Dheadless=true -Dallure.results.directory=target/allure-results

## 7️⃣ Running Tests in Docker

### ✅ Build Image
```bash
docker build -t jpetstore-tests .

## ✅ Run Tests

```bash
docker run jpetstore-tests
```
## 8️⃣ CI/CD Pipeline (GitHub Actions)

The pipeline contains **2 jobs**:

| Job             | Description                            |
|-----------------|----------------------------------------|
| ✅ GitHub Runner | Executes tests on hosted VM            |
| ✅ Docker Runner | Executes tests inside Docker container |

### Triggers
- ✅ Runs manually  
- ✅ Runs on schedule 

### Artifacts Uploaded
- Masterthought report  
- Allure report  
- Docker Masterthought report  
- Docker Allure report
## ✅ 9️⃣ Key Benefits

- ✅ Clean architecture  
- ✅ Easy to extend  
- ✅ Human-like flows reduce flakiness  
- ✅ True randomness improves coverage  
- ✅ CI + Docker makes it production-ready
