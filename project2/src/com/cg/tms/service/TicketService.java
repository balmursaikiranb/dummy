package com.cg.tms.service;



import java.util.List;

import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;
import com.cg.tms.exception.TicketManagementSystemException;

public interface TicketService {
	boolean raiseNewTicket(TicketBean ticketBean);
	List<TicketCategory> listTicketCategory();
	boolean validateEntry(int ticketCategoryId) throws TicketManagementSystemException;
	void validateDescription(String description) throws TicketManagementSystemException;

}
