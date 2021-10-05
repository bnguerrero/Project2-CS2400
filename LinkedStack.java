import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; 

    public LinkedStack()
    {
        topNode = null;
    }
    private class topNode
    {
        private T data; 
        private Node next:


    }

    public void push(T newEntry)
    {
        Node newNode= new Node(newEntry, topNode);
        topNode = newNode;
    }

    public T pop()
    {
        T top = peek();
        topNode = topNode.getNextNode();
        return top;
    }

    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    public boolean isEmpty()
    {
        return topNode == null;
    }

    public void clear()
    {
        topNode = null;
    }


}

