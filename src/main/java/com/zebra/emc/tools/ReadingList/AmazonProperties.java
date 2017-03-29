package com.zebra.emc.tools.ReadingList;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Component: Indicates that AmazonProperties is a component. Such classes are considered as
 * candidates for auto-detection when using annatation-based configuration and classpath scanning.
 * @ConfigurationProperties: Inject properties into the controller, from "amazon"-prefixed
 * configuration properties.
 */
@Component
@ConfigurationProperties("amazon")
public class AmazonProperties {
    private String associateId;

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getAssociateId() {
        return associateId;
    }
}
