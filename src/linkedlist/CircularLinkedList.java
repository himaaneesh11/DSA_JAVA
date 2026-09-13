package linkedlist;

public class CircularLinkedList {
    Node head;
    Node tail;
    int size;
     public void traverse(){
         if(head == null){
             System.out.println("List is empty");
             return ;
         }
        Node temp = head;
         do{
             System.out.print(temp.data+"->");
             temp=temp.next;
         }while(temp!= head);
         System.out.print("End");

     }

     public void insertatbeggining(int data){
         Node temp=head;
         if(head == null){
             head=new Node(data);
             tail=head;
             head.next=head;
             size++;
             return ;
         }
         Node newnode=new Node(data);
         while(temp.next!=head){
             temp=temp.next;
         }
         temp.next=newnode;
         newnode.next=head;
         head=newnode;
         size++;
         /*
         implementing using tail
         tail.next=newnode;
         newnode.next=head;
         head=newnode;
          */

     }

     public void insertatend(int data){
         if(head == null){
             insertatbeggining(data);
             size++;
             return ;
         }
         Node newnode=new Node(data);
         tail.next=newnode;
         newnode.next=head;
         tail=newnode;
         size++;
     }


     public void insertaftervalue(int data,int value){
         if(head == null){
             insertatbeggining(data);
             return ;
         }
         Node temp=head;
         Node newnode=new Node(data);
         while(temp.next!=head){
             if(temp.data==value){
                 newnode.next=temp.next;
                 temp.next=newnode;
                 size++;
                 return ;
             }
             temp=temp.next;
         }
         if(temp.data==value){
             newnode.next=temp.next;
             temp.next=newnode;
             size++;
             tail=newnode;
             return ;
         }
         System.out.println("No value exist");
     }

     public void inserbeforeposition(int data,int position){
         if(position<1 || position>size+1){
             System.out.println("Invalid position");
             return ;
         }
         if(head == null || position==1){
             insertatbeggining(data);
             return ;
         }
         else if(position==size+1){
             insertatend(data);
             return ;
         }
         Node newnode=new Node(data);
         Node temp=head;
         Node prev=null;
         int curpos=1;
         do{
             if(curpos==position){
                 break;
             }
             prev=temp;
             temp=temp.next;
             curpos++;
         }while(temp!=head);
         if(temp==head){
             System.out.println("No value exist");
             return ;
         }
         prev.next=newnode;
         newnode.next=temp;
         size++;
     }




    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertatbeggining(60);
        list.insertatbeggining(50);
        list.insertatbeggining(40);
        list.insertatbeggining(30);
        list.insertatbeggining(20);
        list.insertatbeggining(10);
        list.insertatend(70);
        list.insertaftervalue(100,80);
        list.inserbeforeposition(0,1);
        list.traverse();
        System.out.println("\nThe size of list is : "+list.size);
        System.out.println("The head is pointing to data : "+list.head.data);
        System.out.println("The tail is pointing to data : "+list.tail.data);
    }
}
