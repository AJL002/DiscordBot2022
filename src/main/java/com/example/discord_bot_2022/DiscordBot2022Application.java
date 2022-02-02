package com.example.discord_bot_2022;

import com.example.discord_bot_2022.listeners.CircleListener;
import com.example.discord_bot_2022.listeners.PingListener;
import com.example.discord_bot_2022.listeners.RateListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DiscordBot2022Application {
	@Autowired
	private Environment env;
	@Autowired
	private PingListener pingListener;
	@Autowired
	private RateListener rateListener;
	@Autowired
	private CircleListener circleListener;

	public static void main(String[] args) {
		SpringApplication.run(DiscordBot2022Application.class, args);
	}

	@Bean
	@ConfigurationProperties(value = "discord-api")
	public DiscordApi discordApi() {
		String token = env.getProperty("TOKEN");
		DiscordApi api = new DiscordApiBuilder().setToken(token)
				.setAllNonPrivilegedIntents()
				.login()
				.join();

		api.addMessageCreateListener(pingListener);
		api.addMessageCreateListener(rateListener);
		api.addMessageCreateListener(circleListener);

		return api;
	}
}
