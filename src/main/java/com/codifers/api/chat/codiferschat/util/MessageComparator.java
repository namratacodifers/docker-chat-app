package com.codifers.api.chat.codiferschat.util;

import java.util.Comparator;
import com.codifers.api.chat.codiferschat.data.entity.Message;

public class MessageComparator implements Comparator<Message> {

	@Override
	public int compare(Message arg0, Message arg1) {
		// TODO Auto-generated method stub
		if(arg0.getDateTime().isAfter(arg1.getDateTime())) {
			return 1;
		}
		if(arg0.getDateTime().isBefore(arg1.getDateTime())) {
			return -1;
		}
		
		if(arg0.getDateTime().isEqual(arg1.getDateTime())) {
			return 0;
		}
		
		return 2;
	}

}
