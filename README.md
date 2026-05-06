# Selenium Automation Framework (Java + TestNG)

## Overview

This project is a Selenium-based automation testing framework built using Java, Maven, and TestNG.

The framework follows the Page Object Model (POM) design pattern and supports:

* Cross-browser ready architecture
* Parallel execution using TestNG
* Retry mechanism for flaky tests
* Screenshot capture on failure
* Thread-safe WebDriver management using ThreadLocal
* Logging support using Log4j2
* Data-driven testing using TestNG DataProvider

---

# Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Log4j2
* Git & GitHub
* WebDriverManager

---

# Framework Features

## Page Object Model (POM)

Reusable page classes for better maintainability and scalability.

## DriverFactory

Centralized WebDriver management with ThreadLocal support for parallel execution.

## Parallel Execution

Supports parallel test execution through TestNG XML configuration.

## Retry Analyzer

Automatically retries flaky or transient test failures.

## Screenshot on Failure

Captures screenshots automatically whenever a test fails.

## Logging

Implemented Log4j2 logging for better debugging and execution tracking.

## Config-Driven Execution

Browser and environment details are managed through config.properties.

---

# Project Structure

```text
src
 ├── main
 │    └── java
 │         └── com.anu.automation.framework
 │               ├── base
 │               ├── driver
 │               ├── pages
 │               └── utils
 │
 ├── test
 │    ├── java
 │    │     └── com.anu.automation.framework
 │    │           ├── testcases
 │    │           ├── listener
 │    │           └── retry
 │    │
 │    └── resources
 │          └── log4j2.xml
 │
 └── resources
      └── config
           └── config.properties
```

---

# Test Scenarios Covered

* Product search validation
* Partial search validation
* Invalid search validation
* Case-insensitive search validation
* Parallel execution validation
* Retry handling validation

---

# How to Run the Project

## Clone Repository

```bash
git clone <your-github-repo-url>
```

---

## Navigate to Project

```bash
cd selenium-java
```

---

## Run Tests

```bash
mvn clean test
```

---

## Run Through TestNG XML

```bash
Right Click → testng.xml → Run As → TestNG Suite
```

---

# Sample Features Demonstrated

* Explicit waits
* Thread-safe browser execution
* Retry handling for flaky tests
* Screenshot utility
* Logging and reporting support
* DataProvider implementation

---

# Future Enhancements

* Extent Reports / Allure Reports
* API Automation Framework
* CI/CD integration using Jenkins or GitHub Actions
* Docker execution support
* Playwright automation framework

---

# Author

Anubhuti Kaur Sethi

GitHub: (https://github.com/anubhutikaursethi-wq)
