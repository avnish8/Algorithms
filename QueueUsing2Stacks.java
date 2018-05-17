import java.util.*;

public class QueueUsing2Stacks {

    private static class MyQueue<Type>{
        //foo for enqueue
        Stack<Type> fooStack = new Stack<>();
        //bar for dequeue
        Stack<Type> barStack = new Stack<>();

        private void enqueue(Type i){
            fooStack.push(i);
        }

        private Type dequeue(){
            if (!barStack.isEmpty()) return barStack.pop();
            else {
                while (!fooStack.isEmpty())
                    barStack.push(fooStack.pop());
                return barStack.pop();
            }
        }

        private Type peek(){
            if (!barStack.isEmpty()) return barStack.peek();
            else{
                while (!fooStack.isEmpty())
                    barStack.push(fooStack.pop());
                return barStack.peek();
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
