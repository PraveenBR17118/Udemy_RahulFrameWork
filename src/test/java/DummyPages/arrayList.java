package DummyPages;

import java.util.ArrayList;

public class arrayList 
{
	public static void main(String[] args) 
	{
		String str = "Hi my name is praveen";
		String[] stra = str.split(" ");
		ArrayList<String> arr = new ArrayList<>();
		
		for(String dfg : stra) 
		{
			arr.add(dfg);
		}
		System.out.println(arr);
		
	}

}
