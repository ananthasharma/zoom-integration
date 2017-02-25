/**
 * 
 */
package com.aps.apps.zoom;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aps.apps.zoom.api.ZoomAPI;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Anantha Sharma
 */
public class MainClass {
	private static final Logger	LOG		= LoggerFactory.getLogger(MainClass.class);
	ResourceBundle				bundle	= ResourceBundle.getBundle("config");
	private ZoomAPI				api		= null;

	/**
	 * @throws UnirestException
	 */
	public MainClass() {
		try {
			api = new ZoomAPI(bundle.getString("zoom.api_key"), bundle.getString("zoom.secret_key"));
			testCreateMeeting();
		} catch (Exception e) {
			LOG.error("Found exception Exception in method MainClass", e);
		}
	}

	public void testCreateMeeting() throws Exception {
		api.createMeeting("host_user_id", "meeting subject", "a", 12);
	}

	public static void main(String[] args) {
		new MainClass();
	}
}
