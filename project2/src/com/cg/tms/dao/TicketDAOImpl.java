package com.cg.tms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;
import com.cg.tms.util.Util;

public class TicketDAOImpl implements TicketDAO{
int count=0;
	private static Map<String,TicketBean> ticketLog=new HashMap<String, TicketBean>();
	Util u=new Util();
	public boolean raiseNewTicket(TicketBean ticketBean) {
		// TODO Auto-generated method stub
		ticketLog.put(ticketBean.getTicketNo(),ticketBean);
		return true;
	}

	public List<TicketCategory> listTicketCategory() {
		// TODO Auto-generated method stub
		
Map<String, String> map=new HashMap<String,String>();


map=Util.getTicketCategoryEntries();
List<TicketCategory> ticketcategorylist=new ArrayList<TicketCategory>();
Set<String> keys=map.keySet();
for (String string : keys) {
	TicketCategory ticketCategory=new TicketCategory();
	ticketCategory.setTicketCategoryId(string);
	ticketCategory.setCategoryName(map.get(string));
	ticketcategorylist.add(ticketCategory);
}

	return ticketcategorylist;
	}

}
