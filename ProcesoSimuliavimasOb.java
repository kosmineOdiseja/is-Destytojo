
import stud.Utils;
import stud.Stotele;
import stud.Automobilis;
import stud.Lentele;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesoSimuliavimasOb {
	
		public static void priskirtiStoteles ( Automobilis auto, String[] langeliai ) {
			
			System.out.println ( "stoteliu skaicius: " +  auto.stoteles.length );
			
			for( int i = 0; i < langeliai.length; i+= 2 ) {
				
				auto.stoteles [ ( int ) ( i / 2 ) ] = new Stotele ( langeliai [ i ], Double.parseDouble ( langeliai [ i + 1] ), auto.greitis_v );
			}
			
		}
		
		public static void parodytiStoteles ( Automobilis auto ) {
			
			for ( int i = 0; i < auto.num_stoteliu; i++) {
				
				System.out.println ( auto.stoteles [ i ].pav + " " + auto.stoteles [ i ].atst + "km." );
			}			
		}
		
		public static void main(String[] args) throws Exception {
	   
		String was_read = null;
		
		try {
			

			BufferedReader br = new BufferedReader( new FileReader( "proceso_simuliavimas_ob.csv" ) );
			
			System.out.println ( "duomenu failo turinys:" );
			
			was_read = br.readLine();
			System.out.println( was_read );
			String[] langeliai1 = was_read.split ( "," );
			was_read = br.readLine(); 
			System.out.println( was_read );
			String[] langeliai2 = was_read.split ( "," );			
			
			Automobilis auto1 = new Automobilis ( langeliai1 [ 0 ], Double.parseDouble ( langeliai1 [ 1 ] ), ( ( int ) ( langeliai2.length / 2 ) ) ); 
			
			priskirtiStoteles ( auto1, langeliai2 );
			
			was_read = br.readLine(); 
			System.out.println( was_read );
			langeliai1 = was_read.split ( "," );
			was_read = br.readLine(); 
			System.out.println( was_read ); 
			langeliai2 = was_read.split ( "," );			
			
			Automobilis auto2 = new Automobilis ( langeliai1 [ 0 ], Double.parseDouble ( langeliai1 [ 1 ] ), ( ( int ) ( langeliai2.length / 2 ) ) ); 
		
			priskirtiStoteles ( auto2, langeliai2 );
				
			System.out.println ( "Pradiniai duomenys : " );
			System.out.println ( "\t 1-as automobilis: " );
			System.out.println ( "\t\t " + auto1.pav + " greitis (v) : " + auto1.greitis_v );

			parodytiStoteles ( auto1 );
			
			System.out.println ();
			System.out.println ( "\t 2-as automobilis: " );
			System.out.println ( "\t\t " + auto2.pav + " greitis (v) : " + auto2.greitis_v );

			parodytiStoteles ( auto2 );			

			double t_gal_1 = auto1.stoteles [ auto1.num_stoteliu - 1 ].t_prav;				
			double t_gal_2 = auto1.stoteles [ auto1.num_stoteliu - 1 ].t_prav;
			
			double t_gal_viso = t_gal_1;
			
			if ( t_gal_1 < t_gal_2 ) {
				
				t_gal_viso = t_gal_2;
			}
			
			double dt = t_gal_viso / 19;
				
			System.out.println ();				
			System.out.println ( "Apskaiciuotos reiksmes : " );
				
			System.out.println ( "galutinis laikas t_gal_viso : " + t_gal_viso + " (" + Utils.laikas ( t_gal_viso ) + ") " );
				
			System.out.println ( "laiko zingsnis dt : " + dt  + " (" + Utils.laikas ( dt ) + ") ");
				
			String[] proceso_antr = { "|    t, sek    |", "    s1, km    |", "      stotele ( laikas )     |", "    s2, km    |", "      stotele ( laikas )     |", "      test      |" }; 
			String[] reiksmes = { "", "", "", "", "", "" };
			Lentele lent = new Lentele ( proceso_antr );
				
			lent.horizEil();
			lent.antraste();
			lent.horizEil();
				
			for (double t = 0; t < ( t_gal_viso + dt ); t += dt ) {
			
				double s1 = auto1.atstumas ( t );
				double s2 = auto2.atstumas ( t );
				
				// System.out.println (  " " + laikas ( t ) + " " + String.format ( "%5.2f", s )  );
				
				reiksmes [ 0 ] = Utils.laikas ( t );
				reiksmes [ 1 ] = String.format ( " %7.2f", s1 );
				reiksmes [ 2 ] = "";
				reiksmes [ 3 ] = String.format ( " %7.2f", s2 );
				reiksmes [ 4 ] = "";
				
				int num_stoteliu_pravaziuota = auto1.num_stoteliu_pravaziuota;
				
				if ( num_stoteliu_pravaziuota < auto2.num_stoteliu_pravaziuota ) {
					
					num_stoteliu_pravaziuota = auto2.num_stoteliu_pravaziuota;
				}
				
				reiksmes [ 5 ] = "m: " + num_stoteliu_pravaziuota + " 1: "+ auto1.num_stoteliu_pravaziuota + " 2: " + auto2.num_stoteliu_pravaziuota;
				
				if ( num_stoteliu_pravaziuota == 1 ) {
					
					
					if ( auto1.num_stoteliu_pravaziuota == 1 ) {
						
						reiksmes [ 2 ] = auto1.stoteles [  auto1.nums_stoteliu_pravaziuotu [ 0 ] ].pav + " ( " + Utils.laikas ( auto1.stoteles [ auto1.nums_stoteliu_pravaziuotu [ 0 ] ].t_prav  ) + " ) ";
					}
					
					if ( auto2.num_stoteliu_pravaziuota == 1 ) {
						
						reiksmes [ 4 ] = auto2.stoteles [ auto2.nums_stoteliu_pravaziuotu [ 0 ] ].pav + " ( " + Utils.laikas ( auto2.stoteles [ auto2.nums_stoteliu_pravaziuotu [ 0 ] ].t_prav  ) + " ) "; ;
					}					
				}
				
				lent.iLentele ( reiksmes );
			}
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}