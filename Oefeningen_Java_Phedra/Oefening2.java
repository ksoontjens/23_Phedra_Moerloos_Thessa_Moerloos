/**
*
*Dit is een programma
*@author Phedra Moerloos
*
*/


public class Oefening2 {

	/**
	* Dit is de main methode
	*arg zijn parameters die met de commandline (cmd) meekomen
	*
	*/	

	public static void main ( String arg[] ) {

		weekdagen();

	}



	/*
	* Deze methode toont de dagen in februari 2009
	*
	*/
	public static void weekdagen ()
	{

	int weekdag = 0;
	String stringWeekdag = "";
	int x;

		for ( x = 1; x <= 28; x++ ) {
		

			switch( weekdag ){
			
			case 0: stringWeekdag = "zondag";
			break;

			case 1: stringWeekdag = "maandag";
			break;

			case 2: stringWeekdag = "dinsdag";
			break;

			case 3: stringWeekdag = "woensdag";
			break;

			case 4: stringWeekdag = "donderdag";
			break;

			case 5: stringWeekdag = "vrijdag";
			break;

			case 6: stringWeekdag = "zaterdag";
			break;

			default: stringWeekdag = "error";
			break;			

			}
			
			if ( weekdag > 6 ) 
			{
			
				weekdag = 0; 
				//eens je aan 7 zit maakt hij er 0 van (0 is dan terug kleiner dan 6), optellen terug

			}

			System.out.println("dag = " + x + " februari, een " + stringWeekdag);

			weekdag++;

		}
	}

}


	