# RotbeYar 🚀

[![Kotlin](https://img.shields.io/badge/Kotlin-Modern-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Architecture](https://img.shields.io/badge/Architecture-Clean%20%7C%20MVVM-success.svg)](#)

*Insert your App Screenshot or GIF here*
`![App Preview](link_to_screenshot)`

## 📌 Overview
RotbeYar is an Android application built to demonstrate scalable architecture principles and modular project structure. The project focuses on clean separation of concerns, maintainability, testability, and structured feature implementation.

This repository serves as a **Showcase Project** for potential employers and developers, reflecting strong engineering decisions, modern Android development practices, and clean code principles.

## 🛠 Tech Stack
- **Language:** Kotlin
- **Architecture:** Clean Architecture + MVVM
- **Asynchrony & State:** Coroutines, StateFlow / Flow
- **Dependency Injection:** [Hilt / Koin - *یکی را انتخاب کنید*]
- **Network / Backend:** Firebase Realtime Database
- **Testing:** JUnit, MockK (Domain layer testing)

## 🏗 Architecture Overview
The app follows a strict layered architecture to enforce separation of concerns:

### 🖥 Presentation Layer (`presentation/`)
- Contains ViewModels, UI State (StateFlow), and UI components.
- Completely isolated from data sources. Interacts only with the Domain layer.

### 🧠 Domain Layer (`domain/`)
- The core of the application. Contains **Use Cases** (e.g., `LoginUseCase`, `SendMessageUseCase`) and business models.
- **Pure Kotlin:** No Android framework or Firebase SDK dependencies here. 100% unit-testable.

### 💾 Data Layer (`data/`)
- Implements the repository interfaces defined in the Domain layer.
- Handles Firebase integration and DTO mapping.
- All external SDKs (like Firebase) are quarantined here to prevent vendor lock-in.

## 🔥 Firebase Integration (Proof of Concept)
The project includes a real-time chat module to demonstrate how to integrate external services cleanly:
`Presentation → ViewModel → UseCase → Repository Interface → Firebase Data Source`
The UI never touches Firebase directly, ensuring the architecture remains highly decoupled.

## 🚀 How to Run
1. Clone this repository.
2. Create a new Firebase project and enable Realtime Database & Authentication.
3. Download the `google-services.json` file and place it in the `app/` directory.
4. Sync Gradle and run the project in Android Studio.

## 🗺 Roadmap (What's Next?)
- [ ] Offline Caching (Room Database)
- [ ] Feature-based modularization (Multi-module architecture)
- [ ] CI/CD Pipeline setup (GitHub Actions)
- [ ] UI/Integration Testing (Espresso / Compose Testing)
