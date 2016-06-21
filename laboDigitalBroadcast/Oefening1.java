/**
*
*Dit is een programma
*@author Phedra Moerloos
*
*/


public class Oefening1 {

	/**
	* Dit is de main methode
	*arg zijn parameters die met de commandline (cmd) meekomen
	*
	*/	

	public static void main ( String arg[] ) {

		tafels();

	}



	/*
	* Deze methode toont de tafels van 1 tot en met 9
	*
	*/
	public static void tafels ()
	{

	int x;
	int y;
	int z;
		for ( x = 1; x <= 9; x++ ) {
		

			for ( y = 1; y <= 9; y++) {
				
				z = x*y;
				System.out.println( x + " x " + y + " = " + z );				

			}

		}
	}

}


	