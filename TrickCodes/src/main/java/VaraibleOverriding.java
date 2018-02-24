class FirstVariable
{
	int a=10;
	public int get()
	{
		return a;
	}
}
class SecondVariable extends FirstVariable
{
	int a=20;
	public int get()
	{
		return a;
	}
}
public class VaraibleOverriding {
public static void main(String args[])
{
	FirstVariable fv=new SecondVariable();
	System.out.println("a value :"+fv.a);
	System.out.println("method value :"+fv.get());
}
}
