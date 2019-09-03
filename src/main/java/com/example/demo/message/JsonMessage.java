package com.example.demo.message;

public class JsonMessage{
	
	private Object success;
	private Object data;
	private Integer code;
	private String message;
	private String url;

	public Object getSuccess() {
		return success;
	}

	public void setSuccess(Object success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "JsonMessage [success=" + success + ", data=" + data + ", code=" + code + ", message=" + message
				+ ", url=" + url + "]";
	}
	
}
