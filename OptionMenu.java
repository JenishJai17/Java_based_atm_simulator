/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//            for(Entry<Integer,Integer> entry :data.entrySet()){
//                if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber){
//                    getAccountType();
//                }
//            }
 //HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    /*Validate Login Information
    
    */
package com.mycompany.atmproject;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
/**
 * @author JENISH
 */
public class OptionMenu extends Account{
   Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat ("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();
       
    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{
                data.put(9876543, 9876);
                data.put(9876541, 1234);
                System.out.println("Welcome to the ATM project! ");
                System.out.print("Enter Your Customer Number:");
                setCustomerNumber(menuInput.nextInt());
                
                System.out.println("Enter your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            }
            catch(Exception e){
                System.out.println("\n Invalid Character(s). Only Numbers Allowed \n");
                x = 2;
            }
                int cn = getCustomerNumber();
                int pn = getPinNumber();

                if (data.containsKey(cn) && data.get(cn) == pn) {
                    getAccountType();
                } else {
                    System.out.println("\n Wrong Customer Number or Pin Number. ");
                    System.out.println("Would you like to sign up? (1 for Yes, 0 for No): ");
                    int signUpOption = menuInput.nextInt();

                    if (signUpOption == 1) {
                        signUp();
                    }
                }        
        } while( x==1 ); 
    }
    
    /*Display Account Type Menu with Selection
    
 */
    public void signUp() {
    System.out.print("Enter a new Customer Number: ");
    int newCustomerNumber = menuInput.nextInt();

    System.out.print("Enter a new Pin Number: ");
    int newPinNumber = menuInput.nextInt();

    data.put(newCustomerNumber, newPinNumber);

    System.out.println("\n Sign-up successful! Please log in again. \n");
       try {
           getLogin();
       } catch (IOException ex) {
           System.out.println("Sorry Sign up Faced some error, please try again");
       }
}
    public void getAccountType(){
      System.out.println("Select the Account you want to access: ");
      System.out.println("Type 1 - Checking Account");
      System.out.println("Type 2 - Saving Account");
      System.out.println("Type 3 - Exit");
      System.out.print("Choice:");
    
    
    int selection = menuInput.nextInt();
    
    switch(selection){
        case 1:
            getChecking();
            break;
        
        case 2:
            getSaving();
            break;
            
        case 3:
            System.out.println("Thank you for using this ATM, see you next time");
            break;
            
        default:
            System.out.println("\n Invalid Choice \n");
            getAccountType();
    }
    
}


public void getChecking(){
     System.out.println("Checking Account: ");
      System.out.println("Type 1 - View Balance");
      System.out.println("Type 2 - Withdraw Funds");
      System.out.println("Type 3 - Deposit Funds");
      System.out.println("Type 4 - Exit");
      System.out.println("Choice:");
        
      int selection = menuInput.nextInt();
      switch(selection){
          case 1:
              System.out.println("Checking Account Balance:" +moneyFormat.format(getCheckingBalance()));
              getAccountType();
              break;
          
          case 2:
              getCheckingWithdrawInput();
              getAccountType();
              break;
              
          case 3:
              getCheckingDepositInput();
              getAccountType();
              break;
              
          case 4:
              System.out.println("Thank you for using this ATM, bye for now.");
              break;
              
          default:
              System.out.println("\n Invalid Choice \n");
              getChecking();
              
          
      }
}

public void getSaving(){
    System.out.println("Saving Account:");
    System.out.println("Type 1 - View Balance");
    System.out.println("Type 2 - Withdraw Funds");
    System.out.println("Type 3 - Deposit Funds");
    System.out.println(" Type 4 - Exit");
    
    System.out.print("Choice: ");
    
    int selection = menuInput.nextInt();
    
    switch(selection){
        case 1:
            System.out.println("Saving Account Balance:" + moneyFormat.format(getSavingBalance()));
            break;
        case 2:
            getSavingWithdrawInput();
            getAccountType();
            break;
            
        case 3:
            getSavingDepositInput();
            getAccountType();
            break;
            
        case 4:
            System.out.println("Thank you for using this ATM, bye.");
            break;
            
        default:
            System.out.println("\n" + "Invalid Choice" + "\n");
            getSaving();
    }
}
}

