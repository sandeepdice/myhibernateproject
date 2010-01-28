package com.roadrantz.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import standalone.beans.User;

public class LoginPageController extends SimpleFormController {
	public LoginPageController() {
//		setCommandName("Patient");
		setCommandClass(User.class);
//		setSessionForm(true);
	}
	protected void doSubmitAction(Object command) {
		User user = (User) command;
	}
}
