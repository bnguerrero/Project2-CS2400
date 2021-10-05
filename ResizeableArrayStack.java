public class ResizeableArrayStack implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayStack(int inititalCapacity)
    {
        integrityOK = false; 
        checkCapacity(inititalCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack =(T[])new Object[inititalCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }
    
    public void push(t newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex+1] = newEntry;
        topIndex++;
    }

    private void ensureCapacity()
    {
        if (topIndex >= stack.length-1)
        {
            int newLength = 2* stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
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
  
  
  
}
