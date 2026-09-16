public class stackusingarray {
    int [] stackarray;
    int top;
    int maxsize;
    stackusingarray(int n){
        this.maxsize=n;
        stackarray=new int[maxsize];
        top=-1;
    }

    public boolean isFull(){
        if(top==maxsize-1){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    public void push(int x){
       if(isFull()){
           System.out.println("Stack is full cannot push an element");
           return;
       }
       stackarray[++top]=x;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty cannot pop an element");
            return -1;
        }
        int element=stackarray[top];
        stackarray[top]=0;
        top--;
        return element;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty cannot peek an element");
            return -1;
        }
        return stackarray[top];
    }

    public void traversal(int [] arr){
        if(isEmpty()){
            System.out.println("Stack is empty cannot traversal an element");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.println(""+arr[i]);

        }
    }

    public void resize(){
        maxsize=maxsize*2;
        int [] newarray=new int [maxsize];
        for(int i=0;i<=top;i++){
            newarray[i]=stackarray[i];
        }
        stackarray=newarray;

    }

    public static void main(String[] args) {
        stackusingarray stack = new stackusingarray(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("The top element is : "+stack.peek());
        stack.traversal(stack.stackarray);
    }
}
