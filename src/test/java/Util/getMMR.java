package Util;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class getMMR {
	public ArrayList<String> getmmr(String name) {
		// TODO Auto-generated method stub
		String url = "https://dak.gg/bser/players/" + name; // url 
		String msg[] = {"",""};
		String strmmr = "";
		ArrayList<String> list = new ArrayList<>();
		
		try {
			Document doc = Jsoup.connect(url).get(); // url 연결
			Element mmr = doc.selectFirst(".player-tier__summary__lp > b"); //mmr 가져오기
			Element rank = doc.selectFirst(".player-tier__summary__rank"); //rank data 가져오기
			Element img = doc.selectFirst(".player-header__image"); // img가져오기
			Element match_ranking = doc.selectFirst(".match-history__item__summary__rank"); //최근매치-랭킹
			Element match_mode = doc.selectFirst(".match-history__item__summary__team-mode"); //최근매치-모드
			Element match_kah = doc.selectFirst(".kah > div"); //최근매치-킬뎃	
			Element match_dmg = doc.selectFirst(".dmg > b"); //최근매치-딜량		
			Element match_character = doc.selectFirst(".match-history__item__character > span"); //최근매치-캐릭터		
			
			
			strmmr = String.valueOf(mmr);
			strmmr = strmmr.replace("<b>", "");
			strmmr = strmmr.replace("</b>", "");
			
			String strrank = String.valueOf(rank.child(0)).replace("<span class=\"text-gray d-block\">", "");
			strrank = strrank.replace("</span>", "");
			String strrank2 = String.valueOf(rank.child(1)).replace("<span class=\"text-gray d-block\">", "");
			strrank2 = strrank2.replace("</span>", "");
			String strrank3 = String.valueOf(rank.child(2)).replace("<span class=\"text-gray d-block\">", "");
			strrank3 = strrank3.replace("</span>", "");
			
			String imgUrl = String.valueOf(img);
			imgUrl = imgUrl.replace("<div class=\"player-header__image\" style=\"background-image: url(", "");
			imgUrl = imgUrl.replace(");\"></div>", "");
						
			String strmode = String.valueOf(match_mode).replace("<span class=\"match-history__item__summary__team-mode\">", "");
			strmode = strmode.replace("</span>", "");

			String strk = String.valueOf(match_kah.child(0));
			strk = strk.replace("<b class=\"d-inline-block\">", "");
			strk = strk.replace("</b>","");
			
			String stra = String.valueOf(match_kah.child(2));
			stra = stra.replace("<b class=\"d-inline-block\">", "");
			stra = stra.replace("</b>","");
			
			String strh = String.valueOf(match_kah.child(4));
			strh = strh.replace("<b class=\"d-inline-block\">", "");
			strh = strh.replace("</b>","");
			
			String strkah = strk +"/"+stra + "/" + strh;
			
			String strranking = String.valueOf(match_ranking).replace("<b class=\"match-history__item__summary__rank\">", "");
			strranking = strranking.replace("</b>", "");
			
			String strdmg = String.valueOf(match_dmg).replace("<b>", "");
			strdmg = strdmg.replace("</b>", "");
			
			String strcharacter = String.valueOf(match_character).replace("<span>", "");
			strcharacter = strcharacter.replace("</span>", "");
			
			list.add("mmr : " + strmmr); //list 0
			list.add(strrank); //list 1
			list.add(strrank2); //list 2
			list.add(strrank3); //list 3
			list.add(imgUrl); //list 4
			list.add(strranking); //list 5
			list.add(strmode); //list 6
			list.add(strkah); //list 7
			list.add(strdmg); //list 8
			list.add(strcharacter); //list 9
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("인터넷 연결 실패");
			list.add("해당유저의 정보가 존재하지않거나, 최근매치가 랭크가 아닙니다.");
		}
			return list;

	}

}
