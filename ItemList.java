/**
 * Rushikesh Palodkar
 * Sbu ID 113808719
 * class ItemList
 */
public class ItemList {
    private ItemInfoNode head;
    private ItemInfoNode tail;
    private ItemInfoNode cursor;

    public ItemList() {
    }


    /**
     * Inserts in the node according to all the parameters given.
     * @param name
     * @param rfidTag
     * @param initPosition
     * @param price
     */
    public void insertInfo(String name, String rfidTag, String initPosition, double price) {

        ItemInfo info = new ItemInfo(name, rfidTag, initPosition, price);
        ItemInfoNode newNode = new ItemInfoNode(info);

        if (head == null) {
            head = newNode;
            cursor = head;

            return;
        } else {
            if (info.compare(cursor.getInfo(), newNode.getInfo()) < 0) {
                cursor = head;

                if (cursor.prev == null) {
                    cursor.prev = newNode;
                    newNode.next = cursor;
                    cursor = cursor.prev;
                    head = cursor;
                }
                /**
                 * NOT SURE
                 */
                else if(cursor.prev.prev ==null) {
                    cursor =head;
                    cursor.prev = newNode;
                    newNode.next = cursor;
                    cursor = cursor.prev;
                    head = cursor;
                }

                /**
                 * NOT SURE
                 */
            } else if (info.compare(cursor.getInfo(), newNode.getInfo()) > 0) {
                if (cursor.next == null) {
                    cursor.next = newNode;
                    newNode.prev = cursor;
                    cursor = cursor.next;
                } else {

                    while (cursor.getNext() != null && info.compare(cursor.getInfo(), newNode.getInfo()) > 0 && info.compare(cursor.next.getInfo(), newNode.getInfo()) > 0) {
                        cursor = cursor.next;
                    }
                    ItemInfoNode temp = cursor.next;
                    cursor.next = newNode;
                    newNode.next = temp;
                    // tail = cursor;
                }


            } else {
                ItemInfoNode temp = cursor.next;
                cursor.next = newNode;
                newNode.next = temp;
            }


        }

    }

    /**
     * @param temp
     */
    public void removeInfo(ItemInfoNode temp) {

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next.prev;


    }

    /**
     * Removes all the purchased items from the list.
     */
    public void removeAllPurchased() {
        ItemInfoNode temp = head;
        while (temp != null) {
            if (temp.getInfo().getCurrentlocation() != "out") {
                temp = temp.next;
            } else {
                removeInfo(temp);
                temp = temp.next;
            }
        }
    }

    /**
     * @param cartNumber
     * @return
     */
    public double checkOut(String cartNumber) {
        ItemInfoNode temp = head;
        double cost = 0;
        while (temp != null) {
            if (temp.getInfo().getCurrentlocation() == cartNumber ) {
                System.out.println("\n"+temp.getInfo().toString());
                temp.getInfo().setCurrentlocation("out");
                System.out.println(temp.info.getPrice());
                cost += temp.info.getPrice();
            }
            temp = temp.next;
        }

        return cost;
    }

    /**
     * moving from a spure to a dest location.JUST TO MOVE.
     *
     * @param rfidTag
     * @param source
     * @param dest
     * @return
     */
    public boolean moveItem(String rfidTag, String source, String dest) {
        if (dest.charAt(0) != 'c' && dest.length() != 4 && !dest.equalsIgnoreCase("out") || dest.charAt(0) != 's' && dest.length() != 6 && !dest.equalsIgnoreCase("out")) {

            ItemInfoNode temp = head;
            while (temp != null) {
                if (temp.getInfo().getOriginallocation() == source) {
                    temp.getInfo().setRfidTagNumber(rfidTag);
                    temp.getInfo().setCurrentlocation(dest);
                    break;
                }
                temp = temp.next;
            }
            return true;
        }
        else {
            throw new IllegalArgumentException("That it is not a cart, shelf, or \"out\"");
        }

    }


    /**
     * print all the string
     */
    public void printAll() {
        ItemInfoNode temp = head;
        while (temp != null) {
            System.out.print(temp.info.toString() + " ");
            temp = temp.next;
        }
        System.out.println("END of the list.");
    }

    /**
     * EXTRA CREEDIT
     * Printing according to RFID.
     * @param RFID
     */
    public void RFID_tag(String RFID){
        ItemInfoNode temp =head;
        System.out.println("Print by RFID are:");
        while(temp != null){
            if(temp.getInfo().getRfidTagNumber().equalsIgnoreCase(RFID)){
                System.out.println(temp.getInfo().toString());
            }
            temp =temp.next;
        }
    }

    /**
     * print the string according to the location given.
     * @param location
     */
    public void printByLocation(String location) {
        ItemInfoNode temp = head;
        while (temp != null) {
            if (temp.getInfo().getCurrentlocation().equalsIgnoreCase(location)) {
                System.out.println("moved item during store cleaning " + temp.getInfo().toString());

            }
            temp = temp.next;

        }
    }

    /**
     * As given in the Home work
     * Take every item that is currently in the store and on the wrong shelf and places it back where it belongs (its original location).
     */
    public void cleanStore() {
        ItemInfoNode temp = head;
        while (temp != null) {
            if (!temp.getInfo().getCurrentlocation().equals(temp.getInfo().getOriginallocation()) && !temp.getInfo().checkCartLocation(temp.getInfo().getCurrentlocation())) {
                System.out.println(temp.getInfo().toString());
                temp.getInfo().setCurrentlocation(temp.getInfo().getCurrentlocation());
            }
            temp = temp.next;
        }
    }

    /**
     * Removes all the Items in the list that are listed as "OUT".
     */
    public void updateInventorySystem() {
        ItemInfoNode temp = head;
        while (temp != null) {
            if (temp.getInfo().getCurrentlocation().equalsIgnoreCase("out")) {
                System.out.println("The following item(s) have removed from the system:");
                System.out.println(temp.getInfo().toString());
                ItemInfoNode prev = temp.prev;
                ItemInfoNode next = temp.next;
                if (prev != null)
                    prev.setNext(next);
                if (next != null)
                    next.setPrev(prev);
            }
            temp = temp.next;
        }
    }
}



