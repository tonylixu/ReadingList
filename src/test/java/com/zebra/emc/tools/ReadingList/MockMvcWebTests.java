package com.zebra.emc.tools.ReadingList;

import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @RunWith: Given SpringJUnit4ClassRunner.class to enable Spring integration context, here we
 * asking it to load the Spring application context given the specification defined in
 * MockMvcWebTests
 * @EnableAutoConfiguration: Since SpringApplicationConfiguration is deprecated as of 1.4, we use
 * EnableAutoConfiguration instead
 * @
 */
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@WebAppConfiguration
public class MockMvcWebTests {

}
