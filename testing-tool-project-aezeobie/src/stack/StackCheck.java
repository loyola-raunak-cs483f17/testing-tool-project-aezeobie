package stack;

/**
 * StackCheck is a class which calls Stack and verifies that the
 * written specification is sufficient.
 */
public class StackCheck
{
	/** The main method */
	public static void main(String[] args) {
		element();
		checkConstructor();
		checkIsEmpty();
		checkIsFull();
		checkTop();
		checkPop();
	}	
	
  /**
   * Helper method to generate elements to place in the queue.
   * Stack elements are never null.
   */
  //@ ensures \result != null;
  private static Object element()
  {
    return new Object();
  }

  /**
   * Check that legal call sequences to the constructor and push throw
   * no runtime exceptions.
   **/
  public static void checkConstructor() {
	Stack stack;
    stack = new Stack(1);
    stack.push(element());
    //@ assert !stack.isEmpty(); 
    stack = new Stack(2);
    stack.push(element());
    stack.push(element());    
  }

  /**
   * Check that the isEmpty specification is correctly related to the
   * push specification.
   */
  public static void checkIsEmpty() {
    Stack s = new Stack(2);
    
    //@ assert s.isEmpty();
    if (! s.isEmpty())
      throw new RuntimeException("New stack should be empty");
    
    s.push(element());
    //@ assert !s.isEmpty();
    if (s.isEmpty())
      throw new RuntimeException("1-elt stack should not be empty");
    
    s.push(element());
    //@ assert !s.isEmpty();
    if (s.isEmpty())
      throw new RuntimeException("2-elt stack should not be empty");
  }

  /**
   * Check that the isFull specification is correctly related to the
   * push specification.
   */
  public static void checkIsFull() {
    Stack s = new Stack(2);
    
    //@ assert !s.isFull();
    if (s.isFull())
      throw new RuntimeException("New stack should not be full");
    
    s.push(element());
    if (s.isFull())
      throw new RuntimeException("1-elt stack should not be full");
    
    s.push(element());
    //@ assert s.isFull();
    if (! s.isFull())
      throw new RuntimeException("2-elt stack should be full");
  }

  /**
   * Check that top returns null iff the queue is empty.
   */
  public static void checkTop() {
    Stack stack = new Stack(2);
  
    //@ assert stack.top() == null;
    if (stack.top() != null)
      throw new RuntimeException("Top of new stack should be null");
    
    stack.push(element());
    //@ assert stack.top() != null;
    if (stack.top() == null)
      throw new RuntimeException("Top of 1-elt stack should be non-null");
    
    /* stack.printTop();
    stack.top();
    stack.printTop(); */    
  }

  /**
   * Check that legal call sequences to the constructor, push, and pop
   * throw no runtime exceptions.
   */
  public static void checkPop() {
    Stack stack = new Stack(2);
    
    stack.push(element());
    //@ requires !stack.isEmpty();
    stack.pop();
    
    stack.push(element());
    stack.push(element());
    //@ requires !stack.isEmpty();
    stack.pop();
    //@ requires !stack.isEmpty();
    stack.pop();
  }
  
}
