import java.util.EmptyStackException;
import java.lang.*;

public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; // = firstNode

    public LinkedStack()
    {
        topNode = null;
    }

    private class Node
	{
	   private T data; 
	   private Node next; 

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} 

        private T getData()
        {
            return data;
        }
        
        private Node getNextNode()
        {
            return next;
        }

	} 
    //getData, setData, getNextNode, setNextNode

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

    public int precedenceOf(char character)
    {
        switch (character)
        {
            case '(': case ')':
            {
                return 0;
            }
            case '+': case '-':
            {
                return 1;
            }
            case '*': case '/':
            {
                return 2;
            }
            case '^':
            {
                return 3;
            }
        }
        return -1;
    }

    public void convertToPostfix(String infix)
    {
        StackInterface<Character> operatorStack = new LinkedStack<>();
        StringBuilder postfix = new StringBuilder(""); 

        while (infix.length() != 0)
        {
            for (int i=0; i<infix.length(); i++)
            {
                char nextCharacter = infix.charAt(i);

                switch (nextCharacter)
                {
                    case 'a': case 'b': case 'c': case 'd': case 'e':
                    {
                        postfix.append(nextCharacter);
                    }

                    case '^':
                    {
                        operatorStack.push(nextCharacter);
                    }

                    case '+': case '-': case '*': case'/':
                    {
                        while ((!operatorStack.isEmpty())&& (precedenceOf(nextCharacter) <= precedenceOf(operatorStack.peek())))
                        {
                            postfix.append(operatorStack.peek());
                            operatorStack.pop();
                        }
                        operatorStack.push(nextCharacter);
                        break;
                    }
                    
                    case '(':
                    {
                        operatorStack.push(nextCharacter);
                        break;
                    }

                    case ')':
                    {
                        char topOperator = operatorStack.pop();
                        while (topOperator != '(')
                        {
                            postfix.append(topOperator);
                            topOperator = operatorStack.pop();
                        }
                        break;
                    }
                }
            }
        }

        while (!operatorStack.isEmpty())
        {
            char topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }
    }
}
