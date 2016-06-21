/**
*
*Dit is een programma
*@author Phedra Moerloos
*
*/


public class Oefening6 {

	/**
	* Dit is de main methode
	*arg zijn parameters die met de commandline (cmd) meekomen
	*
	*/	

	
	public static int plaats = 0;
	public static int a[] = {12,34,56,78,123,234,99,88};
	public static int b[] = new int[8];
	

	public static void main ( String arg[] ) {
		
		GrootsteGetal(a);
		VulArrayB();

	}



	/**
	* Deze methode berekent alle priemgetalln van 3 tot en met 99.
	*
	*/
	public static int GrootsteGetal(int[] arrayNaam)
	{
		
		int grootsteGetal = 0;
		int i = 0;

		for( i = 0; i < a.length; i++ ) {

			if( a[i] > grootsteGetal ) {

				grootsteGetal = a[i];
				plaats = i;

			}	

		}
	
		return grootsteGetal;

	}



	public static void VulArrayB()
	{

		int i = 0;
		int grootste = 0;
		
		for( i = 0; i < a.length; i++ ){

			grootste = GrootsteGetal(a);
			b[i] = grootste;
			System.out.println(b[i]);
			a[plaats] = 0;

		}

	}




}


	