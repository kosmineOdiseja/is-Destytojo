import stud.Svarstykles139;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Svareliai139 {
	
	public static void main(String[] args) throws Exception {
		
		try {
																									// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
			
			System.out.println ( " ? svoris:" );
			
			String svoris_str = br.readLine ();
			
			int svoris = Integer.parseInt ( svoris_str );
		 
			System.out.println( "svoris " + svoris + "" );
			
			Svarstykles139 svarstykles139 = new Svarstykles139();
			
			svarstykles139.pasverti ( svoris );

			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}