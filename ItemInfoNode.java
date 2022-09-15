/**
 * Rushikesh Palodkar
 * Sbu ID 113808719
 * class ItemInfoNode
 */
public class ItemInfoNode {

    public ItemInfo info;
    public ItemInfoNode next;
    public ItemInfoNode prev;

    /**
     * mutator and accessor methods for the parameters
     * Info
     * ItemInfoNode
     * prev
     * @param newNode
     */
    public ItemInfoNode(ItemInfo newNode) {
        this.info = newNode;
        this.next = null;
        this.prev = null;
    }

    public ItemInfo getInfo() {
        return info;
    }

    public void setInfo(ItemInfo info) {
        this.info = info;
    }

    public ItemInfoNode getNext() {
        return next;
    }


    public void setNext(ItemInfoNode next) {
        this.next = next;
    }

    public ItemInfoNode getPrev() {
        return prev;
    }

    public void setPrev(ItemInfoNode prev) {
        this.prev = prev;
    }
}
