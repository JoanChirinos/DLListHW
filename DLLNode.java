/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode
{
  private String _cargo;    //cargo may only be of type String
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

  //YOUR IMPLEMENTATION HERE...
  public LLNode(String val, LLNode next, LLNode prev) {
    _cargo = val;
    _nextNode = next;
    _prevNode = prev;
  }

  public String getCargo() {
    return _cargo;
  }

  public LLNode getNext() {
    return _nextNode;
  }

  public LLNode getPrev() {
    return _prevNode;
  }

  public String setCargo(String newCargo) {
    String old = this.getCargo();
    _cargo = newCargo;
    return old;
  }

  public LLNode setNext(LLNode newNext) {
    LLNode old = this.getNext();
    _nextNode = newNext;
    return old;
  }

  public LLNode setPrev(LLNode newPrev) {
    LLNode old = this.getPrev();
    _prevNode = newPrev;
    return old;
  }

  public String toString() {
    return _cargo.toString();
  }

  public static void main(String[] args) {
    
  }

}//end class DLLNode
