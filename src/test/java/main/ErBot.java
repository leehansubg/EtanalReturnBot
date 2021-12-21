package main;


import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import Util.getMMR;

public class ErBot extends ListenerAdapter{
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		// https://dak.gg/bser/players/player
		String msg = event.getMessage().getContentRaw();		
		EmbedBuilder em = new EmbedBuilder();
		
		if(msg.startsWith("$")) {
			int index = msg.indexOf(" ");
			if(index < 0) {
				return;
			}
			
			getMMR getm = new getMMR();
			
			String name = msg.substring(index + 1);
			ArrayList<String> list = getm.getmmr(name);
			
			if(list.get(0).equals("해당유저의 정보가 존재하지않거나, 최근매치가 랭크가 아닙니다.")) {
				event.getChannel().sendMessage(list.get(0)).queue();
			} else {

				em.setTitle("user Tier");
				em.setDescription(list.get(1));
				em.setAuthor(name, "https://dak.gg/bser/players/player/" + name, list.get(4));
				em.addField("user info", list.get(0) + "\n" 
				+ list.get(2) + "\n"
				+ list.get(3), false);
			    em.setThumbnail(list.get(4));
				em.addField("user Lately match",  "ranking : "+ list.get(5) + "\n" + 
			    "mode : " + list.get(6) + "\n" + 
				"k/a/h : " + list.get(7) + "\n" + 
			    "dmg : " + list.get(8) + "\n" + 
				"character : " + list.get(9) , false);
				
				
				event.getChannel().sendTyping().queue();
				event.getChannel().sendMessage(em.build()).queue();			
	
			}
					}
		
		if(msg.startsWith("")) {
			
		}

	}

}

