package linkedlist;

public class CircularDoublyLinkedList {
    DLLNode head;
    DLLNode tail;
    int size;
    public void traverse(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        DLLNode temp = head;
        do{
            System.out.print(temp.data + "->");
            temp = temp.next;
        }while(temp!= head);
        System.out.print("End");
    }

    public void insertatbeggining(int data){
        if(head == null){
            head=new DLLNode(data);
            tail=head;
            head.next=head;
            head.prev=head;
            size++;
            return;
        }
        DLLNode newNode=new DLLNode(data);
        DLLNode temp=head;
        newNode.prev=temp.prev;
        newNode.next=temp;
        head.prev.next=newNode;
        head.prev=newNode;
        head=newNode;
        size++;
    }

    public void insertatend(int data){
        if(head == null){
            insertatbeggining(data);
            return;
        }
        //DLLNode last=head.prev;
        DLLNode newNode=new DLLNode(data);
        newNode.next=tail.next;
        newNode.prev=tail;
        tail.next=newNode;
        head.prev=newNode;
        tail=newNode;
        size++;
    }

    public void insertatposition(int data,int position){
        if(position<=0 || position>size+1){
            System.out.println("Invalid position");
            return;
        }
        if(head == null || position==1){
            insertatbeggining(data);
            return;
        }
        if(position==size+1){
            insertatend(data);
            return;
        }
        DLLNode newNode=new DLLNode(data);
        DLLNode temp=head;
        int curpos=1;
        do{
            if(curpos==position){
                break;
            }
            temp=temp.next;
            curpos++;
        }while(temp!=head);
        newNode.next=temp;
        newNode.prev=temp.prev;
        temp.prev.next=newNode;
        temp.prev=newNode;
        size++;
    }

    public void insertaftervalue(int data,int value){
        if(head == null){
            System.out.println("No such value exists");
            return;
        }
        DLLNode newNode=new DLLNode(data);
        DLLNode temp=head;

        do {
            if(temp.data==value){
                break;
            }
            temp=temp.next;
        }while(temp!=head);
        if(temp.data!=value){
            System.out.println("No such value exists");
            return;
        }
        if(temp.next==head){
            insertatend(data);
            return;
        }
        newNode.prev=temp;
        newNode.next=temp.next;
        temp.next.prev=newNode;
        temp.next=newNode;
        size++;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insertatbeggining(5);
        list.insertatbeggining(4);
        list.insertatbeggining(3);
        list.insertatbeggining(2);
        list.insertatbeggining(1);
        list.insertatend(6);
        list.insertatposition(100,7);
        list.insertaftervalue(999,1);
        list.traverse();
        System.out.println("\nThe size of the list is "+list.size);
        System.out.println("The head is pointing to : "+list.head.data);
        System.out.println("The tail is pointing to : "+list.tail.data);
    }
}
