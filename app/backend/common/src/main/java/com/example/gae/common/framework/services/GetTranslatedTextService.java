package com.example.gae.common.framework.services;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class GetTranslatedTextService {
    
    private final ResourceBundleMessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final HttpServletRequest request;
    
    public GetTranslatedTextService(final ResourceBundleMessageSource messageSourceIn, final LocaleResolver localeResolverIn, final HttpServletRequest requestIn) {
        this.messageSource = messageSourceIn;
        this.localeResolver = localeResolverIn;
        this.request = requestIn;
    }

    public final String invoke(final String messageKey) {
        return messageSource.getMessage(messageKey, null, localeResolver.resolveLocale(request));
    }
}
