package com.hcl.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hcl.beans.WelcomeBean;
import com.hcl.config.SpringConfig;

public class UserInterface {

	public static void main(String[] args) {
		Log LOGGER=LogFactory.getLog(UserInterface.class);
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
		WelcomeBean b=ctx.getBean(WelcomeBean.class);
		String msg=b.greet();
		LOGGER.info(msg);

	}

}
