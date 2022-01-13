package com.hdfc.loan.carloans;

public class ICICI implements Rbi
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICICI i=new ICICI ();
			
		        i.withdrawl();
		        i.deposite();

	}

	public void withdrawl() {
		// TODO Auto-generated method stub
		System.out.println("i am overridden withdrawl in ICICI");
		
		
	}

	public void deposite() {
		// TODO Auto-generated method stub
		System.out.println("i am overridden withdrawl in ICICI");
		
		
	}

}
