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
    public int precedence(char entry){
        if(entry == '+' || entry == '-'){
            return 1;
        }
        else if(entry == '*' || entry == '/'){
            return 2;
        }
        else return 0;
    }
    public String convertToPostfix(String entry){
        LinkedStack<Character> stack1 = new LinkedStack<>();
        String result = "";
        int length = entry.length();
        for(int i=0; i<length; i++){
            switch (entry.charAt(i)){
                case 'a': case 'b': case 'c': case 'd': case 'e':
                    result += entry.charAt(i);
                    break;
                case '^':
                    stack1.push(entry.charAt(i));
                    break;
                case '+': case '-': case '/': case '*':
                    if(stack1.isEmpty()){
                        stack1.push(entry.charAt(i));
                    }
                    else if(precedence(stack1.peek()) >= precedence(entry.charAt(i))){
                        result += stack1.pop();
                        stack1.push(entry.charAt(i));
                    }
                    else{
                        stack1.push(entry.charAt(i));
                    }
                    break;
                case '(':
                    stack1.push(entry.charAt(i));
                    break;
                case ')':
                    char topOperator = stack1.pop();
                    while(topOperator != '('){
                        result += topOperator;
                        topOperator = stack1.pop();
                    }
                    break;
                default: break;
                        
            }
        }
        while(!stack1.isEmpty()){
            result += stack1.pop();
        }
        return result;
    }
}
