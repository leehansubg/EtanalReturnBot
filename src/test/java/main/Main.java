package main;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

public class Main {
	
	
	public static void main(String[] args) {
		String token = "token";
		
		JDABuilder jda = new JDABuilder(AccountType.BOT);
		jda.setToken(token);
		try {
			System.out.println("Discord Bot On!");
			jda.addEventListeners(new ErBot());
			jda.build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("fali");
		}
	}
}
