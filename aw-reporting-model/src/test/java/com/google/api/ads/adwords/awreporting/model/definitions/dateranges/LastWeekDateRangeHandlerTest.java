// Copyright 2013 Google Inc. All Rights Reserved.
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

package com.google.api.ads.adwords.awreporting.model.definitions.dateranges;

import com.google.api.ads.adwords.awreporting.model.entities.dateranges.LastWeekDateRangeHandler;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;

public class LastWeekDateRangeHandlerTest {

  @Test
  public void testDateRetrieving() {

    DateTime date = new DateTime(2013, 10, 2, 12, 0);

    LastWeekDateRangeHandler handler = new LastWeekDateRangeHandler();

    DateTime dateStart = handler.retrieveDateStart(date);
    Assert.assertEquals(2013, dateStart.getYear());
    Assert.assertEquals(9, dateStart.getMonthOfYear());
    Assert.assertEquals(23, dateStart.getDayOfMonth());

    DateTime dateEnd = handler.retrieveDateEnd(date);
    Assert.assertEquals(2013, dateEnd.getYear());
    Assert.assertEquals(9, dateEnd.getMonthOfYear());
    Assert.assertEquals(29, dateEnd.getDayOfMonth());

    DateTime dateMonth = handler.retrieveMonth(date);
    Assert.assertNull(dateMonth);
  }

}
