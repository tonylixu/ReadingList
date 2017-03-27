package com.zebra.emc.tools.ReadingList;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @RunWith: Given SpringJUnit4ClassRunner.class to enable Spring integration context, here we
 * asking it to load the Spring application context given the specification defined in
 * MockMvcWebTests
 * @EnableAutoConfiguration: Since SpringApplicationConfiguration is deprecated as of 1.4, we use
 * EnableAutoConfiguration instead
 * @WebAppConfiguration declares that the application context created by SpringJUnit4ClassRunner
 * should be a WebApplicationContext (as opposed to a basic non-web ApplicationContext).
 */
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@WebAppConfiguration
public class MockMvcWebTests {

    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;

    /*
     * This setupMockMvc method should be executed before any test methods. The injected
     * WebApplicationContext has been passed into the webAppContextSetup() method and then calls
     * build() to produce a MockMvc instance.
     */
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webContext)
            .build();
    }

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("readlingList"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("readingList"))
            .andExpect(MockMvcResultMatchers.modle().attributeExists("books"))
            .andExpect(MockMvcResultMatchers.model().attribute("books",
                Matchers.is(Matchers.empty())));
    }

}
