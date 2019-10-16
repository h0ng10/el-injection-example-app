package com.mogwailabs.test.bean;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

import org.apache.commons.lang3.exception.ExceptionUtils;

@ManagedBean(name="vulnerableELBean")
@SessionScoped
@SuppressWarnings("serial")
public class ExpressionLanguageInjectionBean implements Serializable {
	
	public static String evaluate(String elExpression) {
        
    	FacesContext context = FacesContext.getCurrentInstance();
        ExpressionFactory expressionFactory = context.getApplication().getExpressionFactory();
        ELContext elContext = context.getELContext();
		try {
			ValueExpression valueExpression = expressionFactory.createValueExpression(elContext, elExpression, String.class);
			return (String) valueExpression.getValue(elContext);
			
		} catch (Exception exception) {
			return ExceptionUtils.getStackTrace(exception);
		}
    }
}

