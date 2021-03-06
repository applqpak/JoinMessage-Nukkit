package applqpak.JoinMessage;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Config;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.Player;

import java.util.LinkedHashMap;
import java.io.File;

public class Main extends PluginBase implements Listener
{

  public Config config;

  public LinkedHashMap cfg = new LinkedHashMap();

  public String implode(String glue, String[] strArray)
  {

    String ret = "";

    for(int i = 0; i < strArray.length; i++)
    {

      if(strArray[i].trim() != "")
      {

        ret += (i == strArray.length - 1) ? strArray[i] : strArray[i] + glue;

      }

    }

    return ret;

  }

  @Override

  public void onEnable()
  {

    this.cfg.put("message", new String("Thanks for joining!"));

    this.getDataFolder().mkdirs();

    this.config = new Config(new File(this.getDataFolder(), "config.yml"), Config.YAML, this.cfg);

    this.getServer().getPluginManager().registerEvents(this, this);

    this.getLogger().info(TextFormat.GREEN + "Enabled.");

  }

  @EventHandler

  public void onPlayerJoin(PlayerJoinEvent event)
  {

    Player player = event.getPlayer();

    String joinMessage = String.valueOf(this.config.get("message"));

    player.sendMessage(joinMessage);

  }

  @Override

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {

    switch(cmd.getName())
    {

      case "joinmessage":

        if(args.length == 0)
        {

          sender.sendMessage(TextFormat.RED + "Invalid usage. Usage: /joinmessage set < message >");

        }
        else
        {

          if(args[0] == "set")
          {

            sender.sendMessage(TextFormat.RED + "Invalid usage. Usage: /joinmessage set < message >");

          }
          else
          {

            if(args.length == 1)
            {

              sender.sendMessage(TextFormat.RED + "Invalid usage. Usage: /joinmessage set < message >");

            }
            else
            {

              args[0] = "";

              this.config.set("message", this.implode(" ", args));

              this.config.save();

              sender.sendMessage(TextFormat.GREEN + "Successfully set the join message.");

            }

          }

        }

      break;

    }

    return true;

  }

  @Override

  public void onDisable()
  {

    this.getLogger().info(TextFormat.RED + "Disabled.");

  }

}
