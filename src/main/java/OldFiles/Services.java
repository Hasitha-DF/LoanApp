//package org.example.services;
//
//import org.example.entities.Client;
//import org.example.entities.Loan;
//import org.example.entities.PaymentPlan;
//import org.example.entities.SavingsAccount;
//import org.example.Utilities.AccountNumberGenerator;
//import org.example.util.HibernateUtil;
//
//
//import java.sql.Date;
//import java.util.Objects;
//import java.util.Scanner;
//
//public class Services {
//
//    Client c1 = new Client();
//    SavingsAccount s1 = new SavingsAccount();
//    SaveData saveData = new SaveData();
//    GetData getData = new GetData();
//    Loan l1 = new Loan();
//    PaymentPlan pp1 = new PaymentPlan();
//    Scanner sc = new Scanner(System.in);
//
//
//    public void saveClient(){
//        System.out.print("Enter your first name - ");
//        c1.setFirstname(sc.nextLine());
//        System.out.println("");
//
//        System.out.print("Enter your last name - ");
//        c1.setLastname(sc.nextLine());
//        System.out.println("");
//
//        System.out.print("Enter your occupation - ");
//        c1.setOccupation(sc.nextLine());
//        System.out.println("");
//
//        System.out.print("Enter your NIC - ");
//        c1.setNic(sc.nextLine());
//        System.out.println("");
//
//        System.out.print("Enter your address - ");
//        c1.setAddress(sc.nextLine());
//        System.out.println("");
//
//        System.out.print("Enter your email - ");
//        c1.setEmail(sc.nextLine());
//        System.out.println("");
//
//        System.out.print("Enter your password - ");
//        c1.setPassword(sc.nextLine());
//        System.out.println("");
//
//
//        System.out.println("Client details entered:");
//        System.out.println("Username: " + c1.getLastname());
//        System.out.println("Occupation: " + c1.getOccupation());
//        System.out.println("NIC: " + c1.getNic());
//        System.out.println("Address: " + c1.getAddress());
////        System.out.println("DOB: " + c1.getDob());
//        System.out.println("Email: " + c1.getEmail());
//
//        // Close the scanner
//        sc.close();
//        saveData.saveData(c1);
//
//    }
//
//    public void firstTimeCreateSavings(){
//
//        System.out.print("Do you want to create a savings account! - ");
//        String approvalSA = sc.nextLine();
//        if(approvalSA.toLowerCase().equals("yes")){
//            System.out.print("Do you have a registered account in our bank - ");
//            if(sc.nextLine().toLowerCase().equals("yes")){
//                System.out.print("\nEnter your userID - ");
//                int ID = sc.nextInt();
//                System.out.print("\nEnter your password - ");
//                String password = sc.next();
//                c1=getData.getData(Client.class, ID);
//                s1=getData.getData(SavingsAccount.class , ID);
//                if (Objects.equals(password, c1.getPassword()))
////                        &&s1.getSavingsAccno().isBlank())
//                {
//                     s1.setSavingsAccno(AccountNumberGenerator.generateAccountNumber());
////                     s1.setUserId(ID);
//                     s1.setClient(c1);
//                    System.out.println(s1.getUserId());
//                     saveData.saveData(s1);
//                }
//            }
//            else System.out.println("Sorry! u have to create a user account first");
//
//        }
//        else System.out.println("Thank you for using the app");
//
//
//    }
//
//    public void applyLoan(){
//        System.out.println("\nPlease fill out following details for apply for the loan :");
//
//        System.out.print("Enter your user ID - ");
//        int saveA = sc.nextInt();
//        s1 = getData.getData(SavingsAccount.class, saveA );
//        if(s1.getSavingsAccno().isEmpty()){
//            System.out.println("You cannot apply for a loan without a Savings account");
//        } else
//        {
//            System.out.print("Enter Loan ID - ");
//            l1.setLoanId(sc.nextLine());
//            System.out.println("");
//
//            System.out.print("Enter Loan Amount - ");
//            l1.setLoanAmount(sc.nextDouble());
//            sc.nextLine();
//            System.out.println("");
//
//            System.out.print("Enter Acquired By - ");
//            l1.setAcquiredBy(sc.nextLine());
//            System.out.println("");
//
//            System.out.print("Enter Repayment Method - ");
//            l1.setRepaymentMethod(sc.nextLine());
//            System.out.println("");
//
//            saveData.saveData(l1);
//        }
//
//
////        System.out.print("Enter User ID - ");
//
//
////        System.out.print("Enter Guarantor ID - ");
//
//
////        System.out.print("Enter Loan Type ID - ");
//
//
//
//    }
//
//    public void createPaymentPlan() {
//
//        System.out.print("Enter Installment ID - ");
//        pp1.setInstallmentId(AccountNumberGenerator.generatePaymentID());
//        System.out.println("");
//
//        System.out.print("Enter Installment Date - ");
//        pp1.setInstallmentDate(Date.valueOf(sc.nextLine()));
//        System.out.println("");
//
//        System.out.print("Enter Installment Method - ");
//        pp1.setInstallmentMethod(sc.nextLine());
//        System.out.println("");
//
//        System.out.print("Enter Installment Amount - ");
//        pp1.setInstallmentAmount(sc.nextDouble());
//        sc.nextLine();
//        System.out.println("");
//
//        System.out.print("Enter Installment Status - ");
//        pp1.setInstallmentStatus(sc.nextLine());
//        System.out.println("");
//
//        System.out.print("Enter Outstanding Loan Amount - ");
//        pp1.setOutstandingLoan(sc.nextDouble());
//        sc.nextLine();
//        System.out.println("");
//
////        System.out.print("Enter Loan ID - ");
////        pp1.set(sc.nextLine());
////        System.out.println("");
//    }
//
//    public void viewPaymentPlan(){{
//            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
//                    "Installment ID", "Installment Date", "Installment Method",
//                    "Installment Amount", "Installment Status",
//                    "Outstanding Loan Amount", "Loan ID");
//
//            System.out.println("----------------------------------------------------------------------------------------------------------");
//
//            int i = 0;
//            do {
//                pp1=getData.getData(PaymentPlan.class, i);
//                System.out.printf("%-20s %-20s %-20s %-20.2f %-20s %-20.2f %-20s%n",
//                        pp1.getInstallmentId(),
//                        pp1.getInstallmentDate(),
//                        pp1.getInstallmentMethod(),
//                        pp1.getInstallmentAmount(),
//                        pp1.getInstallmentStatus(),
//                        pp1.getOutstandingLoan(),
//                        pp1.getLoanId()
//                );
//            } while ( pp1.getInstallmentId().isEmpty());
//        }
//
//    }
//
//}
