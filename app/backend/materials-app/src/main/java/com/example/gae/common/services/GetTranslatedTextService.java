package com.example.gae.common.services;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class GetTranslatedTextService {
    
    private final ResourceBundleMessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final HttpServletRequest request;
    
    @Autowired
    public GetTranslatedTextService(ResourceBundleMessageSource messageSource, LocaleResolver localeResolver, HttpServletRequest request){
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
        this.request = request;
    }

    public String invoke(String messageKey) {

        return messageSource.getMessage(messageKey, null, localeResolver.resolveLocale(request));
    }
}
