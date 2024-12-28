# 🚀 Automation Project Using JUnit and Selenium

This project automates web forms and data scraping tasks using **JUnit**, **Selenium WebDriver**, and other tools. The project includes three tasks:

1. 📝 Automate the webform submission for Digital Unites.
2. 🧑‍💻 Automate the user registration form.
3. 📊 Scrape data from the Dhaka Stock Exchange website.

### 📂 Project Structure

- `src/test/java` : Contains all test classes for the automation tasks.
- `src/test/resources` : Stores test data, such as text files, images, etc.
- `test-results/screenshots` : Stores screenshots taken during the test execution.

## 🛠️ Tasks

### #1. Automate the Digital Unites Webform
- **Webform URL**: [Digital Unites Practice Webform](https://www.digitalunite.com/practice-webform-learners)
  
#### 📝 Steps for Automation:
1. Input all fields in the form.
2. Upload a file (max 2MB).
3. Click on the **Submit** button.
4. After successful submission, assert that the page displays the message: "Thank you for your submission!"

#### 📸 Screenshots:
- Screenshot of the Report of the Digital Unites Webform

![DigitalUnite](https://github.com/user-attachments/assets/e1c6c6a7-186f-4d53-8ae1-86f4c3f3227f)

---

### #2. Automate the User Registration Webform
- **Webform URL**: [User Registration Form](https://demo.wpeverest.com/user-registration/guest-registration-form/)
  
#### 📝 Steps for Automation:
1. Input the following fields:
   - Firstname
   - Lastname
   - UserEmail
   - Gender
   - Date of Birth
   - Nationality
   - Phone Number
   - Country (Bangladesh)
   - Terms & Conditions
2. Click the **Submit** button.
3. Assert that the registration is successful.

#### 📸 Screenshots:
- Screenshot of the Report of user registration form.

![UserRegistration](https://github.com/user-attachments/assets/e6bab85e-dc71-466f-9a80-ffe115fee017)

---

### #3. Scrape the Table Data from the Dhaka Stock Exchange Website
- **Webpage URL**: [Dhaka Stock Exchange Share Prices](https://dsebd.org/latest_share_price_scroll_by_value.php)
  
#### 📝 Steps for Automation:
1. Scrape all the cell values from the table.
2. Store the scraped data in a text file.

#### 📸 Screenshots:

1. **Screenshot of the Report**  
   ![DhakaStockExchange](https://github.com/user-attachments/assets/b9e7c4c3-3dd5-4ef6-829d-b82107524295)

2. **Screenshot of the Scraped Table Data**  
   ![DSE](https://github.com/user-attachments/assets/26fd00b6-5ff1-45dc-8ece-edee3571766d)

---


## ⚙️ Prerequisites

Before running the tests, ensure you have the following installed:

1. **Java**: Version 8 or higher ☕
2. **Maven**: For building and running the project 🧑‍💻
3. **Selenium WebDriver**: For browser automation 🧳
4. **ChromeDriver**: Ensure the version of ChromeDriver matches your browser version 🔧

## 🏃‍♂️ Running the Tests

To run the tests:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/automation-project.git
