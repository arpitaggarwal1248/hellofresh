package com.helloFresh.challenge.API.country.getAll.response;

import java.util.List;

public class RestResponse {
	
	private List<Result> result;

    private List<String> messages;
    
	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	
    
    

}
