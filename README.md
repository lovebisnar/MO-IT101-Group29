MotorPH Payroll System

## System Overview
The **MotorPH Payroll System (Phase 1)** is a console-based Java application designed for MotorPH, a motorcycle parts manufacturing and retail company. This system provides foundational payroll functionality for regular employees, including access to personal information, and payslip viewing.

The system includes core payroll computation algorithms for:
Gross Salary Calculation: hours × hourly rate
PhilHealth Premium: 50% of contribution below 
₱300 minimum for salaries ≤ ₱10,000
₱1,800 maximum for salaries ≥ ₱60,000
SSS: Based on official SSS contribution table
Salary-based tiered contribution (₱135 – ₱1,125)
Computed according to defined compensation ranges
Pag-IBIG Contribution: (₱100 maximum contribution)
1% for salaries ₱1,000 – ₱1,500
2% for salaries above ₱1,500
Withholding Tax Deduction: Progressive BIR tax brackets (0% to 35%)

This Phase 1 implementation serves as the foundation for future enhancements including CSV data integration, role-based access (Employee/Payroll Staff), and full payroll processing.

## Features
**Employee Dashboard**: Access personal information
**Salary Computation**: Calculates gross salary and net pay per cutoff based on hours worked and hourly rate (1st and 2nd cutoff), including government deductions (SSS, PhilHealth, Pag-IBIG) and tax 
**PhilHealth Calculator**: Government-mandated health insurance premium computation
**SSS Calculator**: Salary-based contribution using official SSS table
**Pag-IBIG Calculator**: Contribution based on salary bracket with ₱100 cap
**Withholding Tax Calculator**: BIR withholding tax computation using progressive tax brackets
**Console-based Interface**: Simple menu-driven navigation

## Tech Stack
| **Component** | **Details** |
| -------- | -------- |
| Language  | Java  |
| Runtime  | Java (compatible with Java 8+)  |
| Libraries  | Standard Java libraries only  |
| Data Storage  | Console input  |

## Usage Instructions
### Prerequisites
- Java Development Kit (JDK 8 or higher)
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or command-line compiler
### Installation
1. Clone the repository
2. Open the project in your preferred IDE
3. Make sure the CSV files are in the project root directory
4. Run 

## Login Credentials
| **Role** | **Username** | **Password** |
| -------- | -------- | -------- |
| Employee  | ```employee```  | ```12345``` |



## Project Structure  

```
└── MotorPH-Payroll-System/  
    ├── src/  
    │   ├── MotorPHPayrollSystem.java
    │   ├── MotorPH_Attendance.csv
    │   └── MotorPH_EmployeeData.csv
    ├── target/
    │   ├── system/
    │   │   └── MotorPHPayrollSystem.class
    │   └── compile/
    │       ├── createdFiles.lst
    │       └── inputFiles.lst
    ├── README.md
    └── pom.xml
```

## System Workflow
### System Start
The MotorPH Basic Payroll System begins when the user runs the console-based Java application. The system initializes the program and prepares the available payroll features for user interaction.

### User Login
The system prompts the user to enter the required login credentials, which Include the username and password. Once the credentials are verified, the user is granted access to the system.

### Access to System Features
After successful login, the user can navigate through system features based on their assigned role:

Employee:
Allows users to view their personal information (e.g., employee number, name, birthdate) and payroll details.

Payroll Staff:
Allows users to access employee records and perform payroll processing for a single employee or all employees.

### Data Processing and Display
When a feature is selected, the system retrieves and processes the necessary data. The system either displays the requested payroll information or personal information.

### Payroll Computation
When payroll-related information is requested, the system calculates the employee’s gross salary based on the total work hours logged and the employee’s hourly rate. After determining the gross salary, the system applies the required payroll deductions.

The system calculates all mandatory government contributions based on the employee’s salary, including SSS (tiered contribution), PhilHealth (with minimum and maximum limits), and Pag-IBIG (percentage-based with a contribution cap). It also computes the applicable income tax using the defined BIR tax brackets. All deductions are then applied to determine the employee’s net pay.

### Program Exit
After completing the necessary tasks, the user can exit the system. The application then safely terminates the program session.

## Core Methods
| **Method** | **Purpose** |
| -------- | -------- |
| displayGreeting()  | Shows welcome message and login prompt  |
| displayMainMenu()  | Displays employee main menu options  |

## Project Plan
[Project Plan Link](https://docs.google.com/spreadsheets/d/1jK__me-qO7xH--ufDoRR6xMBYdU7Y4Qza7kn4BsNws4/edit?usp=sharing)

## Team Details
**Annie Love Bisnar**
Served as the main code contributor for the project. Responsible for developing the project plan and implementing the core program code. Also managed the GitHub repository, organized the project structure, and ensured that all team contributions were properly integrated into the system.

**Allyana Nicole Alfante**
Made final changes to the main code for the project. Developed the use case diagram to illustrate how users interact with the MotorPH Payroll System and its main functionalities. Also contributed to the preparation and writing of the README file to clearly document the project overview, system details, and repository information.

**Andrea Victoria Magallanes**
Served as the primary repository owner. Designed the system wireframes to visually represent the layout and user flow of the MotorPH Payroll System. Assisted in preparing parts of the README documentation to ensure the system design and structure were clearly communicated.

**Joshua Serrano**
Prepared the effort estimate for the project by identifying the required tasks and estimating the time and resources needed for each development activity. This helped guide the planning and workload distribution for the team during Phase 1.

**Ronie Lyn Arellano**
Compiled and documented the MotorPH system requirements, ensuring that the features and functionality of the system align with the provided specifications and project scope for the payroll system.

## Academic Submission Statement
**Course** | Computer Programming 1 (MO-IT101)
**Professor** | Sir Aldrin John Tamayo
**Section** | H1101
**Group** | 29

This submission fulfilled the Phase 1 milestone requirements for the MotorPH Payroll System. The repository contains the full source code implementation, system architecture, and comprehensive technical documentation, built according to the approved project plan and other Phase 1 deliverables outlined in the Project Plan Sheet.



