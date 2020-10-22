package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import com.eomcs.pms.domain.Bank;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BankWithDrawcommand implements Command {

  List<Bank> bankList;

  public BankWithDrawcommand(List<Bank> list) {
    this.bankList = list;
  }
  Scanner scanner = new Scanner(System.in);
  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[계좌 출금]");
      int no = Prompt.inputInt("출금할 번호? ", out, in);
      Bank bank = findByNo(no);

      if (bank == null) {
        out.println("해당 번호의 계좌가 없습니다.");
        return;
      }

      int balance = Prompt.inputInt(
          String.format("출금할 돈(%s)? ", bank.getBalance()), out, in);

      String response = Prompt.inputString("정말 출금하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("출금을 취소하였습니다.");
        return;
      }
      int oldmoney;
     oldmoney = bank.getBalance(); 
     //+=
     bank.setBalance(oldmoney-balance);
     
      out.println("출금 되었습니다.");
      out.printf("출금 후 잔액은  %d 원 입니다.\n", balance);

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private Bank findByNo(int no) {
    for (int i = 0; i < bankList.size(); i++) {
      Bank bank = bankList.get(i);
      if (bank.getNo() == no) {
        return bank;
      }
    }
    return null;
  }
}