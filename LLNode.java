/*****************************************************
* class LLNode
* Implements a node, for use in lists and other container classes.
* Stores its data as a String
*****************************************************/

public class LLNode<T>
{
  //instance vars
  private T _cargo;    //cargo may only be of type String
  private LLNode<T> _nextNode; //pointer to next LLNode

  // constructor -- initializes instance vars
  public LLNode( T value, LLNode next ) {
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo() { return _cargo; }

  public LLNode getNext() { return _nextNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo ) {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public T setNext( LLNode newNext ) {
    LLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString() { return _cargo.toString(); }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode<String>( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );

    /* A naive list traversal, has side effects.... ??
    while( first != null ) {
    System.out.println( first );
    first = first.getNext();
  }
  */

  //Q: when head ptr moves to next node in list, what happens to the node it just left?

  //...so better: ?
  //
  //
  //

}//end main

}//end class LLNode
