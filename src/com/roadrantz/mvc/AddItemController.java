package com.roadrantz.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import standalone.beans.Item;

public class AddItemController extends SimpleFormController {
	private static final String[] ALL_STATES = {
		"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL",
		"GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
		"MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
		"NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
		"SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WV", "WI",
		"WY"
		};
	public AddItemController() {
//		setCommandName("Patient");
		setCommandClass(Item.class);
//		setSessionForm(true);
	}
	protected void doSubmitAction(Object command) {
		Item item = (Item) command;
//		throw new NullPointerException();
	}
	
	@Override
	protected Map referenceData(HttpServletRequest request)
	{
		Map referenceData = new HashMap();
		referenceData.put("states", ALL_STATES);
		return referenceData;
	}
}
