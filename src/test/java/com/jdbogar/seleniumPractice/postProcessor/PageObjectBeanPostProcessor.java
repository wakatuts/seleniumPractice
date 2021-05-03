package com.jdbogar.seleniumPractice.postProcessor;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.jdbogar.seleniumPractice.annotations.PageObject;
import com.jdbogar.seleniumPractice.driver.Driver;
import com.jdbogar.seleniumPractice.driver.WebDriverManager;
import com.jdbogar.seleniumPractice.elements.factory.api.ElementFactory;
import com.jdbogar.seleniumPractice.pages.BasePage;

@Component
public class PageObjectBeanPostProcessor implements BeanPostProcessor{

    private WebDriver driver;
	
	@Override
    public Object postProcessBeforeInitialization(Object bean, @NotNull String beanName) throws BeansException {
    	return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
    
        if (Driver.getDriver() == null) {
        	driver = WebDriverManager.createInstance();
            System.out.println("Initializing webdriver session --> Thread ID: " + Thread.currentThread().getId());
            Driver.setWebDriver(driver);
		}
    	
    	if (bean.getClass().isAnnotationPresent(PageObject.class) && bean instanceof BasePage) {
            ((BasePage) bean).setDriver(driver); 
    		ElementFactory.initElements(driver, bean);
        }
        return bean;
    }
	

}
