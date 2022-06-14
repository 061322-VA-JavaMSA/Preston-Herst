public class randomNum{
	
	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]);
		String s = args[1];
		
		int i = 1;
		while(i <= x) {
			System.out.println(s);
		}
	}
}