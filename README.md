# Swag Labs Automation Script  

This project is a Selenium-based automation test for the [Swag Labs](https://www.saucedemo.com/) website.  
It performs the following actions:  

1. Navigate and log in with valid credentials.  
2. Verify successful login by checking the "Products" page header.  
3. Add "Sauce Labs Backpack" and "Sauce Labs Fleece Jacket" to the cart.  
4. Navigate to the cart page and verify both products are present.  

---

## 📂 Project Structure  

```
SwagLabsAutomation/

├── src/main/java/main/SwagLabs.java    # **Main automation script**

├── README.md                           # **Project setup & instructions**

├── TestResults.txt                     # **Console output from a test run**

└── Automation_Demo.mp4                 # **Screen recording of test execution**

```


## ⚙️ Prerequisites  

- **Java JDK 8+**  
- **Eclipse IDE / IntelliJ IDEA**  
- **Selenium WebDriver (Java)**  
- **Chrome Browser** installed  
- **ChromeDriver** (make sure its version matches your Chrome browser version)  

---

## 🚀 How to Run the Test  

1. Clone the repository:  
   ```bash
   git clone https://github.com/11-abhishek-kankarwal/AutomationProjects.git

   # SwagLabs Automation Setup & Execution Guide

This guide will walk you through the steps to set up and run the SwagLabs automation project.

---

## 1. Open the Project in an IDE

1.  Open the `SwagLabsAutomation` project in your preferred IDE, such as **Eclipse** or **IntelliJ**.

---

## 2. Add Selenium Dependencies

To run the automation script, you need to add the necessary Selenium libraries to your project.


---

## 3. Run the Project Manually

Once the project is configured, you can run the automation script.

1.  Navigate to the `/STEAssignment2/src/main/java/main` directory.
2.  Open the `SwagLabs.java` file.
3.  Right-click on the file and select **Run As** -> **Java Application**.

The script should now execute, opening a Chrome browser and performing the automated steps on the SwagLabs website.

## 🧪 Test Results

Sample console output from a successful run is saved in `TestResults.txt`.

---

## 🎥 Demo Video

A screen recording of the test execution is included in `Automation_Demo.mp4`.
