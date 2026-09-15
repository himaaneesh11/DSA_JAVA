package arrays;

public class arrays_operations {
    public void traversal(int [] arr){
        int size=0,i=0;
        while(arr[i]!=0){
            size++;
            i++;
        }
        for(int j=0;j<size;j++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {

    }
}
