/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.sample.validationtck.metadata;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.sample.validationtck.util.Failing;

/**
 * Test wrapper for
 * {@link org.hibernate.jsr303.tck.tests.constraints.groups.GroupTest}.
 */
public class BeanDescriptorTest extends GWTTestCase {
  private final org.hibernate.jsr303.tck.tests.metadata.BeanDescriptorTest delegate =
      new org.hibernate.jsr303.tck.tests.metadata.BeanDescriptorTest();

  @Override
  public String getModuleName() {
    return "com.google.gwt.sample.validationtck.metadata.TckTest";
  }

  public void testGetConstrainedProperties() {
    delegate.testGetConstrainedProperties();
  }

  public void testGetConstrainedPropertiesForUnconstrainedEntity() {
    delegate.testGetConstrainedPropertiesForUnconstrainedEntity();
  }

  public void testGetConstraintForConstrainedProperty() {
    delegate.testGetConstraintForConstrainedProperty();
  }

  public void testGetConstraintForUnConstrainedProperty() {
    delegate.testGetConstraintForUnConstrainedProperty();
  }

  public void testGetConstraintsForNonExistingProperty() {
    delegate.testGetConstraintsForNonExistingProperty();
  }

  public void testGetConstraintsForNullProperty() {
    delegate.testGetConstraintsForNullProperty();
  }

  @Failing(issue = 5802)
  public void testIsBeanConstrainedDueToConstraintOnEntity() {
    delegate.testIsBeanConstrainedDueToConstraintOnEntity();
  }

  public void testIsBeanConstrainedDueToConstraintOnInterface() {
    delegate.testIsBeanConstrainedDueToConstraintOnInterface();
  }

  public void testIsBeanConstrainedDueToConstraintProperty() {
    delegate.testIsBeanConstrainedDueToConstraintProperty();
  }

  public void testIsBeanConstrainedDueToValidAnnotation() {
    delegate.testIsBeanConstrainedDueToValidAnnotation();
  }

  public void testUnconstrainedClass() {
    delegate.testUnconstrainedClass();
  }
}