package com.msg.entity;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -5557121442185559825L;
	
	private Long messageId;
	private String messageBody;
	/**
	 * @return the messageId
	 */
	public Long getMessageId() {
		return messageId;
	}
	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	/**
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}
	/**
	 * @param messageBody the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageBody == null) ? 0 : messageBody.hashCode());
		result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (messageBody == null) {
			if (other.messageBody != null)
				return false;
		} else if (!messageBody.equals(other.messageBody))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		return true;
	}
	
}
