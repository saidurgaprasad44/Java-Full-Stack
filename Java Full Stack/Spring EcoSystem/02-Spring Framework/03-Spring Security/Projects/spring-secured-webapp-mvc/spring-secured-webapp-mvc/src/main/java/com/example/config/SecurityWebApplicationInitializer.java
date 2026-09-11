package com.example.config;

import java.util.EnumSet;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import jakarta.servlet.DispatcherType;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	@Override
    protected EnumSet<DispatcherType> getSecurityDispatcherTypes() { // The security filter participates in REQUEST, ERROR, and ASYNC dispatches but not in FORWARD
        return EnumSet.of(
            DispatcherType.REQUEST,
            DispatcherType.ERROR,
            DispatcherType.ASYNC
        );
    }
}