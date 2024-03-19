package oops;

public class ChildBankLoan extends BankLoan{
	
	//encapsulation example
	
	public static void main(String[] args) {
		ChildBankLoan cb = new ChildBankLoan();
		
		cb.setAge(12);
		cb.setAmount(1000);
		cb.setName("Abc");
		
		System.out.println(cb.getAge());
		System.out.println(cb.getAmount());
		System.out.println(cb.getName());
		
	}

}
