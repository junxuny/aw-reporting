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
@Table(name = "AW_ReportCampaignNegativeLocations")
@CsvReport(value = ReportDefinitionReportType.CAMPAIGN_NEGATIVE_LOCATIONS_REPORT,
    reportExclusions = {"ExternalCustomerId"})
public class ReportCampaignNegativeLocations extends Report {

  @Column(name = "ID")
  @CsvField(value = "Location", reportField = "Id")
  private String locationId;

  @Column(name = "CAMPAIGN_ID")
  @CsvField(value = "Campaign ID", reportField = "CampaignId")
  private Long campaignId;
  
  @Column(name = "CAMPAIGN_NAME", length = 255)
  @CsvField(value = "Campaign", reportField = "CampaignName")
  private String campaignName;
  
  @Column(name = "CAMPAIGN_STATUS", length = 32)
  @CsvField(value = "Campaign state", reportField = "CampaignStatus")
  private String campaignStatus;

  @Column(name = "IS_NEGATIVE")
  @CsvField(value = "Is negative", reportField = "IsNegative")
  private boolean negative;

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
  public ReportCampaignNegativeLocations() {}

  public ReportCampaignNegativeLocations(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
  }

  public boolean isNegative() {
    return negative;
  }

  public void setNegative(boolean negative) {
    this.negative = negative;
  }

  public void setNegative(String negative) {
    this.negative = Boolean.parseBoolean(negative);
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
    if (this.getLocationId() != null) {
      this.id += "-" + this.getLocationId();
    }

    this.id += setIdDates();
  }


  public String getLocationId() {
	return locationId;
}

public void setLocationId(String locationId) {
	this.locationId = locationId;
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
