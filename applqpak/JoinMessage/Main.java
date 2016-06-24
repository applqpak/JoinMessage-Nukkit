package applqpak.JoinMessage;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Config;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.PlayerJoinEvent;
import cn.nukkit.Player;

import java.util.LinkedHashMap;
import java.io.File;

public class Main extends PluginBase implements Listener
{

  public Config config;

  public LinkedHashMap cfg = new LinkedHashMap();

  @Override

  public void onEnable()
  {

    this.cfg.put("message", new String("Thanks for joining!"));

    this.getDataFolder().mkdirs();

    this.config = new Config(new File(this.getDataFolder(), "config.yml"), Config.YAML, this.cfg);

    this.getLogger().info(TextFormat.GREEN + "Enabled.");

  }

  @Override

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {

    return true;

  }

  @Override

  public void onDisable()
  {

    this.getLogger().info(TextFormat.RED + "Disabled.");

  }

}
