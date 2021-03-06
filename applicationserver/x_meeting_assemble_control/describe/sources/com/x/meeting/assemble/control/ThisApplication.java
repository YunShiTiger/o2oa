package com.x.meeting.assemble.control;

import com.x.base.core.project.Context;
import com.x.base.core.project.config.Config;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.base.core.project.message.MessageConnector;
import com.x.collaboration.core.message.Collaboration;

public class ThisApplication {

	protected static Context context;

	public static Context context() {
		return context;
	}

	public static void init() {
		try {
			LoggerFactory.setLevel(Config.logLevel().x_meeting_assemble_control());
			MessageConnector.start(context());
			Collaboration.start(context());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void destroy() {
		try {
			Collaboration.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
