public class PracticeMethods {

public static void main(String[] args) {
		// TODO Auto-generated method stub
		
 int x = 0;
 
 x = CalFeb( 2);
		 
 System.out.println(x);

}
	
public static int CalFeb( int nDex) {
		
		if ((nDex == 0)   || (nDex ==1 )
				) {
			return 1;
			
		} else
		{ 
			return  (CalFeb (nDex - 2 ) + CalFeb(nDex -1 ));
		}
					
		
		
	}

}


