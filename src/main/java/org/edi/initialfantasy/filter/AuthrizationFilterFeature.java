package org.edi.initialfantasy.filter;

import javax.management.DynamicMBean;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

/**
 * @author Fancy
 * @date 2018/7/11
 */
public class AuthrizationFilterFeature implements DynamicFeature{

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {

    }
}
