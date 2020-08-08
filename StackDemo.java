import java.util.Stack;
public class StackDemo
{
	/*
	About Stack:
	 - lifo(last in first out)
	 - fifo(first in first out)
	 - push() method adds
	 - pop() method removes
	 - peek() metjod is similar to get()
	 - empty() check if stack is empty
	 - size() used to determine stack size
	 - remove() remove valuesfrom stack
	*/
        public static void main(String args[])
        {
                // Create a new, empty stack
                Stack<Integer> lifo = new Stack<Integer>();
                Stack<Integer> binaryStack = new Stack<Integer>();

                // Let's add some items to it
                for (int i = 1; i <= 10; i++)
                {
                        lifo.push(i);
                }

                // Last in first out means reverse order

               System.out.println("The size of the Stack is "+lifo.size()+".");

               while (!lifo.empty())
                {
                        System.out.print ( lifo.pop() );
                        if(!lifo.empty())
                        	System.out.print ( ',' );
                        else System.out.println();
                }

                while(idk)
                {
				}
        }
}