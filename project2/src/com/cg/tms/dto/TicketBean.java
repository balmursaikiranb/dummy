package com.cg.tms.dto;

public class TicketBean {
	private String ticketNo;
	private String ticketCategoryId;
		private String ticketDescription;
		private String ticketPriority;
		private String ticketStatus;
		private String itimdComments;
		public TicketBean()
		{
			
		}
		public TicketBean(String ticketNo, String ticketCategoryId, String ticketDescription, String ticketPriority,
				String ticketStatus, String itimdComments) {
			super();
			this.ticketNo = ticketNo;
			this.ticketCategoryId = ticketCategoryId;
			this.ticketDescription = ticketDescription;
			this.ticketPriority = ticketPriority;
			this.ticketStatus = ticketStatus;
			this.itimdComments = itimdComments;
		}
		public String getTicketNo() {
			return ticketNo;
		}
		public void setTicketNo(String ticketNo) {
			this.ticketNo = ticketNo;
		}
		public String getTicketCategoryId() {
			return ticketCategoryId;
		}
		public void setTicketCategoryId(String ticketCategoryId) {
			this.ticketCategoryId = ticketCategoryId;
		}
		public String getTicketDescription() {
			return ticketDescription;
		}
		public void setTicketDescription(String ticketDescription) {
			this.ticketDescription = ticketDescription;
		}
		public String getTicketPriority() {
			return ticketPriority;
		}
		public void setTicketPriority(String ticketPriority) {
			this.ticketPriority = ticketPriority;
		}
		public String getTicketStatus() {
			return ticketStatus;
		}
		public void setTicketStatus(String ticketStatus) {
			this.ticketStatus = ticketStatus;
		}
		public String getItimdComments() {
			return itimdComments;
		}
		public void setItimdComments(String itimdComments) {
			this.itimdComments = itimdComments;
		}
		@Override
		public String toString() {
			return "TicketBean [ticketNo=" + ticketNo + ", ticketCategoryId=" + ticketCategoryId
					+ ", ticketDescription=" + ticketDescription + ", ticketPriority=" + ticketPriority
					+ ", ticketStatus=" + ticketStatus + ", itimdComments=" + itimdComments + "]";
		}

}
