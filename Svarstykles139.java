	/**
	* stud - Programavimo Java mokymuisi skirtu pagalbiniu klasiu rinkinys
	*/
	package stud;

	public class Svarstykles139 {
		
		private int[] svareliai = { 1, 3, 9, 27 /*, 81, 243, 729 */ };
		private int[] svareliu_busenos = { -1, -1, -1, -1 /*, -1, -1, -1 */ };


		public Svarstykles139() {
			
		}
		
		public boolean svarstyklesIssilygino (int  svoris ) {
					
			int svoris_sv = 0;
			
			for ( int i = 0; i < svareliai.length; i++) {
				
				svoris_sv += svareliu_busenos [ i ] * svareliai [ i ];
			}
			boolean svarstykles_issilygino = ( svoris_sv == svoris );
			
			// System.out.println ( svoris_sv + " " ); 

			return
					svarstykles_issilygino 
				;
		}
		
		public void svareliuIsdestymas () {
			
			System.out.println ( "pirma lekstele: " );
			
			for ( int i = 0; i < svareliai.length; i++) {
				
				if ( svareliu_busenos [ i ] == -1 ) {
				
					System.out.print ( svareliai [ i ] + " " );
				}
			}
			
			System.out.println ();		

			System.out.println ( "antra lekstele: " );
			
			for ( int i = 0; i < svareliai.length; i++) {
				
				if ( svareliu_busenos [ i ] == 1 ) {
				
					System.out.print ( svareliai [ i ] + " " );
				}
			}
			System.out.println ();		
		}
		
		public void pasverti ( int svoris ) {
			
			for ( svareliu_busenos [ 0 ]  = -1; svareliu_busenos [ 0 ]  < 2; svareliu_busenos [ 0 ]++ ) {
				
				for ( svareliu_busenos [ 1 ]  = -1; svareliu_busenos [ 1 ]  < 2; svareliu_busenos [ 1 ]++ ) {

					for ( svareliu_busenos [ 2 ]  = -1; svareliu_busenos [ 2 ]  < 2; svareliu_busenos [ 2 ]++ ) {

						for ( svareliu_busenos [ 3 ]  = -1; svareliu_busenos [ 3 ]  < 2; svareliu_busenos [ 3 ]++ ) {				
				
							if ( svarstyklesIssilygino ( svoris ) ) {
				
								svareliuIsdestymas();
							}
						}
					}
				}
			}
		}
	}