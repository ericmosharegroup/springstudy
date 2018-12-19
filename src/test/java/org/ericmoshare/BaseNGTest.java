package org.ericmoshare;

import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by eric.mo on 2017/8/4.
 */
@Configuration
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@ActiveProfiles(value = "development")
public abstract class BaseNGTest extends AbstractTestNGSpringContextTests {

}
