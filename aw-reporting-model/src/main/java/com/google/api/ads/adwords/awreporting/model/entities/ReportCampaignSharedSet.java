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
@Table(name = "AW_ReportCampaignSharedSet")
@CsvReport(value = ReportDefinitionReportType.CAMPAIGN_SHARED_SET_REPORT,
    reportExclusions = {"ExternalCustomerId"})
public class ReportCampaignSharedSet extends Report {

  @Column(name = "CAMPAIGN_ID")
  @CsvField(value = "Campaign ID", reportField = "CampaignId")
  private Long campaignId;
  
  @Column(name = "CAMPAIGN_NAME", length = 255)
  @CsvField(value = "Campaign", reportField = "CampaignName")
  private String campaignName;
  
  @Column(name = "CAMPAIGN_STATUS", length = 32)
  @CsvField(value = "Campaign state", reportField = "CampaignStatus")
  private String campaignStatus;

//  /SharedSetName,SharedSetType,Status
  @Column(name = "SHARED_SET_NAME", length = 255)
  @CsvField(value = "Shared Set Name", reportField = "SharedSetName")
  private String sharedSetName;
  
  @Column(name = "SHARED_SET_TYPE", length = 32)
  @CsvField(value = "Shared Set Type", reportField = "SharedSetType")
  private String sharedSetType;
  
  @Column(name = "CAMPAIGN_SHARED_SET_STATUS", length = 32)
  @CsvField(value = "State", reportField = "Status")
  private String campaignSharedSetStatus;

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
  public ReportCampaignSharedSet() {}

  public ReportCampaignSharedSet(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
  }

  @Override
  public void setId() {
    // Generating unique id after having campaignId, adGroupId and date

    if (this.getAccountId() != null) {
      this.id = String.valueOf(this.getAccountId());
    }
    if (this.getCampaignId() != null) {
      this.id += "-" + this.getCampaignId();
    }
    if (this.getSharedSetName() != null) {
      this.id += "-" + this.getSharedSetName();
    }
    if (this.getSharedSetType() != null) {
      this.id += "-" + this.getSharedSetType();
    }

    this.id += setIdDates();
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

public String getCampaignSharedSetStatus() {
	return campaignSharedSetStatus;
}

public void setCampaignSharedSetStatus(String campaignSharedSetStatus) {
	this.campaignSharedSetStatus = campaignSharedSetStatus;
}

// campaignId
  public Long getCampaignId() {
    return campaignId;
  }

  public void setCampaignId(Long campaignId) {
    this.campaignId = campaignId;
  }
  
  public String getCampaignName() {
    return campaignName;
  }

  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }
  
  public String getCampaignStatus() {
    return campaignStatus;
  }

  public void setCampaignStatus(String campaignStatus) {
    this.campaignStatus = campaignStatus;
  }
}
