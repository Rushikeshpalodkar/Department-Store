import java.util.Comparator;
/**
 * Rushikesh Palodkar
 * Sbu ID 113808719
 * class ItemInfo
 */
public class ItemInfo implements Comparator<ItemInfo> {
    public String name;
    public double price;
    public String rfidTagNumber;
    public String originallocation;
    public String currentlocation;
    public static int count=0;


    /**
     * Constructor that assign values.
     * @param name
     * @param rfidTag
     * @param originalPosition
     * @param price
     */
    public ItemInfo(String name, String rfidTag, String originalPosition, double price) {
        setName(name);
        setPrice(price);
        setRfidTagNumber(rfidTag);
        setOriginallocation(originalPosition);
        setCurrentlocation(originalPosition);
    }

    /**
     * compares the string of the object.
     * @param a
     * @param b
     * @return
     */
    public int compare(ItemInfo a, ItemInfo b) {

        return b.rfidTagNumber.compareTo(a.rfidTagNumber);
    }

    /**
     * This methods helps to print the strings in correct way.
     * @return
     */
    @Override
    public String toString() {
        count++;
        String result;
        String R1=String.format("%-21s %-21s %-19s %-19s %-19s","Name", "RFID", "original location", "current location","Price");
        String R2="\n"+String.format("%-21s %-21s %-19s %-19s %-19.2f",getName(),getRfidTagNumber(),getOriginallocation() ,getCurrentlocation(),getPrice());
        if(count==1) {

            result =R1+R2;
        }
        else{
            result=R2; }

        return result;

    }

    /**
     * mutator and accessor methods
     * for all parameters
     * including conditions for the mutator methods.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRfidTagNumber() {
        return rfidTagNumber;
    }

    public void setRfidTagNumber(String rfidTagNumber) {
        int length = rfidTagNumber.length();
        if (length == 9) {
            if (rfidTagNumber.matches("[a-fA-F0-9_]+")) {
                this.rfidTagNumber = rfidTagNumber;
            }
        }
        else
            throw new IllegalArgumentException("Can't read the String");
    }

    public String getOriginallocation() {
        return originallocation;
    }

    public void setOriginallocation(String originallocation) {
        if (checkShelfLocation(originallocation))
            this.originallocation = originallocation;
        else
            throw new IllegalArgumentException("Invalid shelf/original location");

    }

    public String getCurrentlocation() {
        return currentlocation;
    }

    public boolean checkShelfLocation(String location) {
        if (location.charAt(0) != 's')
            return false;
        if (location.length() != 6)
            return false;
        return true;
    }

    public boolean checkCartLocation(String location) {
        if (location.charAt(0) != 'c' && location.length() != 4 && !location.equals("out"))
            return false;
        return true;
    }

    public void setCurrentlocation(String currentlocation) {

        if (checkShelfLocation(currentlocation))
            this.currentlocation = currentlocation;
        else if (checkCartLocation(currentlocation))
            this.currentlocation = currentlocation;
        else if (currentlocation.equalsIgnoreCase("out"))
            this.currentlocation = currentlocation;
        else
            throw new IllegalArgumentException("location value is incorrect");

    }

}
