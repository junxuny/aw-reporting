// Copyright 2011 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.awreporting.model.entities;

import com.google.api.ads.adwords.awreporting.model.csv.annotation.CsvField;
import com.google.api.ads.adwords.awreporting.model.csv.annotation.CsvReport;
import com.google.api.ads.adwords.lib.jaxb.v201607.ReportDefinitionReportType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Specific report class for ReportAccount
 */
@Entity
@com.googlecode.objectify.annotation.Entity
@Table(name = "AW_ReportSharedSet")
@CsvReport(value = ReportDefinitionReportType.SHARED_SET_REPORT, reportExclusions = { "ExternalCustomerId" })
public class ReportSharedSet extends Report {
	@Column(name = "SHARED_SET_ID")
	@CsvField(value = "Shared Set ID", reportField = "SharedSetId")
	private Long sharedSetId;

	@Column(name = "MEMBER_COUNT")
	@CsvField(value = "Member Count", reportField = "MemberCount")
	private Long memberCount;

	@Column(name = "REFERENCE_COUNT")
	@CsvField(value = "Reference Count", reportField = "ReferenceCount")
	private Long referenceCount;

	@Column(name = "SHARED_SET_NAME", length = 255)
	@CsvField(value = "Shared Set Name", reportField = "Name")
	private String sharedSetName;
	// MEMBER_COUNT,NAME,REFERENCE_COUNT,SHARED_SET_ID,STATUS,TYPE
	// ExternalCustomerId,AccountDescriptiveName,
	// MemberCount,Name,ReferenceCount,SharedSetId,Status,Type

	// SHARED_SET_STATUS,SHARED_SET_TYPE
	@Column(name = "SHARED_SET_TYPE", length = 32)
	@CsvField(value = "Shared Set Type", reportField = "Type")
	private String sharedSetType;

	@Column(name = "SHARED_SET_STATUS", length = 32)
	@CsvField(value = "State", reportField = "Status")
	private String Status;

	  @Column(name = "ACCOUNT_DESCRIPTIVE_NAME", length = 255)
	  @CsvField(value = "Account", reportField = "AccountDescriptiveName")
	  protected String accountDescriptiveName;
	  
	  public String getAccountDescriptiveName() {
		return accountDescriptiveName;
	}

	public void setAccountDescriptiveName(String accountDescriptiveName) {
		this.accountDescriptiveName = accountDescriptiveName;
	}

	/**
	 * Hibernate needs an empty constructor
	 */
	public ReportSharedSet() {
	}

	public ReportSharedSet(Long topAccountId, Long accountId) {
		this.topAccountId = topAccountId;
		this.accountId = accountId;
	}

	@Override
	public void setId() {
		// Generating unique id after having campaignId, adGroupId and date

		if (this.getAccountId() != null) {
			this.id = String.valueOf(this.getAccountId());
		}
		if (this.getSharedSetId() != null) {
			this.id += "-" + this.getSharedSetId();
		}

		this.id += setIdDates();
	}

	public Long getSharedSetId() {
		return sharedSetId;
	}

	public void setSharedSetId(Long sharedSetId) {
		this.sharedSetId = sharedSetId;
	}

	public Long getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Long memberCount) {
		this.memberCount = memberCount;
	}

	public Long getReferenceCount() {
		return referenceCount;
	}

	public void setReferenceCount(Long referenceCount) {
		this.referenceCount = referenceCount;
	}

	public String getSharedSetName() {
		return sharedSetName;
	}

	public void setSharedSetName(String sharedSetName) {
		this.sharedSetName = sharedSetName;
	}

	public String getSharedSetType() {
		return sharedSetType;
	}

	public void setSharedSetType(String sharedSetType) {
		this.sharedSetType = sharedSetType;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
