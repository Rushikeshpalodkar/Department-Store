//public class LinkList {
//    private ItemInfoNode head;
//    private ItemInfoNode tail;
//    private int  size;
//
//    public void insertFirst(int val){
//        ItemInfoNode node = new ItemInfoNode();
//        node.next = head;
//        head =node;
//        if(tail==null){
//            tail =head;
//        }
//    }
//    public  void insertInfo(String name, String rfidTag, double price, String initPosition){}
//        if(index==0){
//            insertFirst(val);
//            return val;
//        }
//        if(index==size){
//            insertLast(val);
//            return val;
//        }
//
//        ItemInfoNode temp = head;
//        for(int i = 1; i< index;i++){
//            temp = temp.next;
//        }
//        ItemInfoNode node = new ItemInfoNode(val, temp.next);
//        temp.next = node;
//        size++;
//
//        return val;
//
//    }
