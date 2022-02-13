package org.springframework.samples.petclinic.visits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.owner.Visit;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class VisitRequest {

	private int vet_id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;

	ArrayList<Visit> visitList;

	public VisitRequest() {
	}

	public VisitRequest(int vet_id, LocalDate startDate, LocalDate endDate) {
		this.vet_id = vet_id;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getVetId() {
		return vet_id;
	}

	public void setVetId(int vet_id) {
		this.vet_id = vet_id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setStartDate(String startDate) {
		try {
			this.startDate = LocalDate.parse(startDate);
		}
		catch (Exception e) {

		}
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = LocalDate.parse(endDate);
	}

	public ArrayList<Visit> getVisitList() {
		return visitList;
	}

	public void setVisitList(ArrayList<Visit> visitList) {
		this.visitList = visitList;
	}

}
