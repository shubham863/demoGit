package TaskEase;

public class TesserectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String result = "string one is, undefined.";
		 String[] words = result.split("[\\s,\\.]");

		 for(String s:words) {
			 System.out.println(s+" ");
		 }

	}

}
