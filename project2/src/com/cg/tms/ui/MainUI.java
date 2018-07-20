package com.cg.tms.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;
import com.cg.tms.exception.ITicketManagementSystemException;
import com.cg.tms.exception.TicketManagementSystemException;
import com.cg.tms.service.TicketService;
import com.cg.tms.service.TicketServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketService service=new TicketServiceImpl();
		int choice = 0;
String categoryName;
String priorityIs;
boolean check=false;
		boolean error = false;
		boolean error1 = false;
		//double rechargeAmount;
		String ch;
		do {
			System.out.println(
					"     //------------------------   Ticket Management System --------------------------");
			System.out.println(
					"/*******************************************************************************************************");
			System.out.println("1. Raise a Ticket");
			System.out.println("2. Exit from the system");
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("enter The choice:");
			choice = scanner1.nextInt();
			switch (choice) {
			case 1:
				Scanner scanner=new Scanner(System.in);
				System.out.println("Enter the description related to issue:");
				String description = scanner.nextLine();
				try{
					service.validateDescription(description);
				}catch(TicketManagementSystemException e){
					System.out.println(e.getMessage());
				}
				List<TicketCategory> category=service.listTicketCategory();
				
				for (TicketCategory string : category) {
				
					System.out.println(string.getCategoryName());
					
				}
				
				System.out.println("Enter the option");
				int ticketCategoryId = scanner.nextInt();
				try {
					check=service.validateEntry(ticketCategoryId);
				} catch (TicketManagementSystemException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				if(check)
				{
				if(ticketCategoryId==1)
				{
					categoryName="Software Installation";
				}
				else if(ticketCategoryId==2)
				{
					categoryName="Mailbox creation";
				}
				else {
					categoryName="network issues";
				}
				
				System.out.println("Enter priority(1.low 2.medium 3.high):");
				int priority = scanner.nextInt();
				try {
					check=service.validateEntry(ticketCategoryId);
				} catch (TicketManagementSystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(check)
				{
				if(ticketCategoryId==1)
				{
					 priorityIs="low";
				}
				else if(ticketCategoryId==2)
				{
					 priorityIs="medium";
				}
				else {
					 priorityIs="high";
				}
				
				
				TicketBean ticketBean=new TicketBean();
				ticketBean.setTicketCategoryId(categoryName);
				ticketBean.setTicketDescription(description);
				ticketBean.setTicketPriority(priorityIs);
				boolean result=service.raiseNewTicket(ticketBean);
				if(result){
				LocalDateTime date1=LocalDateTime.now();
				System.out.println("Ticket Number "+ticketBean.getTicketNo()+" logged Successfully at "+date1);
				}else{
					System.out.println("unsuccessful");
				}
				}
				else {
					System.out.println("enter correct value");
				}
				}
				else
				{
					System.out.println("enter correct value");
				}
				break;

			case 2:
				System.out.println("Thank You for Using Our Application");
				System.exit(0);

				break;
			default:
				System.out.println("enter correct value");

			}
			System.out.println("enter y or yes to continue and n or no to exit");
			ch = scanner1.next();
		} while ((ch.equalsIgnoreCase("y")) || ch.equalsIgnoreCase("yes"));

	}

}
