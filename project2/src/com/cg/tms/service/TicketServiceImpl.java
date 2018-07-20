package com.cg.tms.service;

import java.util.List;

import com.cg.tms.dao.TicketDAO;
import com.cg.tms.dao.TicketDAOImpl;
import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;
import com.cg.tms.exception.TicketManagementSystemException;

public class TicketServiceImpl implements TicketService {
	TicketDAO dao=new TicketDAOImpl();
	public boolean raiseNewTicket(TicketBean ticketBean) {
		// TODO Auto-generated method stub
		int id1=(int)(Math.random()*9999+1);
		String id=String.valueOf(id1); 
		ticketBean.setTicketStatus("New");
		ticketBean.setTicketNo(id);
		return dao.raiseNewTicket(ticketBean);
	}

	public List<TicketCategory> listTicketCategory() {
		// TODO Auto-generated method stub
		return dao.listTicketCategory();
	}

	public boolean validateEntry(int ticketCategoryId) throws TicketManagementSystemException {
		// TODO Auto-generated method stub
		if((ticketCategoryId>=0)&&(ticketCategoryId<=3))
		{
			return true;
		}
		else
		{
		throw new TicketManagementSystemException("enter correct value");
		}
	}

	public void validateDescription(String description) throws TicketManagementSystemException {
		// TODO Auto-generated method stub
		if(description.equals(""))
		{
			throw new TicketManagementSystemException("please enter description");
		}
		
	}

}
