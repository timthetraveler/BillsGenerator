package com.noonerware.billsgenerator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.noonerware.billsgenerator.dto.BillEntryDTO;

public class BillsGeneratorController {
	
	List<BillEntryDTO> entries = new ArrayList<BillEntryDTO>();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


	public static void main(String[] args) {
		BillsGeneratorController controller = new BillsGeneratorController();
		Calendar startingDate = Calendar.getInstance();
		startingDate.set(Calendar.YEAR, 2019);
		startingDate.set(Calendar.MONTH, Calendar.JANUARY);
		startingDate.set(Calendar.DAY_OF_MONTH, 1);

		controller.generateMonthlyEntries(startingDate, 13);
		controller.generateWeeklyEntries(startingDate, 54);
		
		startingDate.set(Calendar.DAY_OF_MONTH, 11);
		controller.generateEveryPaycheckEntries(startingDate, 28);
		controller.outputEntries();
	}

	private void generateWeeklyEntries(Calendar startingMonth, int numberOfEntries) {
		Calendar loopDate = (Calendar) startingMonth.clone();
		for (int i = 0; i < numberOfEntries; i++) {
			generateMajadoStablesEntry(loopDate);
			loopDate.add(Calendar.DAY_OF_MONTH, 7);
		}	
	}

	private void generateMajadoStablesEntry(Calendar inputDate) {
		boolean entryCreated = false;
		while (!entryCreated) {
			if (inputDate.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
				addEntry("Majado Stables", "", convertToString(inputDate), "85.00", "");
				entryCreated = true;
			}
			else {
				inputDate.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
	}

	private void generateEveryPaycheckEntries(Calendar startingMonth, int numberOfEntries) {
		Calendar loopDate = (Calendar) startingMonth.clone();
		for (int i = 0; i < numberOfEntries; i++) {
			generateSaveForCarInsuranceEntry(loopDate);
			generateSaveForLifeInsuranceEntry(loopDate);
			generateSaveForCollegeEntry(loopDate);
			generateSaveForHouseEntry(loopDate);
			generateSaveForSummerChildcareEntry(loopDate);
			generateSaveForVacationEntry(loopDate);
			generateSaveForChristmasEntry(loopDate);
			generateSaveForHongEntry(loopDate);
			generateSaveForTeacherGiftsEntry(loopDate);
			generateJimmyMoneyEntry(loopDate);
			loopDate.add(Calendar.DAY_OF_MONTH, 14);
		}
	}

	private void generateSaveForCarInsuranceEntry(Calendar inputDate) {
		addEntry("Save for Car Insurance", "", convertToString(inputDate), "200.00", "");
	}

	private void generateSaveForLifeInsuranceEntry(Calendar inputDate) {
		addEntry("Save for Life Insurance", "", convertToString(inputDate), "25.00", "");
	}

	private void generateSaveForCollegeEntry(Calendar inputDate) {
		addEntry("Save for College", "", convertToString(inputDate), "100.00", "");
	}

	private void generateSaveForHouseEntry(Calendar inputDate) {
		addEntry("Save for House", "", convertToString(inputDate), "495.00", "");
	}

	private void generateSaveForSummerChildcareEntry(Calendar inputDate) {
		addEntry("Save for Summer Childcare", "", convertToString(inputDate), "50.00", "");
	}

	private void generateSaveForVacationEntry(Calendar inputDate) {
		addEntry("Save for Vacation", "", convertToString(inputDate), "50.00", "");
	}

	private void generateSaveForChristmasEntry(Calendar inputDate) {
		addEntry("Save for XMAS", "", convertToString(inputDate), "75.00", "");
	}

	private void generateSaveForHongEntry(Calendar inputDate) {
		addEntry("Save for Hong", "", convertToString(inputDate), "25.00", "");
	}

	private void generateSaveForTeacherGiftsEntry(Calendar inputDate) {
		addEntry("Save for Teacher Gifts", "", convertToString(inputDate), "25.00", "");
	}

	private void generateJimmyMoneyEntry(Calendar inputDate) {
		addEntry("MJ - Jimmy Money", "", convertToString(inputDate), "175.00", "");
	}

	private void generateMonthlyEntries(Calendar startingMonth, int numberOfEntries) {
		Calendar loopDate = (Calendar) startingMonth.clone();
		for (int i = 0; i < numberOfEntries; i++) {
			generateAllStateEntry(loopDate);
			generateIRSEntry(loopDate);
			generateMortgageEntry(loopDate);
			generateMJCarPaymentEntry(loopDate);
			generateMJCarInsuranceEntry(loopDate);
			generateLifeInsuranceEntry(loopDate);
			loopDate.add(Calendar.MONTH, 1);
		}
	}

	private void generateIRSEntry(Calendar inputDate) {
		inputDate.set(Calendar.DAY_OF_MONTH, 15);
		addEntry("US Treasury", "", convertToString(inputDate), "476", "");
	}

	private void generateMortgageEntry(Calendar inputDate) {
		inputDate.set(Calendar.DAY_OF_MONTH, 1);
		addEntry("Citizens One", "", convertToString(inputDate), "983.14", "");
	}

	private void generateLifeInsuranceEntry(Calendar inputDate) {
		inputDate.set(Calendar.DAY_OF_MONTH, 1);
		addEntry("United of Omaha", "", convertToString(inputDate), "48.58", "");
	}

	private void generateMJCarPaymentEntry(Calendar inputDate) {
		inputDate.set(Calendar.DAY_OF_MONTH, 10);
		addEntry("Santander", "", convertToString(inputDate), "544.82", "");
	}

	private void generateMJCarInsuranceEntry(Calendar inputDate) {
		inputDate.set(Calendar.DAY_OF_MONTH, 10);
		addEntry("Foremost Insurance", "", convertToString(inputDate), "297.04", "");
	}

	private void generateAllStateEntry(Calendar inputDate) {
		inputDate.set(Calendar.DAY_OF_MONTH, 20);
		addEntry("AllState", "", convertToString(inputDate), "182.56", "");
	}

	private void addEntry(String who, String amtDue, String by, String minAmt, String otherAmt) {
		BillEntryDTO entry = new BillEntryDTO(who, amtDue, by, minAmt, otherAmt);
		entries.add(entry);
	}
	
	private String convertToString(Calendar inputCalendar) {
		String formattedDate = dateFormat.format(inputCalendar.getTime());
		return formattedDate;
	}

	private void outputEntries() {
		for (BillEntryDTO entry : entries) {
			System.out.println(entry.toCSV());
		}
	}
}
