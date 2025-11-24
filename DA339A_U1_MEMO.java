/*
  Author: <Mustafa Al-Saffar>
  Id: <AP7713>
  Study program: <SYS>
*/
import java.util.Scanner;

public class DA339A_U1_MEMO {
  static Scanner input = new Scanner(System.in); //can be removed if another solution is used that do not require this scanner-object                                               
  
  // an array to use for testing, replace as needed to test your code
  static String[][] guestList = {{"Adam Ason", "35"},
                                 {"Berta Bson", "70"},
                                 {"Ceasar Cson", "12"},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                               };

 /* Parameters for methods below may NOT be changed and HAVE TO BE USED as intended for a passing grade.*/

  /**
   * This method makes sure to print the information about the guests 
   * (name and age) from the guest list in the terminal for the user. 
   * The print out shall show name, age and a number representing the guest's place in the guest list. 
   * Empty places in the guest list will NOT be shown.
   */
  public static void printGuestInformation() {
    System.out.println("You chose to print the information of the guests in the guest list");
    for (int i = 0; i < guestList.length; i++) {
      // Check if the guest's place is not empty
      if (!guestList[i][0].isEmpty() && !guestList[i][1].isEmpty()) {
        System.out.println((i + 1) + ". " + guestList[i][0] + ", Age: " + guestList[i][1]);
      }
    }
  }

  /**
   * This method makes sure to print the whole guest list in the terminal for the user. 
   * If a place in the guest list contains data for a guest the guest's name and age is shown. 
   * If a place in the guest list is empty a text stating that the place in empty is shown. 
   * In both cases a number representing the place in the guest list is shown.
   */
  public static void printGuestList() {
    System.out.println("You chose to print the guest list");
    for (int i = 0; i < guestList.length; i++) {
      if (!guestList[i][0].isEmpty() && !guestList[i][1].isEmpty()) {
        System.out.println((i + 1) + ". " + guestList[i][0] + ", Age: " + guestList[i][1]);
      } else {
        System.out.println((i + 1) + ". <Empty>");
      }
    }
  }

  /**
   * This method adds a new guest to the guest list. 
   * If the guest list is full the user shall be told so.
   */
  public static void addGuest() {
    System.out.println("You chose to add a new guest");
    for (int i = 0; i < guestList.length; i++) {
      if (guestList[i][0].isEmpty()) { // Check for an empty spot
        System.out.print("Enter guest name: ");
        guestList[i][0] = input.nextLine();
        System.out.print("Enter guest age: ");
        guestList[i][1] = input.nextLine();
        System.out.println("Guest added successfully.");
        return;
      }
    }
    System.out.println("The guest list is full. Cannot add more guests.");
  }

  /**
   * This method changes the name of a guest in the guest list. 
   * If a guest is not found at the chosen place the user shall be told so.
   */
  public static void changeGuestName() {
    System.out.println("You chose to change a guest's name");
    System.out.print("Enter the number of the guest you want to change: ");
    int index = input.nextInt() - 1;
    input.nextLine();  // Consume newline
    if (index >= 0 && index < guestList.length && !guestList[index][0].isEmpty()) {
      System.out.print("Enter the new name: ");
      guestList[index][0] = input.nextLine();
      System.out.println("Guest name changed successfully.");
    } else {
      System.out.println("Invalid selection or the guest does not exist.");
    }
  }

  /**
   * This method changes the age of a guest in the guest list. 
   * If a guest is not found at the chosen place the user shall be told so.
   */
  public static void changeGuestAge() {
    System.out.println("You chose to change a guest's age");
    System.out.print("Enter the number of the guest you want to change: ");
    int index = input.nextInt() - 1;
    input.nextLine();  // Consume newline
    if (index >= 0 && index < guestList.length && !guestList[index][0].isEmpty()) {
      System.out.print("Enter the new age: ");
      guestList[index][1] = input.nextLine();
      System.out.println("Guest age changed successfully.");
    } else {
      System.out.println("Invalid selection or the guest does not exist.");
    }
  }

  /**
   * This method swaps two guests in the guest list. 
   * If a guest is not found at the chosen places the user shall be told so.
   */
  public static void swapGuests() {
    System.out.println("You chose to swap two guests");
    
    int firstIndex = getValidIndexForSwap("Enter the number of the first guest: ");
    int secondIndex = getValidIndexForSwap("Enter the number of the second guest: ");
    
    if (firstIndex >= 0 && secondIndex >= 0) {
        String[] temp = guestList[firstIndex];
        guestList[firstIndex] = guestList[secondIndex];
        guestList[secondIndex] = temp;
        System.out.println("Guests swapped successfully.");
    } else {
        System.out.println("Invalid selection. One or both guests do not exist.");
    }
}

public static int getValidIndexForSwap(String prompt) {
    while (true) {
        System.out.print(prompt);
        String inputStr = input.nextLine();
        
        if (isNumeric(inputStr)) {
            int index = Integer.parseInt(inputStr) - 1;
            if (index >= 0 && index < guestList.length && !guestList[index][0].isEmpty()) {
                return index;
            }
        }
        
        System.out.println("Invalid input. Please enter a valid guest number.");
    }
}

public static boolean isNumeric(String str) {
    return str != null && str.matches("\\d+");
}


  /**
   * This method removes a guest from the guest list. 
   * If a guest is not found at the chosen place the user shall be told so.
   */
  public static void removeGuest() {
    System.out.println("You chose to remove a guest");
    System.out.print("Enter the number of the guest to remove: ");
    int index = input.nextInt() - 1;
    input.nextLine();  // Consume newline
    if (index >= 0 && index < guestList.length && !guestList[index][0].isEmpty()) {
      guestList[index][0] = "";  // Clear name
      guestList[index][1] = "";  // Clear age
      System.out.println("Guest removed successfully.");
    } else {
      System.out.println("Invalid selection or the guest does not exist.");
    }
  }

  /**
   * This method prints out statistics of the guests in the guest list. 
   * Statistics shown: 
   *   - Total number of guests.
   *   - Number of adult guests.
   *   - Number of child guests.
   *   - The oldest guest.
   *   - The youngest guest.
   */
  public static void printStatistics() {
    System.out.println("You chose to print guest statistics");
    int totalGuests = 0;
    int adults = 0;
    int children = 0;
    String oldestGuest = "";
    String youngestGuest = "";
    int oldestAge = 0;
    int youngestAge = Integer.MAX_VALUE;

    for (int i = 0; i < guestList.length; i++) {
      if (!guestList[i][0].isEmpty()) {
        totalGuests++;
        int age = Integer.parseInt(guestList[i][1]);
        if (age >= 13) {
          adults++;
        } else {
          children++;
        }
        if (age > oldestAge) {
          oldestAge = age;
          oldestGuest = guestList[i][0];
        }
        if (age < youngestAge) {
          youngestAge = age;
          youngestGuest = guestList[i][0];
        }
      }
    }

    System.out.println("Total guests: " + totalGuests);
    System.out.println("Adults: " + adults);
    System.out.println("Children: " + children);
    System.out.println("Oldest guest: " + oldestGuest + " (" + oldestAge + " years old)");
    System.out.println("Youngest guest: " + youngestGuest + " (" + youngestAge + " years old)");
  }

  // A simple menu to test the functions
  public static void main(String[] args) {
    boolean running = true;
    while (running) {
      printMenu();
      int choice = getMenuChoice();
      switch (choice) {
        case 1:
          printGuestInformation();
          break;
        case 2:
          printGuestList();
          break;
        case 3:
          addGuest();
          break;
        case 4:
          changeGuestName();
          break;
        case 5:
          changeGuestAge();
          break;
        case 6:
          swapGuests();
          break;
        case 7:
          removeGuest();
          break;
        case 8:
          printStatistics();
          break;
        case 9:
          System.out.println("Exiting the program.");
          running = false;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  /**
   * Prints the menu for the user. 
   */
  public static void printMenu() {
    System.out.println("\n--- Guest List Menu ---");
    System.out.println("1. Print guest information");
    System.out.println("2. Print full guest list");
    System.out.println("3. Add a guest");
    System.out.println("4. Change a guest's name");
    System.out.println("5. Change a guest's age");
    System.out.println("6. Swap two guests");
    System.out.println("7. Remove a guest");
    System.out.println("8. Print statistics");
    System.out.println("9. Exit");
    System.out.print("Enter your choice: ");
  }


  /**
   * Gets a valid guest index from the user. 
   */
  public static int getMenuChoice() {
    String inputStr;
    while (true) {
        inputStr = input.nextLine();
        if (isNumeric(inputStr)) {
            return Integer.parseInt(inputStr);
        } else {
            System.out.print("Invalid input. Please enter a valid number: ");
        }
    }
}

}
