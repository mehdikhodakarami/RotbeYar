# RotbeYar

## 📌 Overview | مروری بر پروژه
**English:**  
RotbeYar is an Android application built to demonstrate scalable architecture principles and modular project structure.  
The project focuses on clean separation of concerns, maintainability, and structured feature implementation.

**فارسی:**  
RotbeYar یک اپلیکیشن اندروید است که برای نمایش اصول معماری قابل توسعه و ساختار ماژولار طراحی شده است.  
این پروژه بر جداسازی واضح لایه‌ها، نگهداری آسان و پیاده‌سازی ساختارمند ویژگی‌ها تمرکز دارد.

---

## 🎯 Purpose | هدف پروژه
**English:**  
This repository serves as an architecture showcase project rather than a fully completed production application.  
It is designed to demonstrate how features are structured, organized, and implemented in a scalable Android project.

**فارسی:**  
این مخزن به عنوان یک پروژه نمایشی معماری عمل می‌کند و هدف آن یک اپلیکیشن تولیدی کامل نیست.  
هدف آن نمایش چگونگی ساختاردهی، سازماندهی و پیاده‌سازی ویژگی‌ها در یک پروژه اندروید قابل توسعه است.

---

## 🏗 Architecture Overview | نمای کلی معماری
**English:**  
RotbeYar follows a layered architecture approach inspired by Clean Architecture principles.  
The project is structured to enforce separation of concerns and improve scalability and maintainability.

**فارسی:**  
RotbeYar از یک رویکرد معماری لایه‌ای پیروی می‌کند که از اصول Clean Architecture الهام گرفته شده است.  
پروژه به گونه‌ای طراحی شده که جداسازی مسئولیت‌ها و مقیاس‌پذیری و نگهداری آسان را تضمین کند.

### 🖥 Presentation Layer (presentation/) | لایه ارائه
**English:**  
Responsible for UI and user interaction.  

Contains:  
- Activities / Fragments  
- ViewModels  
- UI state handling  
- User input validation  
- Navigation logic  

This layer depends only on the Domain layer and does not directly communicate with the Data layer.

**فارسی:**  
مسئول نمایش رابط کاربری و تعامل با کاربر است.  

شامل:  
- اکتیویتی‌ها / فرگمنت‌ها  
- ViewModelها  
- مدیریت وضعیت UI  
- اعتبارسنجی ورودی‌های کاربر  
- منطق ناوبری  

این لایه تنها به لایه Domain وابسته است و مستقیماً با لایه Data ارتباط ندارد.

---

### 🧠 Domain Layer (domain/) | لایه دامنه
**English:**  
Responsible for business logic and core application rules.  

Contains:  
- **Use Cases** (each feature has its own use case class)  
- Core business models  
- Interfaces for repositories  

**Example of Use Case usage:**  
- `LoginUseCase` handles user login logic independently of UI and data source.  
- `FetchUserProfileUseCase` retrieves user data via domain interfaces.  

This layer is completely independent from Android framework classes, ensuring testability and clear separation from presentation and data layers.

**فارسی:**  
مسئول منطق کسب‌وکار و قوانین اصلی اپلیکیشن است.  

شامل:  
- **Use Caseها** (هر ویژگی کلاس Use Case مخصوص به خود را دارد)  
- مدل‌های اصلی کسب‌وکار  
- اینترفیس‌های مخزن داده (Repository)  

**مثال استفاده از Use Case:**  
- `LoginUseCase` منطق ورود کاربر را مستقل از UI و منابع داده مدیریت می‌کند.  
- `FetchUserProfileUseCase` اطلاعات کاربر را از طریق اینترفیس‌های دامنه بازیابی می‌کند.  

این لایه کاملاً مستقل از کلاس‌های فریم‌ورک اندروید است و قابلیت تست و جداسازی واضح از Presentation و Data را تضمین می‌کند.

---

### 💾 Data Layer (data/) | لایه داده
**English:**  
Responsible for data management and implementation details.  

Contains:  
- Repository implementations  
- Data sources (local / remote / mock)  
- Data models  
- Mapping logic  

This layer implements interfaces defined in the Domain layer.

**فارسی:**  
مسئول مدیریت داده و جزئیات پیاده‌سازی است.  

شامل:  
- پیاده‌سازی Repository  
- منابع داده (محلی / شبکه / شبیه‌سازی)  
- مدل‌های داده  
- منطق نگاشت داده‌ها  

این لایه اینترفیس‌های تعریف شده در لایه Domain را پیاده‌سازی می‌کند.

---

### 🧩 Dependency Injection (di/) | تزریق وابستگی
**English:**  
Responsible for dependency management.  

Contains:  
- Modules for providing dependencies  
- Repository bindings  
- Application-level dependency configuration  

This ensures loose coupling and better testability.

**فارسی:**  
مسئول مدیریت وابستگی‌ها است.  

شامل:  
- ماژول‌های ارائه وابستگی  
- اتصال Repository  
- پیکربندی وابستگی در سطح اپلیکیشن  

این امر باعث ایجاد Coupling کمتر و قابلیت تست بهتر می‌شود.

---

### 🛠 Utilities (utils/) | ابزارهای کمکی
**English:**  
Contains reusable helper classes and utility functions used across the project.

**فارسی:**  
شامل کلاس‌ها و توابع کمکی قابل استفاده مجدد در کل پروژه است.

---

## 🧩 Implemented Features | ویژگی‌های پیاده‌سازی شده
**English:**  
- Login Screen with input validation  
- Domain Use Cases for login and user profile  
- Repository pattern for data handling  
- Dependency Injection (DI) setup  
- Utilities for reusable functions

**فارسی:**  
- صفحه ورود با اعتبارسنجی ورودی  
- Use Caseهای دامنه برای ورود و پروفایل کاربر  
- پیاده‌سازی الگوی Repository برای مدیریت داده  
- راه‌اندازی Dependency Injection  
- ابزارهای کمکی قابل استفاده مجدد

---

## 🧠 Engineering Decisions | تصمیمات مهندسی
**English:**  
- **Clean Architecture:** Ensures separation of concerns and testability  
- **MVVM Pattern:** Provides clear separation between UI and business logic  
- **Use Cases:** Encapsulate business rules independent of UI and data sources  
- **Repository Pattern:** Provides abstraction over data sources  
- **Dependency Injection:** Decouples components and enables easy testing

**فارسی:**  
- **Clean Architecture:** جداسازی مسئولیت‌ها و قابلیت تست را تضمین می‌کند  
- **MVVM Pattern:** جداسازی واضح بین UI و منطق کسب‌وکار را فراهم می‌کند  
- **Use Cases:** قوانین کسب‌وکار را مستقل از UI و منابع داده پیاده‌سازی می‌کند  
- **Repository Pattern:** انتزاع روی منابع داده فراهم می‌کند  
- **Dependency Injection:** اجزا را از هم جدا کرده و قابلیت تست آسان را می‌دهد

---

## 🚀 Roadmap (Planned Features) | نقشه راه (ویژگی‌های برنامه‌ریزی شده)
**English:**  
- Registration Module  
- Token-based Authentication  
- API Integration  
- Offline Caching  
- Unit & Integration Testing  
- Continuous Integration / Deployment

**فارسی:**  
- ماژول ثبت نام  
- احراز هویت با توکن  
- اتصال به API  
- کش آفلاین  
- تست واحد و تست یکپارچه  
- پیاده‌سازی CI/CD (ادغام و انتشار خودکار)

---
