package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;

import com.eomcs.util.Prompt;

// Bank랑 연결해야함!
public class DepositCommand implements Command {


	List<Bank> bankList;

	public DepositCommand(List<Bank> list) {
	  bankList = list;
	  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
	  try {
		 out.println("[1]입금   [2]출금  [3]종료");

		 int balance = 0;
		  int money;
		  int op = Prompt.inputInt("번호 입력 > ", out, in);

		  switch (op) {
		  case 1:
				  out.println("[ 입금  ]");

			   	  Bank bank = new Bank();
			   	  // bank.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));
			   	  bank.setMoney(Prompt.inputInt("입금액 >  ", out, in));

			       balance += money;
			    	out.println("입금 완료!");
			       out.printf("입금 후 잔액은  %d 원 입니다.\n", balance);
			  break;

		  case 2:
				  out.println("[ 출금  ]");

			   	  Bank bank = new Bank();
			   	  // bank.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));

			   	  out.print("출금액> ");
			   	  in.
			   	  out.println();
			   	  bank.setMoney(Prompt.inputInt("출금액 >  ", out, in));

			   	  if (balance - money  < 0) {
			   		  out.print("잔액이 부족합니다.\n");
			   	  } else {
			       balance -= money;
			    	out.println("출금 완료!");
			   	  }
			       out.printf("잔액은  %d 원 입니다.\n", balance);
			  break;
			  default :
				  out.println("잘못된 입력입니다.");
		  }



	  } catch (Exception e) {
		  out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
	  }
  }
}