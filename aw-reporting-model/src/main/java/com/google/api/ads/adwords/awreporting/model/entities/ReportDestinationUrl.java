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
import com.google.api.ads.adwords.awreporting.model.csv.annotation.MoneyField;
import com.google.api.ads.adwords.awreporting.model.util.BigDecimalUtil;
import com.google.api.ads.adwords.awreporting.model.util.UrlHashUtil;
import com.google.api.ads.adwords.lib.jaxb.v201607.ReportDefinitionReportType;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Specific report class for ReportDestinationUrl
 */
@Entity
@com.googlecode.objectify.annotation.Entity
@Table(name = "AW_ReportDestinationUrl")
@CsvReport(value = ReportDefinitionReportType.DESTINATION_URL_REPORT)
public class ReportDestinationUrl extends ReportBase {

  @Column(name = "ADGROUPID")
  @CsvField(value = "Ad group ID", reportField = "AdGroupId")
  private Long adGroupId;

  @Column(name = "ADGROUPNAME")
  @CsvField(value = "Ad group", reportField = "AdGroupName")
  private String adGroupName;

  @Column(name = "ADGROUPSTATUS")
  @CsvField(value = "Ad group state", reportField = "AdGroupStatus")
  private String adGroupStatus;

  @Column(name = "CAMPAIGNID")
  @CsvField(value = "Campaign ID", reportField = "CampaignId")
  private Long campaignId;

  @Column(name = "CAMPAIGNNAME")
  @CsvField(value = "Campaign", reportField = "CampaignName")
  private String campaignName;

  @Column(name = "CAMPAIGNSTATUS")
  @CsvField(value = "Campaign state", reportField = "CampaignStatus")
  private String campaignStatus;

  @Column(name = "CRITERIADESTINATIONURL")
  @CsvField(value = "Keyword/Placement destination URL", reportField = "CriteriaDestinationUrl")
  private String criteriaDestinationUrl;

  @Column(name = "CRITERIAPARAMETERS")
  @CsvField(value = "Keyword / Placement", reportField = "CriteriaParameters")
  private String criteriaParameters;

  @Column(name = "CRITERIASTATUS")
  @CsvField(value = "Keyword/Placement state", reportField = "CriteriaStatus")
  private String criteriaStatus;

  @Column(name = "CRITERIATYPENAME")
  @CsvField(value = "Match type", reportField = "CriteriaTypeName")
  private String criteriaTypeName;

  @Column(name = "EFFECTIVEDESTINATIONURL", length = 2048)
  @CsvField(value = "Destination URL", reportField = "EffectiveDestinationUrl")
  private String effectiveDestinationUrl;

  @Column(name = "ISNEGATIVE")
  @CsvField(value = "Is negative", reportField = "IsNegative")
  private String isNegative;
  
  @Column(name = "ACTIVE_VIEW_CPM")
  @CsvField(value = "Active View avg. CPM", reportField = "ActiveViewCpm")
  @MoneyField
  private BigDecimal activeViewCpm;
  
  @Column(name = "ACTIVE_VIEW_CTR")
  @CsvField(value = "Active View viewable CTR", reportField = "ActiveViewCtr")
  private BigDecimal activeViewCtr;
  
  @Column(name = "ACTIVE_VIEW_IMPRESSIONS")
  @CsvField(value = "Active View viewable impressions", reportField = "ActiveViewImpressions")
  private Long activeViewImpressions;
  
  @Column(name = "ACTIVE_VIEW_MEASURABILITY")
  @CsvField(value = "Active View measurable impr. / impr.", reportField = "ActiveViewMeasurability")
  private BigDecimal activeViewMeasurability;
  
  @Column(name = "ACTIVE_VIEW_MEASURABLE_COST")
  @CsvField(value = "Active View measurable cost", reportField = "ActiveViewMeasurableCost")
  private Long activeViewMeasurableCost;
  
  @Column(name = "ACTIVE_VIEW_MEASURABLE_IMPRESSIONS")
  @CsvField(value = "Active View measurable impr.", reportField = "ActiveViewMeasurableImpressions")
  private Long activeViewMeasurableImpressions;
  
  @Column(name = "ACTIVE_VIEW_VIEWABILITY")
  @CsvField(value = "Active View viewable impr. / measurable impr.", reportField = "ActiveViewViewability")
  private BigDecimal activeViewViewability;
  
  @Column(name = "CONVERSION_TRACKER_ID")
  @CsvField(value = "Conversion Tracker Id", reportField = "ConversionTrackerId")
  private Long conversionTrackerId;
  
  @Column(name = "GMAIL_FORWARDS")
  @CsvField(value = "Gmail forwards", reportField = "GmailForwards")
  private Long gmailForwards;

  @Column(name = "GMAIL_SAVES")
  @CsvField(value = "Gmail saves", reportField = "GmailSaves")
  private Long gmailSaves;

  @Column(name = "GMAIL_SECONDARY_CLICKS")
  @CsvField(value = "Gmail clicks to website", reportField = "GmailSecondaryClicks")
  private Long gmailSecondaryClicks;
  
  @Column(name = "SLOT")
  @CsvField(value = "Top vs. Other", reportField = "Slot")
  private String slot;
  
  @Column(name = "VIDEO_QUARTILE_25_RATE")
  @CsvField(value = "Video played to 25%", reportField = "VideoQuartile25Rate")
  private BigDecimal videoQuartile25Rate;
  
  @Column(name = "VIDEO_QUARTILE_50_RATE")
  @CsvField(value = "Video played to 50%", reportField = "VideoQuartile50Rate")
  private BigDecimal videoQuartile50Rate;
  
  @Column(name = "VIDEO_QUARTILE_75_RATE")
  @CsvField(value = "Video played to 75%", reportField = "VideoQuartile75Rate")
  private BigDecimal videoQuartile75Rate;
  
  @Column(name = "VIDEO_QUARTILE_100_RATE")
  @CsvField(value = "Video played to 100%", reportField = "VideoQuartile100Rate")
  private BigDecimal videoQuartile100Rate;

  /**
   * Hibernate needs an empty constructor
   */
  public ReportDestinationUrl() {
  }

  public ReportDestinationUrl(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
  }

  @Override
  public void setId() {
    // Generating unique id after having accountId, campaignId, adGroupId and date
    this.id = "";
    if (this.getAccountId() != null) {
      this.id += this.getAccountId() + "-";
    }
    if (this.getCampaignId() != null) {
      this.id += this.getCampaignId() + "-";
    }
    if (this.getAdGroupId() != null) {
      this.id += this.getAdGroupId() + "-";
    }
    if (this.getCriteriaParameters() != null) { 
      this.id += this.getCriteriaParameters() + "-";
    }
 
    // Generating a SHA-1 Hash of the URLs for ID generation
    if (this.getEffectiveDestinationUrl() != null) { 
      this.id += UrlHashUtil.createUrlHash(this.getEffectiveDestinationUrl());
    }

    this.id += setIdDates();

    // Adding extra fields for unique ID
    if (this.getAdNetwork() != null && this.getAdNetwork().length() > 0) {
      this.id += "-" + this.getAdNetwork();
    }
    if (this.getAdNetworkPartners() != null && this.getAdNetworkPartners().length() > 0) {
      this.id += "-" + this.getAdNetworkPartners();
    }
    if (this.getDevice() != null && this.getDevice().length() > 0) {
      this.id += "-" + this.getDevice();
    }
    if (this.getClickType() != null && this.getClickType().length() > 0) {
      this.id += "-" + this.getClickType();
    }
    if (this.getSlot() != null && this.getSlot().length() > 0) {
      this.id += "-" + this.getSlot();
    }
    if (this.getConversionTrackerId() != null) {
      this.id += "-" + this.getConversionTrackerId();
    }
  }

  public Long getAdGroupId() {
    return adGroupId;
  }

  public void setAdGroupId(Long adGroupId) {
    this.adGroupId = adGroupId;
  }

  public String getAdGroupName() {
    return adGroupName;
  }

  public void setAdGroupName(String adGroupName) {
    this.adGroupName = adGroupName;
  }

  public String getAdGroupStatus() {
    return adGroupStatus;
  }

  public void setAdGroupStatus(String adGroupStatus) {
    this.adGroupStatus = adGroupStatus;
  }

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

  public String getCriteriaDestinationUrl() {
    return criteriaDestinationUrl;
  }

  public void setCriteriaDestinationUrl(String criteriaDestinationUrl) {
    this.criteriaDestinationUrl = criteriaDestinationUrl;
  }

  public String getCriteriaParameters() {
    return criteriaParameters;
  }

  public void setCriteriaParameters(String criteriaParameters) {
    this.criteriaParameters = criteriaParameters;
  }

  public String getCriteriaStatus() {
    return criteriaStatus;
  }

  public void setCriteriaStatus(String criteriaStatus) {
    this.criteriaStatus = criteriaStatus;
  }

  public String getCriteriaTypeName() {
    return criteriaTypeName;
  }

  public void setCriteriaTypeName(String criteriaTypeName) {
    this.criteriaTypeName = criteriaTypeName;
  }

  public String getEffectiveDestinationUrl() {
    return effectiveDestinationUrl;
  }

  public void setEffectiveDestinationUrl(String effectiveDestinationUrl) {
    this.effectiveDestinationUrl = effectiveDestinationUrl;
  }

  public String getIsNegative() {
    return isNegative;
  }

  public void setIsNegative(String isNegative) {
    this.isNegative = isNegative;
  }
  
  public String getActiveViewCpm() {
    return BigDecimalUtil.formatAsReadable(activeViewCpm);
  }

  public BigDecimal getActiveViewCpmBigDecimal() {
    return activeViewCpm;
  }

  public void setActiveViewCpm(String activeViewCpm) {
    this.activeViewCpm = BigDecimalUtil.parseFromNumberStringPercentage(activeViewCpm);
  }
  
  public String getActiveViewCtr() {
    return BigDecimalUtil.formatAsReadable(activeViewCtr);
  }

  public BigDecimal getActiveViewCtrBigDecimal() {
    return activeViewCtr;
  }

  public void setActiveViewCtr(String activeViewCtr) {
    this.activeViewCtr = BigDecimalUtil.parseFromNumberString(activeViewCtr);
  }
  
  public Long getActiveViewImpressions() {
    return activeViewImpressions;
  }
  
  public void setActiveViewImpressions(Long activeViewImpressions) {
    this.activeViewImpressions = activeViewImpressions;
  }
  
  public String getActiveViewMeasurability() {
    return BigDecimalUtil.formatAsReadable(activeViewMeasurability);
  }
  
  public BigDecimal getActiveViewMeasurabilityBigDecimal() {
    return activeViewMeasurability;
  }
  
  public void setActiveViewMeasurability(String activeViewMeasurability) {
    this.activeViewMeasurability = BigDecimalUtil.parseFromNumberString(activeViewMeasurability);
  }
  
  public Long getActiveViewMeasurableCost() {
    return activeViewMeasurableCost;
  }
  
  public void setActiveViewMeasurableCost(Long activeViewMeasurableCost) {
    this.activeViewMeasurableCost = activeViewMeasurableCost;
  }
  
  public Long getActiveViewMeasurableImpressions() {
    return activeViewMeasurableImpressions;
  }
  
  public void setActiveViewMeasurableImpressions(Long activeViewMeasurableImpressions) {
    this.activeViewMeasurableImpressions = activeViewMeasurableImpressions;
  }
  
  public String getActiveViewViewability() {
    return BigDecimalUtil.formatAsReadable(activeViewViewability);
  }
  
  public BigDecimal getActiveViewViewabilityBigDecimal() {
    return activeViewViewability;
  }
  
  public void setActiveViewViewability(String activeViewViewability) {
    this.activeViewViewability = BigDecimalUtil.parseFromNumberString(activeViewViewability);
  }
  
  public Long getConversionTrackerId() {
    return conversionTrackerId;
  }
  
  public void setConversionTrackerId(Long conversionTrackerId) {
    this.conversionTrackerId = conversionTrackerId;
  }
  
  public Long getGmailForwards() {
    return gmailForwards;
  }
  
  public void setGmailForwards(Long gmailForwards) {
    this.gmailForwards = gmailForwards;
  }
  
  public Long getGmailSaves() {
    return gmailSaves;
  }
  
  public void setGmailSaves(Long gmailSaves) {
    this.gmailSaves = gmailSaves;
  }
  
  public Long getGmailSecondaryClicks() {
    return gmailSecondaryClicks;
  }
  
  public void setGmailSecondaryClicks(Long gmailSecondaryClicks) {
    this.gmailSecondaryClicks = gmailSecondaryClicks;
  }
  
  public String getSlot() {
    return slot;
  }

  public void setSlot(String slot) {
    this.slot = slot;
  }

  public String getVideoQuartile25Rate() {
    return BigDecimalUtil.formatAsReadable(videoQuartile25Rate);
  }
  
  public BigDecimal getVideoQuartile25RateBigDecimal() {
    return videoQuartile25Rate;
  }
  
  public void setVideoQuartile25Rate(String videoQuartile25Rate) {
    this.videoQuartile25Rate = BigDecimalUtil.parseFromNumberString(videoQuartile25Rate);
  }

  public String getVideoQuartile50Rate() {
    return BigDecimalUtil.formatAsReadable(videoQuartile50Rate);
  }
  
  public BigDecimal getVideoQuartile50RateBigDecimal() {
    return videoQuartile50Rate;
  }
  
  public void setVideoQuartile50Rate(String videoQuartile50Rate) {
    this.videoQuartile50Rate = BigDecimalUtil.parseFromNumberString(videoQuartile50Rate);
  }

  public String getVideoQuartile75Rate() {
    return BigDecimalUtil.formatAsReadable(videoQuartile75Rate);
  }
  
  public BigDecimal getVideoQuartile75RateBigDecimal() {
    return videoQuartile75Rate;
  }
  
  public void setVideoQuartile75Rate(String videoQuartile75Rate) {
    this.videoQuartile75Rate = BigDecimalUtil.parseFromNumberString(videoQuartile75Rate);
  }

  public String getVideoQuartile100Rate() {
    return BigDecimalUtil.formatAsReadable(videoQuartile100Rate);
  }
  
  public BigDecimal getVideoQuartile100RateBigDecimal() {
    return videoQuartile100Rate;
  }
  
  public void setVideoQuartile100Rate(String videoQuartile100Rate) {
    this.videoQuartile100Rate = BigDecimalUtil.parseFromNumberString(videoQuartile100Rate);
  }
}
