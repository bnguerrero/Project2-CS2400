public class ArrayStackTest 
{
    public static void main(String[] args){
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        System.out.println(testStack.evaluatePostfix("ae+bd-/"));
        System.out.println(testStack.evaluatePostfix("abc*d*-"));
        System.out.println(testStack.evaluatePostfix("abc-/d*"));
        System.out.println(testStack.evaluatePostfix("ebca^*+d-"));

    }
  
  
}
