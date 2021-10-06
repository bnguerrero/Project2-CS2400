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
    
    public String convertToPostfix(String infix)
    {
        StackInterface<T> operatorsStack = new ResizeableArrayStack<T>();
        String postfix; 

        while (infix.length() != 0)
        {
            for (int i=0; i<infix.length(); i++)
            {
                char nextCharacter = infix.charAt(i);
                switch (nextCharacter)
                {
                    case 

                    case '^':
                        operatorsStack.push(nextCharacter);


                }

            }

        }
    }
  
  
  
}
