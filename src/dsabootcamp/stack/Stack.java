package dsabootcamp.stack;


public class Stack <E> {
    private E[] array;
    private int size;
    int index;


    public Stack(){

    }
@SuppressWarnings("unchecked")
    public Stack(int size){
        this.size=size;
        array= (E[]) new Object[size];
        this.index=-1;
    }

    public void push(E num){
        if(index>=size-1) throw new RuntimeException("Stack overflow ....");
        array[++index]=num;
    }
    public E peek(){
        if(isEmpty()) throw new RuntimeException("Stack is empty.....");
        return array[index];
    }
    public E pop(){
        if(index<0) throw new RuntimeException("Stack is empty.....");
        E num=array[index];
         array[index--]=null;
        return num;
    }
    public boolean isFull(){
        return index>=size-1;
    }
    public boolean isEmpty(){
        return index==-1;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isFull());

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

//        System.out.println(dsabootcamp.stack.stack.isEmpty());


    }
}