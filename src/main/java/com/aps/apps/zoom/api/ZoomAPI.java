/**
 * 
 */
package com.aps.apps.zoom.api;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aps.apps.zoom.model.Meeting;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Anantha Sharma
 */
public class ZoomAPI {

	private static final Logger	LOG					= LoggerFactory.getLogger(ZoomAPI.class);

	private static final String	STR_DATE_PATTERN	= "yyyy-MM-dd";

	private String				apiKey;
	private String				apiSecret;

	/**
	 * @param apiKey
	 * @param apiSecret
	 * @param zoomUrl
	 */
	public ZoomAPI(String apiKey, String apiSecret) {
		super();
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		Unirest.setObjectMapper(new ZoomObjectMapper());
	}

	/**
	 * @param hostId
	 * @param topic
	 * @param type
	 * @param duration
	 * @throws UnirestException
	 */
	public Meeting createMeeting(String hostId, String topic, String type, int duration) throws UnirestException {
		LOG.debug("Method [createMeeting]: Called");
		HttpResponse<Meeting> response = Unirest.post("https://api.zoom.us/v1/meeting/create").header("accept", "application/json").header("api_key", apiKey).header("api_secret", apiSecret).field("host_id", hostId).field("topic", topic).field("type", type).field("start_time", DateFormatUtils.formatUTC(new Date(), "yyyy-MM-dd")).field("duration", duration <= 0 ? 30 : duration)
				.asObject(Meeting.class);
		String start_url = response.getBody().getStartUrl();
		String join_url = response.getBody().getJoinUrl();
		System.out.println("start: " + start_url);
		System.out.println("join: " + join_url);
		LOG.debug("Method [createMeeting]: Returning. {}", response.getBody());
		return null;// response.getBody();
	}

	/**
	 * @param hostId
	 * @param meetingId
	 * @throws UnirestException
	 */
	public void getMeeting(String hostId, String meetingId) throws UnirestException {
		LOG.debug("Method [deleteMeeting]: Called");
		HttpResponse<Meeting> jsonResponse = Unirest.post("https://api.zoom.us/v1/meeting/get").header("accept", "application/json").header("api_key", apiKey).header("api_secret", apiSecret).field("host_id", hostId).field("id", meetingId).asObject(Meeting.class);
		LOG.debug("Method [deleteMeeting]: Returning. {}", jsonResponse.getBody());
	}

	/**
	 * @param hostId
	 * @param topic
	 * @param type
	 * @param meetingId
	 * @param duration
	 * @throws UnirestException
	 */
	public Meeting updateMeeting(String hostId, String topic, String type, int duration, String meetingId) throws UnirestException {
		LOG.debug("Method [createMeeting]: Called");
		HttpResponse<Meeting> response = Unirest.post("https://api.zoom.us/v1/meeting/update").header("accept", "application/json").header("api_key", apiKey).header("api_secret", apiSecret).field("host_id", hostId).field("topic", topic).field("type", type).field("id", meetingId).field("start_time", DateFormatUtils.formatUTC(new Date(), STR_DATE_PATTERN))
				.field("duration", duration <= 0 ? 30 : duration).asObject(Meeting.class);
		String start_url = response.getBody().getStartUrl();
		String join_url = response.getBody().getJoinUrl();
		System.out.println("start: " + start_url);
		System.out.println("join: " + join_url);
		LOG.debug("Method [createMeeting]: Returning. {}", response.getBody());
		return response.getBody();
	}

	/**
	 * @param hostId
	 * @param meetingId
	 * @throws UnirestException
	 */
	public void deleteMeeting(String hostId, String meetingId) throws UnirestException {
		LOG.debug("Method [deleteMeeting]: Called");
		HttpResponse<Meeting> jsonResponse = Unirest.post("https://api.zoom.us/v1/meeting/delete").header("accept", "application/json").header("api_key", apiKey).header("api_secret", apiSecret).field("host_id", hostId).field("id", meetingId).asObject(Meeting.class);
		LOG.debug("Method [deleteMeeting]: Returning. {}", jsonResponse.getBody());
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey
	 *            the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @return the apiSecret
	 */
	public String getApiSecret() {
		return apiSecret;
	}

	/**
	 * @param apiSecret
	 *            the apiSecret to set
	 */
	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

}
