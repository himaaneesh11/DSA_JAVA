package Queues;

public class Implementation_of_Queue_Arrays {
    //Using two pointer approach
    public class ArrayQueue{
        int [] queue;
        int front;
        int rear;
        int size;
        public ArrayQueue(int size){
            this.size = size;
            this.queue = new int[size];
            front = -1;
            rear = -1;
        }

        public void enqueue(int value){
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            queue[rear] = value;
            if(front == -1){
                front++;
            }
        }

        public int dequeue(){
            if(rear == size-1){
                System.out.println("Queue is full");
                return -1;
            }
            if(front == rear){
                int removedelement=queue[front];
                front=-1;
                rear=-1;
                return removedelement;
            }
            int removedelement=queue[front];
            front++;
            return removedelement;
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
            for(int i=front;i<=rear;i++){
                System.out.print(queue[i]+" ");
            }
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return queue[front];
        }
    }

    public static void main(String[] args) {



    }
}
