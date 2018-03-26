/*****************************************************
* class LList
* Implements a linked list of DLLNodes, each containing String data
* new in v2: add-at-index, remove
*****************************************************/

public class LList implements List //your List interface must be in same dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    //DLLNode tmp = new DLLNode( newVal, null, _head );

    DLLNode tmp;

    if (_size == 0) {
      tmp = new DLLNode(newVal, null, null);
      _head = tmp;
      _tail = tmp;
    }
    else {
      tmp = new DLLNode(newVal, null, _head);
      _head.setPrev(tmp);
      _head = tmp;
    }

    _size++;
    return true;

    /*
    _head.setPrev(tmp);
    _head = tmp;
    if (_size == 0) {
      _tail = tmp;
    }
    _size++;
    System.out.println("\n\tHead: " + _head.toString() + "\n\tTail: " + _tail.toString());
    return true;
    */
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    DLLNode tmp;

    if (index < _size/2) {
      tmp = _head; //create alias to head

      //walk to desired node
      for( int i=0; i < index; i++ )
      tmp = tmp.getNext();
    }

    else {
      tmp = _tail; //create alias to head

      //walk to desired node
      for( int i=index; i > 0; i-- )
      tmp = tmp.getPrev();
    }

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //insert a node containing newVal at position index
  public void add( int index, String newVal ) {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode tmp;
    DLLNode newNode;

    if (index == 0) {
      add(newVal);
      return;
    }
    else if (index >= _size/2) {
      tmp = _head;
      for (int i = 0; i < index; i++) {
        tmp = tmp.getNext();
      }
    }
    else {  //index < _size/2
      tmp = _tail;
      for (int i = index; i > 1; i--) {
        tmp = tmp.getPrev();
      }
    }
    newNode = new DLLNode(newVal, tmp.getPrev(), tmp);
    tmp.getPrev().setNext(newNode);
    tmp.setPrev(newNode);

    _size++;


      /*
    DLLNode newNode = new DLLNode( newVal, null, null );

    //if index==0, insert node before head node
    if ( index == 0 )
    add( newVal );
    else {
      DLLNode temp;

      if (index < this.size()/2) {
        temp = _head;
        for ( int i = 0; i < index - 1; i++) {
          temp = temp.getNext();
        }
      }
      else {
        temp = _tail;
        for (int i = index - 1; i > 1; i-- ) {
          temp = temp.getPrev();
        }
      }

      temp.getPrev().setNext(newNode);
      newNode.setPrev(temp.getPrev());
      temp.setPrev(newNode);
      newNode.setNext(temp);

    }
      /* 	    DLLNode tmp;

      if (index < _size/2) {
      tmp = _head; //create alias to head

      //walk to desired node
      for( int i=0; i < index-1; i++ )
      tmp = tmp.getNext();
    }

    else {
    tmp = _tail; //create alias to head

    //walk to desired node
    for( int i=index-1; i > 1; i-- )
    tmp = tmp.getPrev();
  } */
  /*
  DLLNode tmp = _head; //create alias to head

  //walk to node before desired node
  for( int i=0; i < index-1; i++ )
  tmp = tmp.getNext();

  //insert new node
  newNode.setNext( tmp.getNext() );
  tmp.setNext( newNode );

  //increment size attribute
  _size++;
}
*/
}


//remove node at pos index, return its cargo
public String remove( int index ) {

  if ( index < 0 || index >= size() )
  throw new IndexOutOfBoundsException();

  String retVal;
  DLLNode tmp = _head; //create alias to head

  //if index==0, remove head node
  if ( index == 0 ) {
    //check target node's cargo hold
    retVal = _head.getCargo();

    //remove target node
    _head = _head.getNext();
  }
  else {
    //walk to node before desired node
    for( int i=0; i < index-1; i++ )
    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getNext().getCargo();

    //remove target node
    tmp.setNext( tmp.getNext().getNext() );
  }

  //decrement size attribute
  _size--;

  return retVal;
}

//--------------^  List interface methods  ^--------------


// override inherited toString
public String toString()
{
  String retStr = "HEAD->";
  DLLNode tmp = _head; //init tr
  while( tmp != null ) {
    retStr += tmp.getCargo() + "->";
    tmp = tmp.getNext();
  }
  retStr += "NULL";
  return retStr;
}


//main method for testing
public static void main( String[] args )
{

  LList james = new LList();

  System.out.println( james );
  System.out.println( "size: " + james.size() );

  james.add("beat");
  System.out.println( james );
  System.out.println( "size: " + james.size() );

  james.add("a");
  System.out.println( james );
  System.out.println( "size: " + james.size() );

  james.add("need");
  System.out.println( james );
  System.out.println( "size: " + james.size() );

  james.add("I");
  System.out.println( james );
  System.out.println( "size: " + james.size() );

  System.out.println( "2nd item is: " + james.get(1) );

  james.add(0,"whut");
  System.out.println( "...after add(0,whut): " );
  System.out.println( james );

  james.add(4,"phat");
  System.out.println( "...after add(4,phat): " );
  System.out.println( james );

  System.out.println( "...after remove last: "
  + james.remove( james._size-1) );
  System.out.println( james );

  System.out.println( "...after remove(0): " + james.remove(0) );
  System.out.println( james );

  System.out.println( "...after remove(0): " + james.remove(0) );
  System.out.println( james );

  System.out.println( "...after remove(0): " + james.remove(0) );
  System.out.println( james );
}

}//end class LList
