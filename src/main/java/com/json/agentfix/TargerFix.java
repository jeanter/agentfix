package com.json.agentfix;

public class TargerFix {
	
	@MethodReplace(targetClassName = "com.jsonyang.api.model.ApiUser", methodName = "getUserName")
	public String getUserName() {
		return "com.jsonyang.api.model.ApiUser.method getUserName() was modify by java agent.........";
	}
}