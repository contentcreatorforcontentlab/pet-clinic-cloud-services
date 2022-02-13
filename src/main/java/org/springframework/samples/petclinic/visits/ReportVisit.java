/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.visits;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ReportVisit {

	private String vetFirstName;

	private String vetLastName;

	private String petName;

	private String description;

	private String ownerFirstName;

	private String ownerLastName;

	private LocalDate visitDate;

	/**
	 * Creates a new instance of Visit for the current date
	 */
	public ReportVisit() {
	}

	public String getVetFirstName() {
		return vetFirstName;
	}

	public void setVetFirstName(String firstName) {
		this.vetFirstName = firstName;
	}

	public String getVetLastName() {
		return vetLastName;
	}

	public void setVetLastName(String lastName) {
		this.vetLastName = lastName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String firstName) {
		this.ownerFirstName = firstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String lastName) {
		this.ownerLastName = lastName;
	}

	public LocalDate getVisitDate() {
		return this.visitDate;
	}

	// public void setVisitDate(LocalDate date) {
	// this.visitDate = date;
	// }

	public void setVisitDate(Date date) {
		this.visitDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
