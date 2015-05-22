package me.cashvillan.redvsblue;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class FileManager {
	
	//fileloading
    public static FileConfiguration playersConfig;
    public static File playersFile;

    public static void loadplayersConfig() {
		playersFile = new File(Main.getInstance().getDataFolder(), "players.yml");
		    if (!playersFile.exists()) {
		        try {
		        	playersFile.createNewFile();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		    playersConfig = YamlConfiguration.loadConfiguration(playersFile);
		}
    }
    
    public static FileConfiguration getPlayersConfig() {
    	return playersConfig;
    }
    
    public static void saveplayersConfig() {
    	try {
			playersConfig.save(playersFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    //filemanagement
	public static void setValue(Player player, String key, Object value) {
		FileManager.getPlayersConfig().set("players." + player.getName() + "." + key, value);
		FileManager.saveplayersConfig();
	}
	
	public static Object getValue(Player player, String key) {
		return FileManager.getPlayersConfig().get("players." + player.getName() + "." + key);
	}
	
	public static boolean hasValue(Player player, String key) {
		return FileManager.getPlayersConfig().contains("players." + player.getName() + "." + key);
	}
}
