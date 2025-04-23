# 🆔 South African ID Validator

A Java application for validating South African ID numbers. Includes both a Command-Line Interface (CLI) and a Java Swing Graphical User Interface (GUI).

---

## 🛠️ Technologies Used
- ![Java](https://img.shields.io/badge/Java-21-blue?logo=java) **Java 21** (core application logic and GUI)
- ![Swing](https://img.shields.io/badge/Swing-GUI-orange?logo=java) **Java Swing** (for the graphical user interface)
- ![JUnit](https://img.shields.io/badge/JUnit-5-green?logo=JUnit5) **JUnit 5** (for unit testing)
- ![Gradle](https://img.shields.io/badge/Gradle-Build-black?logo=gradle) **Gradle** (build and dependency management)
- ![Guava](https://img.shields.io/badge/Guava-Google-green?logo=google) **Guava** (Google core libraries for Java)

---

## ✨ Features
- Validate South African ID numbers for correctness
- Java Swing GUI for easy user interaction
- Command-Line Interface for automation or scripting
- JUnit tests for validation logic

---

## 📋 Prerequisites
- Java 21 (ensure `JAVA_HOME` is set to your Java 21 installation)
- [Gradle](https://gradle.org/) (wrapper included)
- Windows OS (tested)

---

## 🚀 Getting Started

### 1. Clone the Repository
Clone the repository using the following command:
```sh
git clone <https://github.com/CodeWithRonnie/ID-VALIDATION.git>
```
Replace `<repo-url>` with your project's repository URL.

### 2. Build the Project

cd app
# Build using Gradle
gradle build
```

---

## 🖥️ Running the Application

### Run the GUI (Recommended)
This opens a window where you can type and validate SA ID numbers.
```sh
java -cp build/classes/java/main org.example.ValidateSaIdGUI
```
- Make sure to run from Command Prompt or standalone PowerShell (not VS Code terminal) for proper input.

### Run the CLI
You can also validate an ID number from the command line:

java -cp build/classes/java/main org.example.ValidateSaIdCLI 8001015009087
```

---

## 🧪 Running Tests

### To run all tests:

cd app
gradle test
```

### To clean and run tests:
cd app
gradle clean test
```

Test results will be shown in the terminal and detailed reports can be found in:
- `app/build/reports/tests/test/index.html`

---

## 🐞 Troubleshooting
- **Cannot type in the GUI?** Run from Command Prompt, not the VS Code terminal.
- **Java errors?** Ensure you are using Java 21.
- **Build errors?** Make sure you are in the `app` directory when running Gradle commands.

---

## 📁 Project Structure
```text
validate_sa_id/
├── app/
│   ├── build.gradle
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── org/
│   │   │           └── example/
│   │   │               ├── ValidateSaIdGUI.java    # Main GUI code
│   │   │               ├── ValidateSaIdCLI.java    # Command-line interface
│   │   │               ├── ValidateSaId.java       # ID validation logic
│   │   └── test/
│   │       └── java/
│   │           └── org/
│   │               └── example/
│   │                   └── ValidateSaIdTest.java   # JUnit tests
├── README.md
```

---

## 👤 Author
MAMIKIE MAEMU(CodeWithRonnie)