import java.util.Scanner;


  /**
   * Rushikesh Palodkar
   * Sbu ID 113808719
   * class DepartmentStore
  */

public class DepartmentStore {
      public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        ItemList currentnode;
/**
 * Switch case Statement according to menu
 */
        currentnode = new ItemList();
        while (true) {
            System.out.println("\n Enter your choice \n" +
                    " Welcome!\n" +
                    "\t\n" +
                    "    C - Clean store \n" +
                    "    I - Insert an item into the list \n" +
                    "    L - List by location \n" +
                    "    M - Move an item in the store \n" +
                    "    O - Checkout  \n" +
                    "    P - Print all items in store \n" +
                    "    R - Print by RFID tag number         (optional - extra credit)\n" +
                    "    U - Update inventory system   \n" +
                    "    Q - Exit the program. ");
            String choice = String.valueOf(sc.next().charAt(0));

            switch (choice) {
                case "C":
                case"c" :
                    ItemInfo.count =0;
                    System.out.println("Clean store:");
                    currentnode.cleanStore();
                    break;
                case "I":
                case "i":
                    ItemInfo.count =0;
                    //ItemInfo info = new ItemInfo();
                    System.out.println("Enter the name:");
                    String name = sc.next();//info.setName(name);
                    System.out.println("Enter the RFID:");
                    String rfidTag = sc.next();
                    //info.setRfidTagNumber(rfidTag);
                    System.out.println("Enter the original location:");
                    String initPosition = sc.next();
                    //info.setCurrentlocation(initPosition);
                    System.out.println("Enter the price:");
                    double price = sc.nextDouble();
                    //info.setPrice(price);
                    currentnode.insertInfo(name,rfidTag,initPosition,price);
                    break;

                case "l":
                case "L":
                    ItemInfo.count =0;
                    System.out.print("list by location Enter the Location to print");

                    String location =sc.next();
                    currentnode.printByLocation(location);
                    break;

                case "M":
                case "m":
                    ItemInfo.count =0;
                    System.out.println("Move an item in the store");
                    System.out.println("Enter the RFID:");

                    String rfidTag1 = sc.next();
                    System.out.println("Enter the original location:");
                    String source1 =sc.next();
                    System.out.println("Enter the new location");
                    String dest1 =sc.next();
                    currentnode.moveItem(rfidTag1, source1,dest1);
                    break;

                    case "O":
                     case"o":
                         ItemInfo.count =0;
                    System.out.println("Enter the cart number:");
                    String cart =sc.next();
                    currentnode.checkOut(cart);
                    break;

                case "P":
                case "p":
                    ItemInfo.count =0;
                    System.out.println("Items are:");
                    currentnode.printAll();
                    break;

                case "R":
                case "r":
                    ItemInfo.count =0;
                    System.out.println("Print by RFID tag number");
                    System.out.println("Enter the RFID");

                    String RFID = sc.next();
                    currentnode.RFID_tag(RFID);
                    break;

                case "U":
                case "u":
                    ItemInfo.count =0;
                    System.out.println("Update inventory system");
                    currentnode.updateInventorySystem();
                    break;
                case "Q":
                case"q":
                    System.out.println("Quit: Good Bye! Thank You! ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Nothing is selected");
                    break;

            }
        }
    }
}

//          ItemList currentnode= new ItemList();
//          currentnode.insertInfo("1", "00A5532FF", "s12345", 30.00);
//          currentnode.insertInfo("2", "0F999FABC", "s00347", 18.00);
//          currentnode.insertInfo("3", "A1111DDFF", "s12349", 50.00);
//          currentnode.insertInfo("4", "00A5532FF", "s90210", 30.00);
//          currentnode.insertInfo("5", "0F999FCBA", "s12345", 18.00);
//          currentnode.insertInfo("6", "00A5532FF", "s00347", 30.00);
//          currentnode.insertInfo("7", "00B1532FF", "s12645", 30.00);
//
//
//          currentnode.printAll();

//          currentnode.moveItem("00A5532FF", "s12345", "c105");
//          currentnode.moveItem("00A5532FF", "s12345", "c109");
//          currentnode.moveItem("00A5532FF", "c109", "s10000");
//          currentnode.moveItem("A1111DDFF", "s90210", "s12345");
//          System.out.println("__________________________");
//          currentnode.printAll();
//
//          currentnode.moveItem("00A2532FF", "s12359", "s12779");
//          currentnode.printAll();
//          currentnode.checkOut("c109");
//          System.out.println("\n total cost:" + currentnode.checkOut("c105"));
//          System.out.println(currentnode.checkOut("c109") + "\ntotal cost " + currentnode.checkOut("c109"));
//          System.out.println("+++++++++++++++++++");
//          currentnode.printByLocation("s12349");
//          System.out.println("+++++++++++++++++++");
//          currentnode.cleanStore();
//          currentnode.updateInventorySystem();

//          currentnode.RFID_tag("00B1532FF");
//      }
//  }

