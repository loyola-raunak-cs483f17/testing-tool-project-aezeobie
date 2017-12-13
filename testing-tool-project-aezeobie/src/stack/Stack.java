package stack;
/**
 * Array-based implementation of the stack.
 */
public class Stack
{
    private /*@ spec_public @*/ Object [ ] theArray;
    //@ public invariant theArray.length >= 0;
    private /*@ spec_public @*/ int topOfStack;

    /**
     * Construct the stack.
     */
    /*@ requires capacity >= 1;
      @ assignable theArray;
      @ ensures theArray.length == capacity && topOfStack == -1; @*/
    public Stack( int capacity )
    {
        theArray = new Object[ capacity ];
        topOfStack = -1;
    }

    /**
     * Test if the stack is logically empty.
     */
    //@ requires topOfStack >= -1;
    //@ ensures topOfStack == \old(topOfStack);
    /*@ pure */
    public boolean isEmpty( )
    {
        return topOfStack == -1;
    }

    /**
     * Test if the stack is logically full.
     */
    //@ requires topOfStack >= -1 && topOfStack <= theArray.length -1;
    //@ ensures topOfStack == \old(topOfStack);
    /*@ pure */
    public boolean isFull( )
    {
        return topOfStack == theArray.length - 1;
    }

    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     */
    //@ requires topOfStack >= -1 && topOfStack <= theArray.length -1;
    //@ ensures topOfStack == \old(topOfStack);   
    /*@ pure */
    public Object top( )
    {
        if( isEmpty( ) )
            return null;
        return theArray[ topOfStack ];
    }

    /**
     * Remove the most recently inserted item from the stack.
     */
    /*@ requires theArray.length > 0;
      @ assignable theArray;
      @ ensures topOfStack == \old(topOfStack) - 1; @*/
    public void pop( )
    {
        theArray[ topOfStack-- ] = null;
    }

    /**
     * Insert a new item into the stack, if not already full.
     */
    /*@ requires !isFull();
      @ assignable theArray;
      @ ensures topOfStack == \old (topOfStack) + 1 && top() == x; @*/
    public void push( Object x )
    {
        theArray[ ++topOfStack] = x;
    }
    
   /* public void printTop() {
    	System.out.println("Top of Stack: " + topOfStack);
    }  */
}
