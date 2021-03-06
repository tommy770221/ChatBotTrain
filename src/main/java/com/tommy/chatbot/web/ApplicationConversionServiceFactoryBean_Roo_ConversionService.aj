// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.tommy.chatbot.web;

import com.tommy.chatbot.domain.Customer;
import com.tommy.chatbot.domain.Disease;
import com.tommy.chatbot.domain.HospitalInfo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;



    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getCustomerToStringConverter());
        registry.addConverter(getStringToCustomerConverter());
        registry.addConverter(getDiseaseToStringConverter());
        registry.addConverter(getIdToDiseaseConverter());
        registry.addConverter(getStringToDiseaseConverter());
        registry.addConverter(getHospitalInfoToStringConverter());
        registry.addConverter(getIdToHospitalInfoConverter());
        registry.addConverter(getStringToHospitalInfoConverter());
    }

    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
