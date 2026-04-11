# 🧪 Churchfield Home Services Automation (Selenium Java - POM)

## 📌 Project Overview
This project automates the Home Energy Assessment booking flow using Selenium WebDriver with Java. The framework follows the Page Object Model (POM) design pattern for better maintainability and reusability.

---

## 🚀 Features
- End-to-end automation of booking flow  
- Page Object Model (POM) implementation  
- Scroll handling for hidden elements  
- File upload automation  
- Form filling and validation  
- Dynamic date selection  
- Time slot selection  
- Popup handling  
- Assertion of confirmation message  

---

## 🛠️ Tech Stack
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- ChromeDriver  

---

## 📂 Project Structure
src
 ├── main
 │    └── java
 │         ├── pages        # Page classes (POM)
 │         ├── base         # Base setup (WebDriver)
 │
 └── test
      └── java
           └── tests        # Test classes


---

## ✅ Test Scenario
1. Open website  
2. Navigate to Home Energy Assessment  
3. Select:
   - Semi-Detached  
   - 2 Storeys  
   - Yes / No options  
4. Upload image  
5. Click Next  
6. Verify text  
7. Fill form  
8. Select Dublin address  
9. Choose available date & time  
10. Verify email  

---

## ▶️ Run Project
Prerequisites
Java JDK 8+
Maven installed
Chrome browser

Steps
git clone https://github.com/AbdullahAlFahad9/Churchfield-Home-Services-Automation-Testing-Using-Selenium-Java-.git
cd Churchfield-Home-Services-Automation-Testing-Using-Selenium-Java-
mvn clean test

---

## 👨‍💻 Author
Abdullah Al Ahad  
Junior SQA Engineer