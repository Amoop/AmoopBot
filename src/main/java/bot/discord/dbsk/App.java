package bot.discord.dbsk;

import discord.*;
import bot.discord.api.*;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class App 
{
	//Declare the variable discord, making it static so we can use it in other methods.
	public static Discord discord;
    public static void main( String[] args ){    	
    	//Initialise the Discord Bot with your token.
    	discord = new Discord(Constants.TOKEN);
		
    	//Set name
    	discord.setName("Discord Bot Starter Kit");
    	
        //Send a message.
        discord.sendMessage(discord.getStatusMessage());

        //Set up Music
        Music.setDiscord(discord);
        Music.configureMusic();

    }
    
    public static void messageEvent(MessageReceivedEvent evt) {
    	//When a message is sent, this method will be called.
    	//evt contains all the information you need about the message.
        Message objMsg= evt.getMessage();
        MessageChannel objMsgCh = evt.getChannel();
        
        if(!objMsg.getContentRaw().startsWith(Constants.PREFIX)){
            return;
        }
        
        String command = objMsg.getContentRaw().substring(1);
        try{
                command = objMsg.getContentRaw().substring(1,objMsg.getContentRaw().indexOf(" "));
        }catch(Exception e){
            
        }
        String input="";
        try{
               input = objMsg.getContentRaw().substring(objMsg.getContentRaw().indexOf(" "));
        }catch(Exception e){
            
        }
        
        if (command.equals("repeat")){
            for (int i=0; i<5; i++){
                discord.sendMessage("urmom");
            }
        }
        else if (command.equals("mention")){
            for (int i=0; i<5; i++){
                discord.sendMessage("<@!224675715612672001>");
            }
        }
        
        else if (command.equals("ping")){
            discord.sendMessage("Pong");
        }
        else if (command.equals("spongebob")){
            String output=("");
            for (int k=0; k<input.length(); k++){
                output+=input.substring(k,k+1) + (" ");
                discord.sendMessage(output);
            }
        }
        else if (command.equals("isaaronbiggay")){
            int l=(int)(Math.random()*2)+1;
            if (l==1){
                discord.sendMessage("yes he big gay");
            }
            else if (l==2){
                discord.sendMessage("you rolled a 2 but he still big gay");
            }
        }
        else if (command.equals("news")){
            String json = "";
            try{
                json = API.requestAPI("https://newsapi.org/v2/top-headlines?country=ca&apiKey=d84cd61388cb4e949872d398e65fe20a");
            }catch(Exception e){}
            JsonObject News = (JsonObject)(new JsonParser().parse(json).getAsJsonObject());
            
            String url = News.get("articles").getAsJsonArray().get(0).getAsJsonObject().get("url").getAsString();
            discord.sendMessage(url);
            
        }
        
        else if (command.equals("wumpus")){
            discord.sendMessage("https://github.com/Amoop/AmoopBot/raw/master/wumpus.png");
        }
        
        
        else if (command.equals("join")){
            Music.joinChannel(493168112338862082L);
        }
        
        else if (command.equals("play")){
            System.out.println(input);
            Music.play("https://www.youtube.com/watch?v=y6120QOlsfU");
        }
        
        else if (command.equals("leave")){
            Music.exitChannel();
        }
        
        else if (command.equals("flip")){
            int flip=(int)(Math.random()*2)+1;
            if (flip==1){
                discord.sendMessage("Heads <:andy:517224895357386763>");
            }
            else if (flip==2){
                discord.sendMessage("Tails");
            }
        }
        else if (command.equals("nepu")){
            nepu();
        }
        
    }
    
    public void nepu(){
        discord.sendMessage("<@!259191629049626634>");
        discord.sendMessage("```````.---......``..-----:/+ssyyyyyss+/:-::-------:::----------.``...\n" +
"```````.---......``..:oydNNmmmNNNNNmNNNNNdho:-//---::-----------.``...\n" +
"```````.---......`-odNNNNmmmNNNNNNNNmmNNNmmdNNdNh//+/-----------.``...\n" +
"```````.---...../yNNNNNdmNNNNNmNNNMMmNdNMNmhmMMNNNMmds----------.``...\n" +
"```````.---...-smdmNdmmdNNNNNNmNMNNNmNNhmmmMmdNMMMNMNds---------.``...\n" +
"```````.---.-/hNNdMMmmddNNNNmmdmNmNNmNNdhdhmNNNmNNmmNho+--------.``..-\n" +
"```````.---ydmMNNNMMmdNmdNNNdmdhNdmNNNmmhdhhhhhhdNNdmmyso-------.``..-\n" +
"```````.--+mmmMNNMMMNNNdmmNNhmhhmdmNNNmmhdhdmddhhhhyyyyss/------.``..-\n" +
"```````.--ohddNNmNNmhyyymmNNhmhddddNmmdmhhhymdmmdddhdmmdddhyo+:-.``..-\n" +
"```````.-:ossdNmdNNmhhhhdmmmhhhdhhdmmmddhmdhmdhmdddmddmNNmdyyyyo/``.--\n" +
"```````.-osyyyhhhhhhyhhdydddhhNmhhdmmdmhmNNhmdhmddNdmmhdmNNmy/--.``.--\n" +
"```````-+yhhhhyshhdhdmhdyddhhNMNdydmdddmNNNddmdmhhNmhdmdhyoyhdho:``.--\n" +
".``````/hdddddymddmdmmhNhhmhmNNNmymddddNNyos//+yydNmhhhhhhs::::::``.-.\n" +
"..``.:ydmmmdhhmmymmmNNhdddhyyoooyhdddNNMmh:-./ssydmyyhhdmmmho/::-.``:-\n" +
"..-odNNNmmhhhmmhhmmdNNdy/sh::.`:odNmNMNMMMdsyyyhymhyssyhmmNNNNhs:-.``-\n" +
"+ymmdmddhshhddhhhddymNms+mMdsyyyomNNNNNNNMMNhmNmydhhysyssddhddddhs/.`.\n" +
"....sdho:+yyhhhhhhhyhmmyhdNNNdydNNNMNNNNNMMNNNNNshhhdoyysyyh+o+/-::-..\n" +
"..-hy/--/hhddhhhyosyhhmhymNNNNNNNNNMMMNNMMMNNNNNohhdmyyyyys/o++/:./:-.\n" +
"..:...-oddddhhdhsosshhhdhdNNNNNNNMMNNNNNNNMNNNNhsdhmNhhyyssoo+oo+:://-\n" +
"....-/dmmmdhdmyyssoshdddhsmNNNMMMNMNNNNNNNMMNNyoydhNNhyhyyyysyyysooo+/\n" +
".--:yNNmdysmNysyssssddmNhsohmNMMMMNNMMMMMNNmhsyohymNNdhmmdhhhhhhhyssos\n" +
"--+yysoooshmooyy+os+mdmNdy+soshdmNMNNNNNNhyosdmyyhNNNdh+++++++++++++o+\n" +
"-::::---./y-./yo.-o-hNmNNh//s+ooohhdddddysdsdNmoymNNmhd/--............\n" +
"...```.../.../s...+oymNNNNs-+/:oodddmmmmyo+/:///dNmmdomo------..-:-...\n" +
".-----::-:::://::+yoyhmNNNm+/omhhdddddmmmdmm+++hmymm+/ys/////////////:\n" +
"//:::::::/+++//+oho+dhhdNNNmsydddddmdmNNNmmdyshho+msoo+oso++++////////\n" +
"h+:::::::/ymhoooydoomhohmmNNNdmmmmmmmmNNmmmmmmmmhoysso+ohh+++o////////\n" +
"/:::/:::::///oosshddmsoohNhyhmdmNNNNNNNNNNNNNmmdsyyyoshmhsso+//////+//");
    }
    public static void emojiEvent(MessageReactionAddEvent evt) {
    	//When an emoji is added to a message, this method will be called.
    	//evt contains all the information you need about the emoji.
    }
}
