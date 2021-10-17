public class LinkedStackTest
{
    public static void main(String[] args) 
    {
        StackInterface<String> testStack = new LinkedStack<>();

        System.out.println("the postfix of a*b/(c-a)+d*e is: ");
        testStack.convertToPostfix("a*b/(c-a)+d*e");

        System.out.println("the postfix of a-b+c is: ");
        testStack.convertToPostfix("a-b+c");

        System.out.println("the postfix of a+b is: ");
        testStack.convertToPostfix("a+b");

        System.out.println("the postfix of (a+b)*c is: ");
        testStack.convertToPostfix("(a+b)*c");

        System.out.println("the postfix of a+b*c is: ");
        testStack.convertToPostfix("a+b*c");
    }
}

