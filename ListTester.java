/*****************************************************
 * class ListTester
 * ...for putting your LList through its paces
 * Assumes local version of List.java (interface),
 *  overriding List interface from standard Java library
 *****************************************************/

public class ListTester
{
  public static void main( String[] args )
  {
    //instantiate... var type List, obj type LList
    List<String> wu = new LList<String>();

    System.out.println();
    System.out.println(wu);
    wu.add("RZA");

    System.out.println();
    System.out.println(wu);
    wu.add("GZA");

    System.out.println();
    System.out.println(wu);
    wu.add("ODB");

    System.out.println();
    System.out.println(wu);
    wu.add("Inspectah Deck");

    System.out.println();
    System.out.println(wu);
    wu.add("Raekwon the Chef");

    System.out.println();
    System.out.println(wu);
    wu.add("U-God");

    System.out.println();
    System.out.println(wu);
    wu.add("Ghostface");

    System.out.println();
    System.out.println(wu);
    wu.add("Method Man");

    System.out.println();
    System.out.println(wu);

    for( int i=0; i<7; i++ ) {
	    int n = (int)( wu.size() * Math.random() );
	    System.out.println("\nadding a poser at index " + n + "...");
	    wu.add( n, "@" );
	    System.out.println("\tUpdated list: " + wu);
    }

    while( wu.size() > 0 ) {
	    int n = (int)( wu.size() * Math.random() );
	    System.out.println("\ndeleting node "+ n + "...");
	    wu.remove(n);
	    System.out.println("\tUpdated list: " + wu);
    }
  }

}//end class
