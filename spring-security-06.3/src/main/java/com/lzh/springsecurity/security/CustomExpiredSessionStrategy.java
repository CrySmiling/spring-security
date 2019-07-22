package com.lzh.springsecurity.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		Map<String, Object> map = new HashMap<>(16);
		map.put("code", 0);
		map.put("msg", "已经另一台机器登录，您被迫下线。" + event.getSessionInformation().getLastRequest());
		// Map -> Json
		String json = objectMapper.writeValueAsString(map);

		event.getResponse().setContentType("application/json;charset=UTF-8");
		event.getResponse().getWriter().write(json);
	}
}
