/**
 * 
 */
package com.aps.apps.zoom.model;

import java.util.Date;

/**
 * @author Anantha Sharma
 */
public class Meeting extends BaseModel {

	private String	uuid, id, startUrl, joinUrl, hostId, topic, type;
	private Date	createdAt, deletedAt;

	/**
	 * 
	 */
	public Meeting() {
		super();
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the startUrl
	 */
	public String getStartUrl() {
		return startUrl;
	}

	/**
	 * @param startUrl
	 *            the startUrl to set
	 */
	public void setStartUrl(String startUrl) {
		this.startUrl = startUrl;
	}

	/**
	 * @return the joinUrl
	 */
	public String getJoinUrl() {
		return joinUrl;
	}

	/**
	 * @param joinUrl
	 *            the joinUrl to set
	 */
	public void setJoinUrl(String joinUrl) {
		this.joinUrl = joinUrl;
	}

	/**
	 * @return the hostId
	 */
	public String getHostId() {
		return hostId;
	}

	/**
	 * @param hostId
	 *            the hostId to set
	 */
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic
	 *            the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the deletedAt
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}

	/**
	 * @param deletedAt
	 *            the deletedAt to set
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s -> Meeting [uuid=%s, id=%s, startUrl=%s, joinUrl=%s, hostId=%s, topic=%s, type=%s, createdAt=%s, deletedAt=%s]", super.toString(), uuid, id, startUrl, joinUrl, hostId, topic, type, createdAt, deletedAt);
	}

}
