/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.motorph.payroll.system;
//import static com.mycompany.motorph.payroll.system.MotorPHPayrollSystem.MotorPHPayrollSystem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * 
 *
 * @author annielovebisnar
 */
public class MotorPHPayrollSystem {
    
    //Display Greetings
    public static void displayGreeting() {
        System.out.print("Welcome to Motor PH Payroll System\n");
        System.out.print("\nKindly Login\n");
    }
    //Display Main Menu of Regular Employee
    //Assigned Number will be 1
   
    public static void displayMainMenu() {
        System.out.print("\n1. Personal Information");
        System.out.print("\n2. Log Work Hours");
        System.out.print("\n3. View Payslip");
        System.out.print("\n4. Apply Leave");
    }
    //** Salary Computation
     public static double ComputeOverallSal(double TimeDur, double Hrate) {
        double hours=TimeDur;
        double rate=Hrate;
        
         double SalsOver=hours*rate;
       
        return SalsOver;
    }
    
    //** PhilHealth Calculator
    public static double ComputePhilhealthPremium(double Salary){
        double PHPremimum = Salary*0.025;
        if (Salary<=10000) {
            PHPremimum = 300;
            
        }
        else if (Salary>=60000) {
            PHPremimum=1800;
        }
        return PHPremimum; 
    }
    
    //** Tax Calculator

    /**
     *
     * @param GrossIncome
     * @return
     */
    public static double ComputeTaxDeduction (double GrossIncome) {
        double TaxBaseline=GrossIncome-666667,TaxDeduction=183541.80+(TaxBaseline*0.35);
        if (GrossIncome==0.0) {
             TaxDeduction=0;
        }
        else if (GrossIncome<=23800) {
            TaxDeduction=0;
        }
        else if (GrossIncome>23800 && GrossIncome<=33333) {
            TaxBaseline=GrossIncome-23800;
            TaxDeduction=TaxBaseline*0.15;
        }
        else if (GrossIncome>33333 && GrossIncome<=66667) {
            TaxBaseline=GrossIncome-33333;
            TaxDeduction=1875+(TaxBaseline*0.20);
        }
        else if (GrossIncome>66667 && GrossIncome<=166667) {
            TaxBaseline=GrossIncome-66667;
            TaxDeduction=8541.67+(TaxBaseline*0.25);
        }
        else if (GrossIncome>166667 && GrossIncome<=666667) {
            TaxBaseline=GrossIncome-166667;
            TaxDeduction=33541.8+(TaxBaseline*0.30);
        }
        return TaxDeduction;
    }
    
  //Getting the Time Duration

    /**
     *
     * @param UN
     * @param iy
     * @param Cutoff
     * @return
     * 
     */
    public static double TimeInTimeOut(String UNs,String Cuts) throws FileNotFoundException, IOException {
       //Modified the CSV File, Added the duration and Cut off columns
       // Made the duration if the total hour spent in a day is more than 8 hours then it will be stayed as 8 hours
       // if it is less than 8 hours then it will be retain the duration
       // made the duration into decimal places
     File TITO = new File("/Users/annielovebisnar/MMDC/MO-IT101-Group29/MotorPH-Payroll-System/src/MotorPH Attendance.csv"); // Make sure this is plain text
      String line;
     String csvSplitBy =",";
     String inputId=UNs;
     double totalSum=0.0;
     String Cutoffs=Cuts;
     boolean foundsx = false;
  
     try (BufferedReader TimsCr = new BufferedReader(new FileReader(TITO))){
        TimsCr.readLine();
        while ((line= TimsCr.readLine()) !=null) {
         String[] row=line.split(",");
           if (row.length >= 2 ) {
         // for (String index : row){
          //               System.out.printf("%-10s", index);

          //           }
           //         System.out.println();
          String id = row[0].trim();
        if (id.equals(inputId) ) {
             String duration= row[7].trim();
             String EID=row[0].trim();
             
        if (EID.equalsIgnoreCase(inputId) && row[6].equalsIgnoreCase(Cutoffs)) {
             totalSum += (Double.parseDouble(duration))*24;
         }
        
    }
           }
            
        }
       
     }catch (IOException | NumberFormatException e) {
           e.printStackTrace();
    }
    
     return totalSum;
        
    }
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
       displayGreeting();
       double Salary1 = 0, Salaries, Salary12=0, Salary=0.0;
       String MonthName = null;
       Scanner scanner = new Scanner(System.in);
       double srate=0.0;
       double rate=0.0;
       double PHPremimum;
       double GrossIncome=0.0;
       // double[] storeddur1x = new double[12];
      // double[] storeddure2 = new double[12];
       String Cutoffs = null;
        System.out.print("Employee Code: ");
        String inputId = scanner.nextLine().trim(); // Read input ID
        System.out.print("\nPassword: ");
        int Pass=scanner.nextInt();
         String UN=inputId;
        //LocalTimeCodes();
       
            File file = new File("/Users/annielovebisnar/MMDC/MO-IT101-Group29/MotorPH-Payroll-System/src/MotorPH_EmployeeData-EmployeeDetails.csv"); //file path on the csv. drag and drop is not working
           try (BufferedReader br = new BufferedReader(new FileReader(file))) {
               String line;
               boolean found = false;
               while ((line = br.readLine()) != null) {
                   String[] parts = line.split(","); // Split
                   if (parts.length >= 2 && Pass == 12345) { // Ensure line has ID and name
                       String id = parts[0].trim();
                       // System.out.println("Test");
                        if (id.equals(inputId) )  {
                           //Getting all the information from the csv file
                           String firstName = parts[2].trim();
                           String lastName = parts.length > 1 ? parts[1].trim() : "";
                           String bday = parts[3].trim();
                           String position= parts[11].trim();
                           String salaries=parts[13];
                           String RicSub=parts[14];
                           String PhoneAl=parts[15];
                           String SemiMonR=parts[17];
                           double sal=Double.parseDouble(salaries);
                           String HrRate=parts[18].trim();
                           srate= Double.parseDouble(HrRate);
                           double RiceSubs=Double.parseDouble(RicSub);
                           double PhonAllow=Double.parseDouble(PhoneAl);
                           double SemiMon=Double.parseDouble(SemiMonR);
                           double Allowance=RiceSubs+PhonAllow;
                           
                           System.out.println("\n===================================");
                           System.out.println("Employee ID: " + inputId);
                           System.out.println("Employee Name: " + firstName + " " + lastName);
                           System.out.println("Birthday: " + bday);
                           System.out.println("Position: " + position);
                           System.out.println("Basic Salary: PHP " + sal);
                           System.out.println("Hourly Rate: PHP " + rate);
                           System.out.println("Allowance: PHP " + Allowance);
                           System.out.println("Semi Monthly Salary: PHP " + SemiMon);
                           System.out.println("===================================");
                           for (int ix=1 ; ix<=12; ix++){
                             if (ix==1){
                                 MonthName="Jan";
                             } else  if (ix==2){
                                 MonthName="Feb";
                             }  else  if (ix==3){
                                 MonthName="Mar";
                             } else  if (ix==4){
                                 MonthName="Apr";
                             } else  if (ix==5){
                                 MonthName="May";
                             } else  if (ix==6){
                                 MonthName="Jun";
                             } else  if (ix==7){
                                 MonthName="Jul";
                             } else  if (ix==8){
                                 MonthName="Aug";
                             } else  if (ix==9){
                                 MonthName="Sep";
                             } else  if (ix==10){
                                 MonthName="Oct";
                             } else  if (ix==11){
                                 MonthName="Nov";
                             } else  if (ix==12){
                                 MonthName="Dec";
                             } 
                           String UNs=inputId;
                           String Cuts=MonthName + " 1-15 Cut Off";
                           double Hrate=srate;
                           double PartRating=TimeInTimeOut(UNs,Cuts);
                           double TimeDur=PartRating;
                           String Cuts1=Cuts;
                           Salary1 = ComputeOverallSal(TimeDur,Hrate);
                           Cuts=MonthName + " 16-31 Cut Off";
                          String Cuts2=Cuts;
                           double PartRating2=TimeInTimeOut(UNs,Cuts);
                           TimeDur=PartRating2;
                           Salaries = ComputeOverallSal(TimeDur,Hrate);
                           Salary=Salary1+Salaries;
                           PHPremimum=ComputePhilhealthPremium(Salary);
                           double GrossIncome1=Salary-PHPremimum;
                           if (GrossIncome1<0){
                               GrossIncome=0;
                    
                           } else {
                               GrossIncome=GrossIncome1;
                           }
                           double TaxDeduc=ComputeTaxDeduction(GrossIncome);
                           double NetSalary=Salaries-TaxDeduc;
                           
                             System.out.println("\n===================================");
                           System.out.println("Employee ID: " + inputId);
                           System.out.println("Employee Name: " + firstName + " " + lastName);
                           System.out.println("Payroll Time " + Cuts1);
                           System.out.println("Net Salary: PHP " + String.format("%.2f", Salary1));
                           System.out.println("Payroll Time " + Cuts2);
                           System.out.println("Gross Salary: PHP " + String.format("%.2f", Salaries));
                           System.out.println("Total Month Salary: PHP " + String.format("%.2f", Salary));
                           System.out.println("PhilHealth Deduction: PHP " + String.format("%.2f", PHPremimum));
                           System.out.println("Taxable Income: PHP " + String.format("%.2f", GrossIncome));
                           System.out.println("Tax Deduction: PHP " + String.format("%.2f", TaxDeduc));
                           System.out.println("Net Salary: PHP " + String.format("%.2f", NetSalary));
                           System.out.println("===================================");
                           
                          
                           }
                       found = true;
                       break; // Stop after finding the ID
                   }
                    } else {
                       System.out.println("Wrong Employee ID and Password");
                        break; // Stop after finding the ID
                   }
                     }
               
               if (!found) {
                   System.out.println("No ID Found.");
               }
           }
        
           
             

            catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
            
        scanner.close();
            
     
    }
}


