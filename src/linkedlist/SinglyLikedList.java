package linkedlist;

public class SinglyLikedList {
    Node head;
    Node tail;
    int size=0;

    public void insertatbeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = head;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void traverse(){
        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.print("End");
    }

    public void insertatend(int data){
        Node newNode = new Node(data);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
        tail = newNode;
        size++;
    }

    public void insertatspecificposition(int data,int position){
        Node newNode = new Node(data);
        Node temp = head;
        int currpos=1;
        if(position < 1 || position >size ){
            System.out.println("Invalid position");
        }
        else if(position == size){
            insertatend(data);
        }
        else if (position==1) {
            insertatbeginning(data);
        }
        else{
            while(currpos<position-1){
                temp = temp.next;
                currpos++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

    }

    public void insetaftervalue(int data,int value){
        Node newNode = new Node(data);
        Node temp = head;
        while((temp!=null)&&(temp.data!=value)){
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("Invalid value");
        }
        else{
            if(temp.next==null){
                tail=newNode;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

    }

    public void deleteatbeginning(){
        if(head == null){
            System.out.println("Empty List");
        }
        else if(head.next == null){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
        }
        size--;
    }

    public void deleteatend(){
        Node temp = head;
        if(head == null){
            System.out.println("Empty List");
        }
        else if(head.next == null){
            head = null;
            tail = null;
        }
        else{
            while(temp.next.next!=null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }

    }

    public void deleteatspecificposition(int position){
        Node temp = head;
        int currpos=1;
        if(position < 1 || position >size){
            System.out.println("Invalid position");
        }
        else if(position==1){
            deleteatbeginning();
        }
        else if(position==size){
            deleteatend();
        }
        else{
            while(currpos<position-1){
                temp = temp.next;
            }
            temp.next=temp.next.next;
            size--;
        }

    }

    public void deleteavalue(int value){
        Node temp = head;
        Node prev = null;
        if(head.data==value){
            deleteatbeginning();
        }
        while((temp!=null)&&(temp.data!=value)){
            prev = temp;
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("Invalid value");
        }
        else if((temp.data==value)&&(temp.next==null)){
            deleteatend();
            tail=prev;
        }
        else{
            prev.next = temp.next;
            size--;
        }

    }

    public boolean searchanvalue(int value){
        Node temp = head;
        if(head.data==value){
            return true;
        }
        while((temp!=null)){
            if(temp.data==value) {
                return true;
            }
            temp = temp.next;
        }
       return false;
    }

    public static void main(String[] args) {
        SinglyLikedList list = new SinglyLikedList();
        list.insertatbeginning(5);
        list.insertatbeginning(4);
        list.insertatbeginning(3);
        list.insertatbeginning(2);
        list.insertatbeginning(1);
        list.insertatend(6);
        list.insertatspecificposition(0,1);
        list.insertatspecificposition(7,7);
        list.insetaftervalue(8,7);
        list.deleteatbeginning();
        list.deleteatend();
        list.deleteatspecificposition(1);
        list.deleteatspecificposition(6);
        list.deleteatspecificposition(786);
        list.deleteavalue(6);
        System.out.println(list.searchanvalue(5));
        System.out.println("The size of the linked list is : "+list.size);
        System.out.println("The head is pointing to the data :   "+ list.head.data);
        System.out.println("The tail is pointing to the data : "+list.tail.data);
        list.traverse();
    }
}
