import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Raketa_Mokytojo {


	public static void main (String[] args) throws Exception { //

		String thisLine = null;
		
		try {

			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

			System.out.println (" ? v: " );

			String v_str = br.readLine ();

			double v = Double.parseDouble ( v_str )  ;
			
			System.out.println("v: " + v +" m /s");		

			System.out.println( " ? laiko_zingsnis (dt):" );

			String dt_str = br.readLine ();
			
			double dt = Double.parseDouble ( dt_str )  ;
			
			System.out.println( "laiko zingsnis (dt): " + dt + " s" );

			String t_gal_str = br.readLine ();
			
			double t_gal = Double.parseDouble ( t_gal_str )  ;
			
			System.out.println( "skaiciuoti iki (t_gal) : " + t_gal + " s" );			
			
			System.out.println();
			System.out.println( " t  aukstis s" );
			
			double g = 10;
			
			double t = 0;
			
			double kelias = 0;
			
			double s_ankst = 0;
			double max_aukstis = 0;

			while (  t < t_gal )  {
				
				double s = v * t - ( g * t * t ) / 2;
				kelias = s;
				
				if ( s > max_aukstis ) {
				
					max_aukstis = s;
				}
				
				if ( s <= s_ankst ) {
					
					kelias = max_aukstis + max_aukstis - s;
				}
				
				System.out.println ( String.format ( "%5.2f %8.2f %8.2f",  t, s, kelias ) );
				
				s_ankst = s;
				t += dt;
			}
			
			double D = v * v;
			
			double t1 =  ( (-v) - Math.sqrt(D) ) / (-g);

			
				System.out.println (" isvestas laikas yra : " + t1);
				
				
		} catch (Exception e) {


			e.printStackTrace();

		}
	}
}
