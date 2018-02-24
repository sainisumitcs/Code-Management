class Test
{
	
	
	public int display()
	{
		int a=4;
		try
		{
			return a;
		}
		catch(Exception ex)
		{
			
		}
		finally
		{
			a=5;
			System.out.println("value of a "+a);
			

		}
		return a;
	}
	
}
public class CheckFinally {
public static void main(String args[])
{
	Test t=new Test();
	System.out.println(t.display());
}
}
