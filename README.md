# 🧪 Churchfield Home Services Automation Testing (Selenium Java - POM)

## 📌 Project Overview

This project automates the complete **Home Energy Assessment Booking Flow** for Churchfield Home Services using **Selenium WebDriver with Java**.

The framework is built using the **Page Object Model (POM)** design pattern to ensure scalability, maintainability, and reusable test components.

## 🎥 Automation Demo

https://github.com/user-attachments/assets/fcb1f396-9b70-44fb-aaaa-b2ec41b24480


The automation covers the full end-to-end user journey including:

* Navigation flow
* Form handling
* File upload
* Dynamic date & time selection
* Popup handling
* Email validation

---

## 🚀 Key Features

* ✅ End-to-end automation testing
* ✅ Page Object Model (POM) architecture
* ✅ Dynamic waits using WebDriverWait
* ✅ JavaScript Executor handling
* ✅ Scroll handling for hidden elements
* ✅ File upload automation
* ✅ Dynamic calendar date selection
* ✅ Next month conditional handling
* ✅ Time slot selection (Morning / Afternoon)
* ✅ Popup handling & validation
* ✅ Email assertion validation
* ✅ Exception handling for unstable UI elements

---

## 🛠️ Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* ChromeDriver

---

## 📂 Project Structure

```bash
src
 ├── main
 │    └── java
 │         ├── pages        # Page Object classes
 │         ├── base         # WebDriver setup
 │
 └── test
      └── java
           └── tests        # Test classes
```

---

## ✅ Automated Test Scenario

### 🔹 Navigation Flow

1. Open website
2. Click:

   * Our Services
   * Home Energy Assessment
   * Book your Home Energy Assessment

### 🔹 Property Information

3. Select:

   * House Type = Semi-Detached
   * No. of Storeys = 2
   * Existing extension = Yes
   * Plans to add extensions = No

### 🔹 Upload Section

4. Uncheck:

   * "I don't have a photo to hand"
5. Upload property image
6. Click Next

### 🔹 Validation

7. Assert:

   * "Your first step to a warm, comfortable, and healthy home"

### 🔹 Form Handling

8. Close popup if displayed

9. Fill:

   * First Name
   * Last Name
   * Email
   * Mobile Number

10. Type "Dublin" in property address field and select an address

11. Click Next

### 🔹 Schedule Logic

12. Check available dates in current month
13. If unavailable:

* Move to next month
* Select available date

14. Select available time slot:

* Morning
* Afternoon
* Then Click Next Button

15. Click Later

### 🔹 Final Assertion

16. Assert previously entered email address from confirmation popup

---

## ⚡ Challenges Solved

During implementation, several real-world automation challenges were handled successfully:

* Dynamic loading issues
* Hidden elements
* Scroll required elements
* Duplicate locators
* Delayed popup rendering
* Click interception issues
* Dynamic calendar handling
* JavaScript click fallback
* Explicit wait synchronization

These improvements made the framework more stable and reliable.

---

## ▶️ How to Run the Project

### 🔹 Prerequisites

* Java JDK 8+
* Maven
* Google Chrome Browser

### 🔹 Clone Repository

```bash
git clone https://github.com/AbdullahAlFahad9/Churchfield-Home-Services-Automation-Testing-Using-Selenium-Java-.git
```

### 🔹 Navigate to Project

```bash
cd Churchfield-Home-Services-Automation-Testing-Using-Selenium-Java-
```

### 🔹 Run Tests

```bash
mvn clean test
```

---

## 🎥 Automation Demo Video

Watch the full automation execution here:

[![Watch the video](https://img.youtube.com/vi/NXOTZn16d-4/maxresdefault.jpg)](https://youtu.be/NXOTZn16d-4)

🔗 Direct Link: https://youtu.be/NXOTZn16d-4

## 📸 Test Automation Highlights

* Dynamic Wait Handling
* Robust Locator Strategy
* POM Design Pattern
* End-to-End Booking Flow
* Stable UI Interaction
* Assertion Validation

---

## 👨‍💻 Author

### Abdullah Al Fahad

Junior SQA Engineer

🔗 GitHub:
https://github.com/AbdullahAlFahad9
