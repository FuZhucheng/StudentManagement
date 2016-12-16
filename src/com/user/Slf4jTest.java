package com.user;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {
	  private static Logger Log = LoggerFactory.getLogger(Slf4jTest.class);
	    
	    @Test
	    public void testLogBack(){
	        
	        Log.debug("Test the MessageFormat for {} to {} endTo {}", 1,2,3);
	        Log.info("Test the MessageFormat for {} to {} endTo {}", 1,2,3);
	        Log.error("Test the MessageFormat for {} to {} endTo {}", 1,2,3);
	        
	        try{
	            throw new IllegalStateException("try to throw an Exception");
	        }catch(Exception e){
	            Log.error(e.getMessage(),e);
	        }
	    }
	    
	}