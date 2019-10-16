package com.mogwailabs.test.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@ManagedBean(name = "expressionBean", eager = true)
@SessionScoped
public class ExpressionBean implements Serializable {
   
   private String expression;
   
   public void setExpression(String expression) {
	   this.expression = expression;
   }
   
   public String getExpression() {
      return(expression);
   }
}
