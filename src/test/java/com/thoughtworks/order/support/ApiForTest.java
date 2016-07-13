package com.thoughtworks.order.support;

import com.thoughtworks.order.web.jersey.CORSResponseFilter;
import com.thoughtworks.order.web.jersey.OpenSessionInViewRequestFilter;
import com.thoughtworks.order.web.jersey.OpenSessionInViewResponseFilter;
import com.thoughtworks.order.web.jersey.RoutesFeature;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class ApiForTest extends ResourceConfig {
    public ApiForTest() {
        property(org.glassfish.jersey.server.ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        packages("com.thoughtworks.order.web");
        register(RoutesFeature.class);
        register(LoggingFilter.class);
        register(CORSResponseFilter.class);
        register(OpenSessionInViewRequestFilter.class);
        register(OpenSessionInViewResponseFilter.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
            }
        });
    }
}
