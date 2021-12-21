package main;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

public class Main {
	
	
	public static void main(String[] args) {
		String token = "OTE4NDQ5ODg1ODQ4NjY2MTQy.YbHbHA.84YgXY7aVUGbObFHhCuEWjxw44k";
		
		JDABuilder jda = new JDABuilder(AccountType.BOT);
		jda.setToken(token);
		try {
			System.out.println("디스코드봇 연결성공");
			jda.addEventListeners(new ErBot());
			jda.build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}
}
