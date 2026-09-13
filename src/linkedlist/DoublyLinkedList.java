package linkedlist;

public class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;
    int size;
    public void insertatbeggining(int data){
        DLLNode newnode = new DLLNode(data);
        if(head == null){
            head = newnode;
            tail = newnode;
        }
        else{
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
        size++;
    }

    public void insertatend(int data){
        DLLNode newnode = new DLLNode(data);
        if(head == null){
            insertatbeggining(data);
        }
        else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
            size++;
        }

        /*If tail is not present then code with head
        DLLNode temp;
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.prev=temp;
        tail=newnode;
        size++;
         */
    }

    public void insertatposition(int data,int position){
        if(position <= 0 || position > size+1){
            System.out.println("Invalid position");
            return;
        }

        if(head == null){
            insertatbeggining(data);
            return;
        }
        else if (position==1) {
            insertatbeggining(data);
            return;
        }
        else if(position == size+1){
            insertatend(data);
            return;
        }

        DLLNode newnode = new DLLNode(data);
        DLLNode temp = head;
        int curpos=1;
        while(temp!=null){
            if(curpos==position){
                newnode.next = temp;
                temp.prev.next = newnode;
                newnode.prev = temp.prev;
                temp.prev=newnode;
                size++;
                return;
            }
            temp=temp.next;
            curpos++;
        }
    }

    public void insertaftervalue(int value,int data){
        DLLNode newnode = new DLLNode(data);
        DLLNode temp = head;
        if(head == null){
            insertatbeggining(data);
            return;
        }
        while(temp != null){
            if(temp.data == value){
                newnode.prev = temp;
                newnode.next = temp.next;
                if(temp.next != null){
                    temp.next.prev = newnode;
                }
                else{
                    tail = newnode;
                }
                temp.next = newnode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    public void traversal(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        DLLNode temp = head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.print("End");
    }

    public void deletefrombeggining(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        else if (head.next==null) {
            head=null;
            tail=null;
        }
        else{
            DLLNode prevv = head;
            head=head.next;
            head.prev=null;
            prevv.next=null;

        }
        size--;
    }

    public void deleteatend(){
        DLLNode temp=head;
        if(head==null){
            System.out.println("List is empty");
            return;
        } else if (head.next==null) {
            head=null;
            tail=null;
            size--;
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.prev.next=null;
        temp.prev=null;
        size--;
    }

    public void deletefromposition(int position){
        if(position<1 || position>size){
            System.out.println("Invalid position");
            return;
        }
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(position==1){
            deletefrombeggining();
            return;
        }
        else if(position==size){
            deleteatend();
            return;
        }
        int curpos=1;
        DLLNode temp = head;
        while(temp!=null){
            if(curpos==position){
               temp.prev.next = temp.next;
               temp.next.prev = temp.prev;
               temp.next=null;
               temp.prev=null;
               size--;
               return;
            }
            temp=temp.next;
            curpos++;
        }

    }

    public void deletevalue(int value){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.data == value){
            deletefrombeggining();
            return;
        }
        DLLNode temp = head;
        while(temp!=null){
            if(temp.data == value){
                temp.prev.next = temp.next;
                if(temp.next != null){
                    temp.next.prev = temp.prev;
                }
                temp.prev=null;
                temp.next=null;
                size--;
                return;
            }
            temp=temp.next;
        }

    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertatbeggining(7);
        list.insertatbeggining(6);
        list.insertatbeggining(5);
        list.insertatbeggining(4);
        list.insertatbeggining(3);
        list.insertatbeggining(2);
        list.insertatbeggining(1);
        list.insertatend(8);
        list.insertatposition(0,1);
        list.deletefrombeggining();
        list.deletefromposition(3);
        list.deletevalue(8);
        list.traversal();
        System.out.println("\nThe size of the linked list is : "+list.size);
        System.out.println("The head is pointing to the data :   "+ list.head.data);
        System.out.println("The tail is pointing to the data :   "+ list.tail.data);
    }
}
