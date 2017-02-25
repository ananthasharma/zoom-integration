/**
 * 
 */
package com.aps.apps.zoom.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anantha Sharma
 */
public class BaseModel {

	private Integer				status;
	private Map<String, String>	error	= new HashMap<>();

	/**
	 * 
	 */
	public BaseModel() {
		super();
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the error
	 */
	public Map<String, String> getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(Map<String, String> error) {
		this.error = error;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseModel [status=" + status + ", error=" + Arrays.toString(error.entrySet().toArray()) + "]";
	}

}
