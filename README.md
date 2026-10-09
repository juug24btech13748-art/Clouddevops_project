# Student Result Management System — Continuous Integration (CI) Pipeline

[![Java CI](https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPOSITORY_NAME/actions/workflows/ci.yml/badge.svg)](https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPOSITORY_NAME/actions/workflows/ci.yml)

## 1. Project Title
**Student Result Management System — Continuous Integration (CI) Pipeline Using GitHub Actions**  
*Cloud DevOps Assignment — Unit III*

---

## 2. Project Overview
The **Student Result Management System** is a lightweight, robust Java Maven application designed to manage student academic scores, compute total marks, determine averages, assign letter grades based on standard grading scales, and verify pass/fail status.

This project is integrated with an automated Continuous Integration (CI) pipeline powered by **GitHub Actions**. Every time code changes are pushed or a pull request is submitted, the CI pipeline automatically compiles the Java source code, downloads dependencies, and executes unit tests written with JUnit 5.

---

## 3. Problem Statement
In traditional software development, code changes are frequently merged manually without immediate automated verification. This leads to broken builds, hidden bugs, and delayed feedback cycles. 

To solve this problem in academic score processing software, this project implements a Continuous Integration (CI) workflow that automatically verifies code quality, compilation integrity, and functional correctness upon every push to GitHub.

---

## 4. Objectives
- Develop a core Java application (`StudentResult.java`) to process student academic marks with strict validation.
- Implement comprehensive automated unit tests using **JUnit 5 Jupiter** (`StudentResultTest.java`).
- Configure Apache Maven (`pom.xml`) for dependency management and lifecycle execution.
- Create an automated GitHub Actions YAML workflow (`ci.yml`) to enforce Continuous Integration.
- Gain hands-on experience in DevOps CI workflows, local verification, and automated build pipelines.

---

## 5. Features and Operations

The `StudentResult` module provides the following key operations:

1. **`calculateTotal()`**: Calculates the sum of all subject marks obtained by a student.
2. **`calculateAverage()`**: Computes the arithmetic mean of all subject marks.
3. **`calculateGrade()`**: Assigns a letter grade according to the following scale:
   - **Average >= 90**: Grade **A**
   - **Average >= 75**: Grade **B**
   - **Average >= 60**: Grade **C**
   - **Average >= 40**: Grade **D**
   - **Average < 40**: Grade **F**
4. **`hasPassed()`**: Determines pass/fail status. A student passes **only if every individual subject mark is at least 35**.
5. **Input Validation**: Ensures that at least one subject mark is provided and every mark lies strictly within `[0, 100]`. Throws `IllegalArgumentException` for invalid inputs.

---

## 6. Technology Stack

- **Programming Language:** Java 17 (Eclipse Adoptium / OpenJDK)
- **Build Tool:** Apache Maven 3.x
- **Testing Framework:** JUnit 5 (Jupiter API & Engine v5.10.2)
- **Version Control:** Git
- **CI/CD Platform:** GitHub Actions
- **Configuration Format:** YAML / XML

---

## 7. Project Folder Structure

```text
StudentResultManagement-CI/
├── .github/
│   └── workflows/
│       └── ci.yml             # GitHub Actions CI Workflow Configuration
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── studentresult/
│   │               └── StudentResult.java       # Core Java Application Logic
│   └── test/
│       └── java/
│           └── com/
│               └── studentresult/
│                   └── StudentResultTest.java   # JUnit 5 Automated Unit Tests
├── .gitignore                 # Specifies intentionally untracked build & IDE files
├── pom.xml                    # Maven Project Object Model Configuration
└── README.md                  # Comprehensive Project Documentation & Assignment Guide
```

---

## 8. Prerequisites

Ensure you have the following installed on your machine before running locally:

- **Java JDK 17** or higher (`java -version`)
- **Apache Maven 3.6+** (`mvn -version`)
- **Git** (`git --version`)

---

## 9. Instructions to Run the Project Locally

### Step 1: Open Terminal in Project Directory
Navigate to the project root folder where `pom.xml` is located:
```bash
cd path/to/StudentResultManagement-CI
```

### Step 2: Clean and Compile Code
To compile the Java source files without running tests:
```bash
mvn clean compile
```

---

## 10. Maven Test Commands

### Execute Unit Tests Only
To run all JUnit 5 test cases and view test results:
```bash
mvn clean test
```

### Execute Full Build & Verification
To compile, test, package, and verify the entire project:
```bash
mvn clean verify
```

Expected terminal output upon successful execution:
```text
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.studentresult.StudentResultTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.045 s -- in com.studentresult.StudentResultTest
[INFO] 
[INFO] RESULTS:
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

---

## 11. Explanation of GitHub Actions Workflow

The CI workflow is defined in `.github/workflows/ci.yml`.

```yaml
name: Java CI

on:
  push:
    branches: [ "**" ]
  pull_request:
    branches: [ "**" ]

jobs:
  build:
    name: Build and Test Project
    runs-on: ubuntu-latest

    steps:
      - name: Checkout Repository
        uses: actions/checkout@v4

      - name: Set up Java JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: 'maven'

      - name: Build and Test with Maven
        run: mvn --batch-mode clean verify
```

### How It Works:
1. **Trigger (`on`)**: Fires automatically on any code `push` or `pull_request` to any branch in the GitHub repository.
2. **Runner (`runs-on`)**: Provisions a clean, cloud-hosted virtual machine running `ubuntu-latest`.
3. **Checkout (`actions/checkout@v4`)**: Clones the latest commit of the repository into the runner's environment.
4. **JDK Setup (`actions/setup-java@v4`)**: Installs Temurin OpenJDK 17 and configures Maven dependency caching for faster build execution.
5. **Build & Test (`mvn clean verify`)**: Runs Maven in non-interactive batch mode to compile source code, discover tests, and run all JUnit test cases. If any test fails, the workflow immediately fails and sends a notification.

---

## 12. Instructions to Initialize Git & Push to GitHub

Follow these steps to upload your project to GitHub:

### Step 1: Initialize Git Repository
In your project folder terminal, execute:
```bash
git init
git add .
git commit -m "Initial commit: Student Result Management System with CI workflow"
```

### Step 2: Create a New GitHub Repository
1. Go to [GitHub](https://github.com) and log in.
2. Click the **"+"** icon in the top right and select **New repository**.
3. Name your repository: `StudentResultManagement-CI`
4. Leave it Public or Private, and **DO NOT** initialize with a README, `.gitignore`, or license (since we already created them).
5. Click **Create repository**.

### Step 3: Link Local Repository and Push
Copy the commands shown on GitHub and replace `YOUR_GITHUB_USERNAME` and `YOUR_REPOSITORY_NAME`:
```bash
git branch -M main
git remote add origin https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPOSITORY_NAME.git
git push -u origin main
```

---

## 13. Verifying Workflow on GitHub Actions Tab

1. Open your repository page on GitHub (`https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPOSITORY_NAME`).
2. Click on the **Actions** tab at the top of the repository.
3. You will see the **Java CI** workflow run triggered by your latest push.
4. Click on the run to view real-time logs for each step (**Checkout**, **Set up Java**, **Build and Test with Maven**).
5. A green checkmark (`✔`) indicates that all compilation and unit tests passed successfully.

---

## 14. List of Required Screenshots for Assignment Report

Take the following screenshots on your system to include in your final PDF assignment submission:

1. **Local Terminal - Project Directory:** Showing the project folder structure.
2. **Local Terminal - Maven Clean Test Success:** Showing `mvn clean test` execution output with `BUILD SUCCESS`.
3. **Local Terminal - Maven Clean Verify Success:** Showing `mvn clean verify` output.
4. **GitHub Repository Overview:** Displaying root project files (`pom.xml`, `.github`, `src`, `README.md`).
5. **GitHub Actions Tab:** Showing the workflow run list with a green checkmark next to the latest commit.
6. **GitHub Actions Workflow Execution Logs:** Detailed log page showing step-by-step execution of `mvn --batch-mode clean verify`.
7. **Failed CI Run Demonstration (Optional/Bonus):** Screenshot showing a red failed build badge after intentionally introducing a failing test.

---

## 15. Short-Answer Questions & Answers for Report

### Q1: What is Continuous Integration?
**Answer:** Continuous Integration (CI) is a DevOps software development practice where developers frequently merge code changes into a central repository. Each merge automatically triggers automated builds and unit testing pipelines. CI helps detect bugs early, improves code quality, and reduces integration issues during software deployment.

### Q2: What is the purpose of `pom.xml` in a Maven project?
**Answer:** `pom.xml` (Project Object Model) is the central configuration file of an Apache Maven project. It defines project metadata (groupId, artifactId, version), dependencies (e.g., JUnit 5), compiler settings (Java version), build plugins (compiler, surefire plugins), and build lifecycle goals.

### Q3: Why is a YAML workflow file required for GitHub Actions?
**Answer:** GitHub Actions uses YAML (`.yml`) files to define automated CI/CD workflows declaratively. The YAML file specifies event triggers (e.g., `push`, `pull_request`), virtual runner environments (`ubuntu-latest`), environment variables, and sequential execution steps/commands required to build and test the software.

### Q4: What is the purpose of a GitHub Actions runner?
**Answer:** A GitHub Actions runner is a hosted or self-hosted server application that executes jobs defined in a GitHub Actions workflow. It provisions a clean virtual machine environment (e.g., Ubuntu, Windows, macOS), downloads code, installs tools/SDKs, runs commands, and reports logs back to GitHub.

### Q5: What happens when an automated test fails inside the CI pipeline?
**Answer:** When an automated test fails inside a CI pipeline, the Maven build exits with a non-zero error code. GitHub Actions detects the error, immediately stops execution of dependent steps, marks the workflow status as **Failed** (red cross `✖`), and notifies the developer via email or GitHub UI. The bad code is blocked from being safely merged until fixed.

### Q6: Differentiate between `pom.xml` and the GitHub Actions YAML workflow.
**Answer:** 
- **`pom.xml`**: Manages local build configuration, dependencies, Java compiler settings, and project lifecycles within Apache Maven.
- **GitHub Actions YAML (`ci.yml`)**: Manages continuous integration workflow automation on GitHub, defining triggers, virtual machines, environment setups, and calling tools like Maven (`mvn clean verify`) automatically in the cloud.

### Q7: Explain the complete flow of the CI pipeline from a code change to the final CI result.
**Answer:** 
1. A developer makes code changes locally and pushes them to GitHub (`git push`).
2. GitHub detects the push event and triggers the workflow configured in `.github/workflows/ci.yml`.
3. GitHub Actions provisions an `ubuntu-latest` runner virtual environment.
4. The workflow checks out the repository code using `actions/checkout`.
5. Java 17 and Maven dependencies are restored using `actions/setup-java`.
6. Maven executes `mvn --batch-mode clean verify` to compile code and run JUnit tests.
7. Results are reported on the GitHub Actions tab (Green check `✔` for success, Red cross `✖` for failure).

### Q8: Why is automated testing important in a CI pipeline?
**Answer:** Automated testing ensures fast, consistent, and objective code verification without requiring manual human effort. It acts as a safety gate to catch regression bugs, invalid inputs, and logic errors before code enters production, allowing teams to deliver software rapidly and reliably.

---
*Created for Cloud DevOps Assignment — Unit III.*
