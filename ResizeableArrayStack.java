import java.util.EmptyStackException;

public class ResizeableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    
    public ResizeableArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }
    
    public ResizeableArrayStack(int inititalCapacity)
    {
        integrityOK = false; 
        @SuppressWarnings("unchecked")
        T[] tempStack =(T[])new Object[inititalCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }
    
    public void push(T newEntry)
    {
        stack[topIndex+1] = newEntry;
        topIndex++;
    }

    
    public T pop()
    {
        checkIntegrity();
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }
    
    public T peek()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else 
            return stack[topIndex];
    }
    
    public boolean isEmpty()
    {
        return topIndex < 0;
    }

    public void clear()
    {
        checkIntegrity();
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        }
    }

    public int evaluatePostfix(String entry){
        ResizeableArrayStack<Integer> stack1 = new ResizeableArrayStack<>();
        for(int i=0, temp; i<entry.length(); i++){
            switch(entry.charAt(i)){
                case 'a': case 'b': case 'c': case 'd': case 'e':
                    stack1.push(Character.getNumericValue(entry.charAt(i))-8);
                    break;
                case '+': 
                    stack1.push(stack1.pop() + stack1.pop());
                    break;
                case '-': 
                    temp = stack1.pop();
                    stack1.push(stack1.pop() - temp);
                    break;
                case '*': 
                    stack1.push(stack1.pop() * stack1.pop());
                    break;
                case '/': 
                    temp = stack1.pop();
                    stack1.push(stack1.pop() / temp);
                    break;
                case '^':
                    temp = stack1.pop();
                    int base = stack1.pop();
                    for(int j=1; j<temp; j++){
                        base *= base;
                    }
                    stack1.push(base);
                    break;
                default:
                    break;
            }
        }
        return stack1.peek();
    }
    private void checkIntegrity()
    {
        if(!integrityOK)
        {
            throw new SecurityException("Array Bag object is corrupt");
        }
    }
  
  
  
}
