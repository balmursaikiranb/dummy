package com.cg.tms.dao;

import java.util.List;

import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;

public interface TicketDAO {
	boolean raiseNewTicket(TicketBean ticketBean);
	List<TicketCategory> listTicketCategory();

}
