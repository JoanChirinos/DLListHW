/*
  Team SushiWithCheeriosAndASideOfAaron
  Joan Chirinos, Aaron Li, and Shruthi Venkata
  APCS2 pd08
  HW24 -- On the DLL
  2018-03-26
*/

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode<T>
{
  private T _cargo;    //cargo may only be of type String
  private DLLNode<T> _nextNode, _prevNode; //pointers to next, prev DLLNodes

  public DLLNode(T carg, DLLNode<T> prev, DLLNode<T> next) {
       this._cargo = carg;
       this._nextNode = next;
       this._prevNode = prev;
 }

 //--------------v  ACCESSORS  v--------------

 public T getCargo() {
      return _cargo;
}

public DLLNode<T> getNext() {
     return _nextNode;
}

public DLLNode<T> getPrev() {
     return _prevNode;
}

 //--------------^  ACCESSORS  ^--------------

 //--------------v  MUTATORS  v--------------
 public T setCargo(T inp) {
      T orig = _cargo;
      _cargo = inp;
      return orig;
}

public DLLNode<T> setNext(DLLNode<T> inp) {
     DLLNode<T> orig = _nextNode;
     this._nextNode = inp;
     return orig;
}

public DLLNode<T> setPrev(DLLNode<T> inp) {
     DLLNode<T> orig = _prevNode;
     _prevNode = inp;
     return orig;
}
 //--------------^  MUTATORS  ^--------------

public String toString() {
     return _cargo.toString() + " <-> " + _nextNode;
}

public static void main(String[] args) {
     //PROTIP: try creating a few nodes: traversible, connected...
     //note anything notable as you develop and test...
     DLLNode test1 = new DLLNode("Testing", null, null);
     System.out.println(test1);
     DLLNode test2 = new DLLNode("testing another link", test1, null);
     test1.setNext(test2);
     test2.setPrev(test1);
     System.out.println(test1);
     DLLNode test3 = new DLLNode("continuing the link", test2, null);
     test2.setNext(test3);
     test3.setPrev(test2);
     System.out.println(test1);
}
}//end class DLLNode
