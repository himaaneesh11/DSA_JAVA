package Queues;

public class Implementation_of_Queue_One_Pointer {
    int [] queue;
    int rear;

    public Implementation_of_Queue_One_Pointer(int size){
        this.queue = new int[size];
        rear=-1;
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full can not insert");
            return;
        }
        queue[++rear]=value;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int removedelement=queue[0];
        for(int i=1;i<=rear;i++){
            queue[i-1]=queue[i];
        }
        rear--;
        return removedelement;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[0];
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public boolean isFull(){
        return rear == queue.length-1;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for(int i=0;i<=rear;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Implementation_of_Queue_One_Pointer obj = new Implementation_of_Queue_One_Pointer(100);
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.enqueue(40);
        obj.enqueue(50);
        obj.display();
        obj.dequeue();
        obj.dequeue();
        obj.display();
    }

}
