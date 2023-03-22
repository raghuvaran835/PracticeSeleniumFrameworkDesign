package JavaProblemSolving;

public class PalindromeString {
	
	public String reverse(String input)
	{
		if(input == null || input.isEmpty())
		{
			return input;
		}
		return input.charAt(input.length()-1)+reverse(input.substring(0,input.length()-1));
	}
	
	public String reverse1(String input)
	{
		
		StringBuilder sb=new StringBuilder(input.length());	
		
		for(int i=input.length()-1;i>=0;i--)
		{
			sb.append(input.charAt(i));
		}
		System.out.println(sb);
		return sb.toString();
	
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PalindromeString obj=new PalindromeString();
		
		System.out.println(obj.reverse1("Raghuvaran"));
		
		String name="rag,hu,var-an";
		String[] a=name.split(",");
		
		String newname=String.join("-", a);
		System.out.println(newname);
		
		int i=0;
		
		System.out.println(i);
	
	}

}
