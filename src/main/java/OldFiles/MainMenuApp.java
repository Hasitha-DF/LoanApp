//package org.example.Utilities;
//
//import org.example.controllers.ClientController;
//import org.example.services.Services;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class MainMenuApp {
////        StandardServiceRegistry objTest;
////        try {
////            Class<StandardServiceRegistryBuilder> classTest = StandardServiceRegistryBuilder.class;
////            Constructor<StandardServiceRegistryBuilder> consTest = classTest.getDeclaredConstructor();
////            consTest.setAccessible(true);
////            objTest = (StandardServiceRegistry) consTest.newInstance().configure().build();
////        } catch (NoSuchMethodException e) {
////            throw new RuntimeException(e);
////        } catch (InvocationTargetException e) {
////            throw new RuntimeException(e);
////        } catch (InstantiationException e) {
////            throw new RuntimeException(e);
////        } catch (IllegalAccessException e) {
////            throw new RuntimeException(e);
////        }
////        StandardServiceRegistry ssr =  .configure().build();
////        logger.debug("HHS - read");
////        BootstrapServiceRegistry bssr = new BootstrapServiceRegistryBuilder().build();
//
//    Scanner sc = new Scanner(System.in);
//    Services services = new Services();
//
//    public MainMenuApp() throws IOException {
//    }
//
//
//    public int mainMenu() throws IOException {
//            int selection = 0;
//
//            System.out.println("\n\nWelcome!");
//            System.out.println("1 - Create/Edit Account");
//            System.out.println("2 - Create Savings Account");
//            System.out.println("3 - Apply For Loan");
//            System.out.println("4 - Pay/Check Installment");
//        System.out.println("5 - Server test ");
//        System.out.println("6 - Exit");
//        System.out.print("What kind of bank service do u require - ");
//            selection = sc.nextInt();
//
//            if (selection == 1) {
//                services.saveClient();
//            } else if (selection == 2) {
//                services.firstTimeCreateSavings();
//            } else if (selection == 3) {
//                services.applyLoan();
//            } else if (selection == 4) {
//
//            } else if (selection == 5) {
//                System.out.println("Thank you for using our bank");
//            }
//            else if (selection == 6 ){
//
//
////                Hello.getInstance().responseHello();
////                SaveDataHC.getInstance().saveName();
//            }else
//
//                System.out.println("Invalid input!");
//
//            return selection;
//
//
//        }
//
//    }
//
//
