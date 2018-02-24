import java.util.HashMap;

class Employee
{
	String name;
	int id;
	public Employee(String name,int id)
	{
		this.name=name;
		this.id=id;
	}
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
}
public class CheckHashMap {
public static void main(String args[])
{
	Employee emp1=new Employee("a",1);
	Employee emp2=new Employee("b",2);
	Employee emp3=new Employee("c",3);
	Employee emp4=new Employee("d",4);
	HashMap hm=new HashMap();
	hm.put(emp1, emp1);
	hm.put(emp1, emp2);
	hm.put(emp1, emp3);	
	System.out.println("size of hashmap :"+hm.size());
	System.out.println("emp4 :"+hm.get(emp4));
	
}
}
