package MultiThread;



class YThread extends Thread
{
	public void run()
    {
        int i=1;
        
        for(int j = 0;j< 1000;j++) 
        {
        	 System.out.println(i+" Hello");
             i++;
        }
        
    }
	
}






public class ThreadTest2 
{
	
	public static void main(String[] args) 
	{
		YThread th = new YThread();
		th.start();
		
		int k=1;
		for(int g = 0; g<1000;g++) 
		{
			System.out.println(k+" World");
            k++;
		}
		
		
       
		
		
	}

}
