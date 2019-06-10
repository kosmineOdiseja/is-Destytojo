	// package demo;

	import stud.Lentele;
	import stud.DuomenuKitimoLenteleX;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BurbuliukasDkl {
	
	public static  void parodyti ( double[] skaiciai, int kiek ) {
		
		for ( int i = 0; i < kiek;  i++ )  {
		
			System.out.print ( " " + skaiciai [ i ] );
		}
		System.out.println ();
	}
	
	public static void main(String[] args) throws Exception {
	   
		String thisLine = null;
		String[] duom_keit_lent = { "| kodo eil |", " f_b_s |", " ? f_b_s |", "   i |", " kiekis - 1 |",  " i < kiekis - 1 |",  " sk [ i ] |", " sk [ i + 1 ] |", " ? sk [ i ] < sk [ i + 1 ] |", " tarp |" };
		int cmd;
		
		try {
																									// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader( new FileReader( "skaiciai_netvarkingi.csv" ) );
			
			System.out.println ( "duomenu failo turinys:" );
			
			double[] skaiciai = new double[1000];
			int kiekis = 0;
		 
			while ( ( thisLine = br.readLine() ) != null ) {
			 
				
				System.out.println( thisLine );
				String[] skaiciu_strs = thisLine.split ( "," );
				
				
				for ( int i=0; i < skaiciu_strs .length; i++ ) {
				
					skaiciai [ kiekis ] = 
					
						Double.parseDouble (  skaiciu_strs [ i ] );
					kiekis++;
				}
			} 
			System.out.println( "Nuskaityta " + kiekis + " skaiciu: " );
			parodyti ( skaiciai, kiekis );
			
			if ( kiekis > 0 ) {
				
				DuomenuKitimoLenteleX dklx = new DuomenuKitimoLenteleX ( duom_keit_lent );
				dklx.horizEil();
				dklx.antraste();
				dklx.horizEil();
			
				boolean flag_buvo_sukeitimu = true; 											dklx.iLentele ( 62, " f_b_s |",  dklx.bool2Str ( flag_buvo_sukeitimu ) );

				while ( flag_buvo_sukeitimu ) {													dklx.iLentele ( 64, " ? f_b_s |", ( flag_buvo_sukeitimu ? "T" : "N" ) );
					
					flag_buvo_sukeitimu = false;												dklx.iLentele ( 66, " f_b_s |", ( flag_buvo_sukeitimu ? "T" : "N" ) );												
				
					for  ( int i = 0; i < kiekis - 1; i ++ ) {										dklx.iLentele ( 68, "   i |", i + "" ); dklx.iLentele ( 68, " kiekis - 1 |", ( kiekis -1 ) + "" ); dklx.iLentele ( 68, " i < kiekis - 1 |", dklx.bool2Str ( ( i < kiekis - 1 ) ) );
																						dklx.iLentele ( 69, " sk [ i ] |", skaiciai [ i ] + " " ); dklx.iLentele ( 69, " sk [ i + 1 ] |", skaiciai [ i + 1 ] + " " );
						if ( skaiciai [ i ] < skaiciai [ i + 1 ] ) { 									dklx.iLentele ( 70, " ? sk [ i ] < sk [ i + 1 ] |", dklx.bool2Str ( ( skaiciai [ i ] < skaiciai [ i + 1 ] ) ) );
							
							double tarp = skaiciai [ i ];										dklx.iLentele ( 72, " tarp |", tarp + " " );
							skaiciai [ i ] = skaiciai [ i  + 1 ];										dklx.iLentele ( 73, " sk [ i ] |", skaiciai [ i ] + " " );
							skaiciai [ i +1 ] = tarp;											dklx.iLentele ( 74, " sk [ i ] |", skaiciai [ i ] + " " );
							flag_buvo_sukeitimu = true;										dklx.iLentele ( 75, " f_b_s |", ( flag_buvo_sukeitimu ? "T" : "N" ) );										
						}
						cmd = System.in.read();
						dklx.horizEil();
						dklx.antraste();
						dklx.horizEil();
					}
					// System.out.println ( "iskelimas: " );
					// parodyti ( skaiciai, kiekis);
					cmd = System.in.read();
					dklx.horizEil();
					dklx.antraste();
					dklx.horizEil();
				}
				dklx.horizEil();
				
				System.out.println ( "Surikiuoti skaiciai: " );
				
				parodyti ( skaiciai, kiekis );
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}