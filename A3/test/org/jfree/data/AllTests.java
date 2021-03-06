package org.jfree.data;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("org.jfree.data")
@IncludeClassNamePatterns({"^.*Test$"})


public class AllTests {

}
