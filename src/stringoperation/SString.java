package stringoperation;

public class SString {

	static int count(String str, char prev, char prevToPrev)
	{
		if (prev==prevToPrev)	return 0;
		if (str.length() == 1)
		{
			if(str.charAt(0)<prev)	return (str.charAt(0) - 'a' + 1);
			else return (str.charAt(0) - 'a');
		}

		int res = 1;

		int firstPos = str.charAt(0) - 'a';
		if (firstPos==0) res=0;

		if(prev < str.charAt(0))	firstPos--;

		for (int i = 0; i < str.length() - 1; i++)
		{
			res *= 25;
			res=res%1009;
		}
		return (firstPos * res + count(str.substring(1), str.charAt(0), prev))%1009;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a";
		System.out.println(count(str, (char) ('z' + 1), (char)('z' + 2)));
	}

}
