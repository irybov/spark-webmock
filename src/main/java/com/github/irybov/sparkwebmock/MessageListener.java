package com.github.irybov.sparkwebmock;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class MessageListener extends Thread {
	
	private static final String EXCHANGE = "bankdemo.notifications";
//	private static final String QUEUE = "bankdemo.notifications.sparkjava";
	
	public void run() {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		Connection connection;
		Channel channel = null;
		String queue = null;
		
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
//			channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.TOPIC);
			channel.exchangeDeclarePassive(EXCHANGE);
//			channel.queueDeclare(QUEUE, true, false, true, null);
			queue = channel.queueDeclare().getQueue();
			channel.queueBind(queue, EXCHANGE, "#");
		}
		catch (IOException | TimeoutException exc) {
			exc.printStackTrace();
		}

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
           String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
           System.out.println(message);
        };
        try {
			channel.basicConsume(queue, true, deliverCallback, consumerTag -> {});
		}
        catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
