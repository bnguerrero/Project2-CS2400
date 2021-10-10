public class LinkedStackTest
{
    public static void main(String[] args) 
    {
        StackInterface<String>  testStack = new LinkedStack<>();
        System.out.println(testStack.convertToPostfix("a*b/(c-a)+d*e"));
    }
}

