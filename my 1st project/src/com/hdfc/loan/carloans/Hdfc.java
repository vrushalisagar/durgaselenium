package com.hdfc.loan.carloans;

public class Hdfc implements Rbi
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Hdfc h=new Hdfc();
              h.deposite();
              h.withdrawl();
	}

	public void withdrawl() {
		// TODO Auto-generated method stub
		System.out.println("i am overridden withdrawl in Hdfc");
		
	}

	public void deposite() {
		// TODO Auto-generated method stub
		System.out.println("i am overridden deposit in Hdfc");
		
	}

}
