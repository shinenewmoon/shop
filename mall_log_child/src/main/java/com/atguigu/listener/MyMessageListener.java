package com.atguigu.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.service.MessageService;

public class MyMessageListener implements MessageListener{
	
	@Autowired
	private MessageService messageService;

	public void onMessage(Message message) {
		// 消息内容
		TextMessage textMessage = (TextMessage) message;
		String text = "";
		try {
			text = textMessage.getText();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(text);
		
		//在数据库中插入数据
		messageService.insert_login(text);
	}

}
