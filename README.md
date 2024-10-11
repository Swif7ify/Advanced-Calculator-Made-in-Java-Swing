# 🧮 Advanced Calculator

<h2 align="center">Made in Java Swing</h2>

<p align="center">
  <strong>Welcome to an advanced calculator built by TeamBa.</strong><br>
  This project offers a wide range of mathematical functions, from basic arithmetic operations to complex notations and summations. The calculator is designed for infinite calculations with robust handling of various mathematical functions.
</p>

<div align="center"> 
  <img src="https://github.com/user-attachments/assets/8f64d096-38bc-4391-91a7-443ef909ab9f" style="width: 50%; height: 50%;">
</div>

---

>[!NOTE]
>Updated: Fixed Bugs **`10-11-2024 3:50PM`**

---
## ✨ Features
This calculator supports a comprehensive set of features, including but not limited to:

- **Basic Operations**: Addition, subtraction, multiplication, division.
- **Advanced Arithmetic**: Mixed operations, integer and floating-point calculations.
- **Mathematical Functions**:
  - Plus/Minus function
  - Floor, ceiling, and rounding calculations
  - Modulus and integer division
  - Factorial, square root, cube root, and nth root functions
  - Summation and product notation functions
  - Exponential calculations (X^Y, X^Y^Z)
  - Double summation and product notation
  - Logarithmic functions (logx, log(2)x, log(n)x)
  - Complex functions: a! + b! / a! / b!
  - ABCD variables for summation/product notation
  - Operations with ANS button
  - Custom number format button for precise outputs

---

## 📚 How to Use
Watch the video tutorial below for step-by-step guidance on using the calculator's features.

[![How to Use Video](https://github.com/user-attachments/assets/8ee6f6dc-9a17-4af4-b9b0-7447520764c5)](https://github.com/user-attachments/assets/8ee6f6dc-9a17-4af4-b9b0-7447520764c5)

---

## ⚙️ How to Run
Follow the steps below to run the calculator from your command line:

1. Download or clone the repository
2. Open the folder.
3. In the folder's address bar, type `cmd` to open the command prompt.
   <div style="text-align: center;">
     <img src="https://github.com/user-attachments/assets/61bd6f26-30da-480e-bd52-c3020d10b512" style="width: 50%; height: auto;">
   </div>
   
4. Navigate to the source directory by typing in cmd:
   ```bash
   cd Project/src
5. In cmd type
   ```bash
   javac calculator/Main.java
6. Lastly type
   ```bash
   java calculator/Main.java
<br>

---

## 💡 Creating a JAR File
1. Download or clone the repository.
2. Navigate to the `Project` folder and create a `MANIFEST.MF` file:
<br>


![Manifest](https://github.com/user-attachments/assets/87b57fac-d02a-4823-9344-2a7335ab4aaa)
![Manifest](https://github.com/user-attachments/assets/01425f62-3b20-4018-9d1d-757307ad964c)

<br>

4. Edit `MANIFEST.MF`
   - Put `Manifest-Version: 1.0` and `Main-Class: calculator.Main` as shown in the image below
![Manifest](https://github.com/user-attachments/assets/c302866a-5b09-4e70-a76a-223f6f06dcc8)
<br>

5. Open `cmd` in the address bar
6. In cmd type
   ```bash
   jar cvfm Calculator.jar MANIFEST.MF src .
7. Open the `.jar` file with .zip
8. Navigate to `META-INF`
<div style="display: flex; justify-content: center; width: 100%">
  <img src="https://github.com/user-attachments/assets/e2c029a1-3bb9-4afe-86a3-fc92d57a0f69" style="width: 50%; height: 50%;">
</div>
<br>

10. Click the `MANIFEST.MF` and make sure the `Main-Class: calculator.Main` is inside
![Manifest](https://github.com/user-attachments/assets/2af5d82c-799c-4538-b0dd-963a90ad561f)
<br>


> OPTIONAL: Cut and paste the Jar file to any directory to separate the file.
<br>

---


## 🛠 Creating a Batch File
1. Create a `.bat` file in the folder.
![Batch Creation](https://github.com/user-attachments/assets/807e555d-c08c-4b5d-9427-bbdbf7d44355)
2. Edit the `.bat` file using Notepad or another text editor.
<div style="display: flex; justify-content: center; width: 100%">
  <img src="https://github.com/user-attachments/assets/87927964-4a6b-4ac6-909d-3ca750bb541e" style="width: 50%; height: 50%;">
</div>
<br>


- Run the `.bat` file and Enjoy
