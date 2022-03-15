import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LocationDatabase {

  String[] name = { "IOI", "KLCC", "Pavilion", "tesco", "Roswell" };
  int[] id = { 1, 2, 3, 4, 5 };
  int[] area = { 60000, 80000, 90000, 20000, 1000 };
  int[] avgTime = { 60, 80, 90, 50, 20 };
  int[] maxCapacity = { 60000 / 133, 80000 / 133, 90000 / 133, 20000 / 133, 1000 / 133 };
  int north;
  int south;
  int east;
  int west;
  // int[] dircetions = {};

  public void menu() {
    for (int i = 0; i < 5; i++) {
      System.out.println(" id: " + id[i] + " name: " + name[i] + " area: " + area[i]
          + " Max capacity: " + maxCapacity[i] + "Avg time: " + avgTime[i]);

    }
  }

  public int rand(int maxCapacity) {
    int maxVisitor = new Random().nextInt(maxCapacity);
    return maxVisitor;
  }

  public void setDirections(int n, int s, int e, int w) {
    north = n;
    south = s;
    east = e;
    west = w;
  }

}

class SocialBubble extends LocationDatabase {
  String fullName, date, time;;
  int id;
  // boolean status;
  Random randomStatus = new Random();
  boolean status = randomStatus.nextBoolean();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
  LocalDateTime now = LocalDateTime.now();

  public void casualContact() {
    System.out.println(
        "you have not followed social distansing and you are now a in close contant of a close contact. \nyour information has been recorded and changed to casual contact: ");
    System.out
        .println("Full name: Mohamed Abubaker Mohamed \n " + " ID: 20302059 \n" + " date and time:  "
            + formatter.format(now) + "\n status: casual contact \n");
  }

  public void closeContact() {
    System.out.println(
        "you have not followed social distansing and you are now a in close contant of a positive case. \nyour information has been recorded and changed to close contact: \n");
    System.out
        .println(
            "Full name: Mohamed Abubaker Mohamed \n" + " ID: 20302059 \n " + " date and time:  "
                + formatter.format(now) + " \n status: close contact \n");
  }

  public void allow() {
    Scanner in = new Scanner(System.in);
    SocialBubble locations = new SocialBubble();
    System.out.println(
        "Enter your distance from other people in all four dircetions in feets (north, south, east, west) accordingly:");
    locations.north = in.nextInt();
    locations.south = in.nextInt();
    locations.west = in.nextInt();
    locations.east = in.nextInt();

    // if the any of the entered distance is less 6 feet from other people
    // -> display message telling the user that they are either a colse or casual
    // contact based on the status

    if (locations.north < 6 || locations.south < 6 ||
        locations.east < 6
        || locations.west < 6) {
      if (locations.status == true) {
        closeContact();
        locations.closeContact();
      } else if (locations.status == false) {
        casualContact();
      }
      if (locations.north < 6) {
        System.out.println("For you to maintain social distancing, you should move: "
            + (6 - locations.north) + " feets north");
      } else if (locations.south < 6) {
        System.out.println("For you to maintain social distancing, you should move: "
            + (6 - locations.south) + " feets south");
      } else if (locations.east < 6) {
        System.out.println("For you to maintain social distancing, you should move: "
            + (6 - locations.east) + " feets east");
      } else if (locations.west < 6) {
        System.out.println("For you to maintain social distancing, you should move: "
            + (6 - locations.west) + " feets west");
      }
      // if the distance entered is 6 feet from other people -> allow user to enter
    } else {
      System.out.println("Thank you for following socail distance. Hope you you have fun and stay safe.");
    }
    in.close();
  }

  public void diallow() {
    System.out.println(
        "You are not allowed to enter because the max capicite has been reached, you  have to wait 60 minuts. \n press n if you would like to wait, 2 if you will not.");
  }
}

class ProactiveSD {
  public static void main(String[] args) {
    SocialBubble locations = new SocialBubble();
    SocialBubble location6 = new SocialBubble();
    // user input
    Scanner input = new Scanner(System.in);
    int userChoice;

    // max visistors
    int maxVisitors1 = locations.rand(60000 / 144);
    int maxVisitors2 = locations.rand(80000 / 144);
    int maxVisitors3 = locations.rand(90000 / 144);
    int maxVisitors4 = locations.rand(20000 / 144);
    int maxVisitors5 = locations.rand(1000 / 133);

    locations.menu();
    System.out.println("which location do you want to go to? ");
    userChoice = input.nextInt();

    switch (userChoice) {
      case 1:
        if (maxVisitors1 < 60000 / 144) {
          locations.allow();
        } else {
          locations.diallow();
        }
        break;
      case 2:
        if (maxVisitors2 < 60000 / 144) {
          locations.allow();
        } else {
          locations.diallow();
        }
        break;
      case 3:
        if (maxVisitors3 < 60000 / 144) {
          locations.allow();
        } else {
          locations.diallow();

        }
        break;
      case 4:
        if (maxVisitors4 < 60000 / 144) {
          locations.allow();
        } else {
          locations.diallow();
        }
        break;
      case 5:
        if (maxVisitors5 < 60000 / 144) {
          locations.allow();
        } else {
          locations.diallow();
        }
        break;
    }
    input.close();

  }
}

// case 2:
// if (maxVisitors2 < 60000 / 133) {
// System.out.println(
// "Enter your distance from other people in all four dircetions in feets
// (north, south, east, west) accordingly:");
// DirectionsMenu location2Directions = new DirectionsMenu();
// location2Directions.setNorth(input.nextInt());
// location2Directions.setSouth(input.nextInt());
// location2Directions.setEast(input.nextInt());
// location2Directions.setWest(input.nextInt());
// if (location2Directions.north < 6 || location2Directions.south < 6 ||
// location2Directions.east < 6
// || location2Directions.west < 6) {
// if (locations.status == true) {
// locations.closeContact();

// } else if (locations.status == false) {
// locations.casualContact();
// }
// if (l case 2:
// if (maxVisitors2 < 60000 / 133) {
// System.out.println(
// "Enter your distance from other people in all four dircetions in feets
// (north, south, east, west) accordingly:");
// DirectionsMenu location2Directions = new DirectionsMenu();
// location2Directions.setNorth(input.nextInt());
// location2Directions.setSouth(input.nextInt());
// location2Directions.setEast(input.nextInt());
// location2Directions.setWest(input.nextInt());
// if (location2Directions.north < 6 || location2Directions.south < 6 ||
// location2Directions.east < 6
// || location2Directions.west < 6) {
// if (locations.status == true) {
// locations.closeContact();

// } else if (locations.status == false) {
// locations.casualContact();
// }
// if (location2Directions.north < 6) {
// System.out.println("For you to maintain social distancing, you should move: "
// + (6 - location2Directions.north) + " feets north");
// } else if (location2Directions.south < 6) {
// System.out.println("For you to maintain social distancing, you should move: "
// + (6 - location2Directions.south) + " feets south");
// } else if (location2Directions.east < 6) {
// System.out.println("For you to maintain social distancing, you should move: "
// + (6 - location2Directions.east) + " feets east");
// } else if (location2Directions.west < 6) {
// System.out.println("For you to maintain social distancing, you should move: "
// + (6 - location2Directions.west) + " feets west");
// }
// } else {
// System.out.println("Thank you for following socail distance. Hope you you
// have fun and stay safe.");
// }
// } else {
// System.out.println(
// "You are not allowed to enter because the max capicite has been reached, you
// have to wait 60 minuts. \n press 1 if you would like to wait, 2 if you will
// not.");

// }
// break;
// }ocation2Directions.north < 6) {
// System.out.println("For you to maintain social distancing, you should move: "
// + (6 - location2Directions.north) + " feets north");
// } else if (location2Directions.south < 6) {
// System.out.println("For you to maintain social distancing, you should move: "
// + (6 - location2Directions.south) + " feets south");
// } else if (location2Directions.east < 6) {
// System.out.println("For you to maintain social distancing, you should move: "
// + (6 - location2Directions.east) + " feets east");
// } else if (location2Directions.west < 6) {
// System.out.println("For you to maintain social distancing, you should move: "
// + (6 - location2Directions.west) + " feets west");
// }
// } else {
// System.out.println("Thank you for following socail distance. Hope you you
// have fun and stay safe.");
// }
// } else {
// System.out.println(
// "You are not allowed to enter because the max capicite has been reached, you
// have to wait 60 minuts. \n press 1 if you would like to wait, 2 if you will
// not.");

// }
// break;
// }