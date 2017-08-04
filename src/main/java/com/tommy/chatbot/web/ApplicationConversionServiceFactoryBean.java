package com.tommy.chatbot.web;

import com.tommy.chatbot.domain.Customer;
import com.tommy.chatbot.domain.Disease;
import com.tommy.chatbot.domain.HospitalInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

    public Converter<Disease, String> getDiseaseToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<Disease,String>() {
            public String convert(Disease disease) {
                return new StringBuilder().append(disease.getDocCategory()).append(' ').append(disease.getCategory()).append(' ').append(disease.getBigCategory()).append(' ').append(disease.getSymptom()).toString();
            }
        };
    }

    public Converter<Integer, Disease> getIdToDiseaseConverter() {
        return new org.springframework.core.convert.converter.Converter<Integer,Disease>() {
            public com.tommy.chatbot.domain.Disease convert(java.lang.Integer id) {
                return Disease.findDisease(id);
            }
        };
    }

    public Converter<String, Disease> getStringToDiseaseConverter() {
        return new org.springframework.core.convert.converter.Converter<String,Disease>() {
            public com.tommy.chatbot.domain.Disease convert(String id) {
                return getObject().convert(getObject().convert(id, Integer.class), Disease.class);
            }
        };
    }

    public Converter<HospitalInfo, String> getHospitalInfoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<HospitalInfo,String>() {
            public String convert(HospitalInfo hospitalInfo) {
                return new StringBuilder().append(hospitalInfo.getHpCode()).append(' ').append(hospitalInfo.getHpName()).append(' ').append(hospitalInfo.getHpAuth()).append(' ').append(hospitalInfo.getHpType()).toString();
            }
        };
    }

    public Converter<Integer, HospitalInfo> getIdToHospitalInfoConverter() {
        return new org.springframework.core.convert.converter.Converter<Integer, HospitalInfo>() {
            public com.tommy.chatbot.domain.HospitalInfo convert(java.lang.Integer id) {
                return HospitalInfo.findHospitalInfo(id);
            }
        };
    }

    public Converter<String, HospitalInfo> getStringToHospitalInfoConverter() {
        return new org.springframework.core.convert.converter.Converter<String, HospitalInfo>() {
            public com.tommy.chatbot.domain.HospitalInfo convert(String id) {
                return getObject().convert(getObject().convert(id, Integer.class), HospitalInfo.class);
            }
        };
    }

    public Converter<Customer, String> getCustomerToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<Customer, String>() {
            public String convert(Customer customer) {
                return new StringBuilder().append(customer.getFirstName()).append(' ').append(customer.getLastName()).toString();
            }
        };
    }

    public Converter<String, Customer> getStringToCustomerConverter() {
        return new org.springframework.core.convert.converter.Converter<String,Customer>() {
            public com.tommy.chatbot.domain.Customer convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Customer.class);
            }
        };
    }
	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}
}
