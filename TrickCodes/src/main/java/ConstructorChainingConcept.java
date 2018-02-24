class FirstConstructor
{
	public FirstConstructor()
	{
		System.out.println("after calling super");
		AA();
		BB();
	}
	public void AA()
	{
		System.out.println("FirstConstructor AA :");
	}
	public static void BB()
	{
		System.out.println("FirstConstructor BB :");
	}
}
class SecondConstructor extends FirstConstructor
{
	public SecondConstructor()
	{
		super();
		System.out.println("SecondConstructor  calling super");
		AA();
		BB();
	}
	
	public void AA()
	{
		System.out.println("SecondConstructor AA :");
	}
	public static void BB()
	{
		System.out.println("SecondConstructor BB :");
	}
}
public class ConstructorChainingConcept {
public static void main(String args[])
{
	FirstConstructor fc=new SecondConstructor();
}
}
