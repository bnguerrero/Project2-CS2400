import java.util.EmptyStackException;
//import java.lang.*;

public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; 
    private int numberOfEntries=0;

    public LinkedStack()
    {
        topNode = null;
    }

    private class Node{
        private T data;
        private Node next;
        private Node(T dataPortion){
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
        private T getData(){
            return data;
        }
        private void setData(T newData){
            data = newData;
        }
        private Node getNextNode(){
            return next;
        }
        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }

    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
        numberOfEntries++;
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
        {
            throw new EmptyStackException();
        }
        else
        {
            return topNode.getData();
        }
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
       String postfix = "";
       for(int i=0;i<infix.length();i++)
       {
           char nextCharacter = infix.charAt(i);
          
           if(nextCharacter == 'a' || nextCharacter == 'b' || nextCharacter == 'c' || nextCharacter == 'd' || nextCharacter == 'e')
           {
               postfix += nextCharacter;
           }

           else if(nextCharacter == '+' || nextCharacter == '-' || nextCharacter == '*' || nextCharacter == '/' || nextCharacter == '^')
           {
               while(!operatorStack.isEmpty() && precedenceOf(nextCharacter) <= precedenceOf(operatorStack.peek()))
               {
                   postfix += operatorStack.pop();
               }
               operatorStack.push(nextCharacter); 
           }

           else if(nextCharacter == '(') 
           {
               operatorStack.push(nextCharacter); 
           }
        
           else if(nextCharacter == ')') 
           {
               while(!operatorStack.isEmpty() && operatorStack.peek() != '(')
               {
                   postfix += operatorStack.pop();
               }
               operatorStack.pop();
           }
       }
       while(!operatorStack.isEmpty()) 
       {
           postfix += operatorStack.pop();
       }
       System.out.println(postfix.toString());
   }  
}
