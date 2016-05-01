<%@ page import="com.atlsmall.common.resp.Result"%>
<%@ page import="com.atlsmall.common.enums.StatusCode"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%ObjectMapper mapper = new ObjectMapper();%>
<%=mapper.writeValueAsString(Result.error(StatusCode.ERROR_404))%>

