package com.mogwailabs.test.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SuppressWarnings("serial")
@ManagedBean(name="sessionMapBean")
@SessionScoped
public class SessionMapBean implements Serializable{
	
	private static final int MAX_LEN = 160;

	public List<String[]> getSessionMapList()
	   {
	      List<String[]> result = new ArrayList<>();
	      Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	      Map<String,Object> sessionMapSorted = new TreeMap<>( sessionMap );
	      for( Map.Entry<String,Object> entry : sessionMapSorted.entrySet() ) {
	         addKeyValue( entry.getKey(), entry.getValue(), MAX_LEN / 2, result );
	      }
	      return result;
	   }

	private static void addKeyValue( String key, Object value, int maxlen, List<String[]> result )
	   {
	      if( key == null || value == null ) { return; }
	      String val = value.toString();
	      if( val == null || val.trim().length() == 0 || "{}".equals( val ) ) { return; }
	      int maxlen2 = maxlen/2 - 6;
	      String key2 = ( key.length() <= maxlen ) ? key : (key.substring( 0, maxlen2 ) + "... ... ..." + key.substring( key.length() - maxlen2 ) );
	      String val2 = ( val.length() <= maxlen ) ? val : (val.substring( 0, maxlen2 ) + "... ... ..." + val.substring( val.length() - maxlen2 ) );
	      result.add( new String[] { key2, val2 } );
	   }

}
