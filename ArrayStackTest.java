import java.util.EmptyStackException;

public class ArrayStackTest 
{
    public static void main(String[] args){
        try{
            ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
            System.out.println(testStack.evaluatePostfix("ae+bd-/"));
            System.out.println(testStack.evaluatePostfix("abc*d*-"));
            System.out.println(testStack.evaluatePostfix("abc-/d*"));
            System.out.println(testStack.evaluatePostfix("ebca^*+d-"));
            System.out.println(testStack.evaluatePostfix("ab*ca-/de*+"));
        }
        catch(IllegalStateException ex){
            System.out.println(ex.getMessage());
        }
        catch(SecurityException ex){
            System.out.println(ex.getMessage());
        }
        catch(EmptyStackException ex){
            System.out.println("Empty stack");
        }

    }
  
  
}
