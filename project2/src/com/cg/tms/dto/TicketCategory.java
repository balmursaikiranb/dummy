package com.cg.tms.dto;

public class TicketCategory {
	private String ticketCategoryId;
	private String categoryName;
	public TicketCategory()
	{
		
	}
	public String getTicketCategoryId() {
		return ticketCategoryId;
	}
	public void setTicketCategoryId(String ticketCategoryId) {
		this.ticketCategoryId = ticketCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "TicketCategory [ticketCategoryId=" + ticketCategoryId + ", categoryName=" + categoryName + "]";
	}
	public TicketCategory(String ticketCategoryId, String categoryName) {
		super();
		this.ticketCategoryId = ticketCategoryId;
		this.categoryName = categoryName;
	}

}
