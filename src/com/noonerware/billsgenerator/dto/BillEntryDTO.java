package com.noonerware.billsgenerator.dto;

public class BillEntryDTO {
	private static final String DELIMITER = ",";
	String who;
	String amtDue;
	String by;
	String minAmt;
	String otherAmt;
	
	
	
	
	public BillEntryDTO(String who, String amtDue, String by, String minAmt, String otherAmt) {
		super();
		this.who = who;
		this.amtDue = amtDue;
		this.by = by;
		this.minAmt = minAmt;
		this.otherAmt = otherAmt;
	}




	public String toCSV() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(who).append(DELIMITER);
		builder.append(amtDue).append(DELIMITER);
		builder.append(by).append(DELIMITER);
		builder.append(minAmt).append(DELIMITER);
		builder.append(otherAmt);
		
		return builder.toString();
	}

}
