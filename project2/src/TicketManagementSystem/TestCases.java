package TicketManagementSystem;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.tms.dao.TicketDAO;
import com.cg.tms.dao.TicketDAOImpl;
import com.cg.tms.dto.TicketBean;

public class TestCases {
  TicketDAO dao=new TicketDAOImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	 
	}
public void whenNoInput()
{
	TicketBean ticket=new TicketBean();
	boolean value=dao.raiseNewTicket(ticket);
	assertNotNull(value);
}	
}
