package red.man10;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javax.imageio.ImageIO.*;

/**
 * Created by takatronix on 2017/02/24.
 */
public class ClockFace extends MapRenderer {

    @Override
    public void render(MapView view, MapCanvas canvas, Player player){
        try {

            canvas.drawImage(60,50, read(new URL("http://man10.red/man10_icon.png")));
            LocalDateTime now = LocalDateTime.now();
            String time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(now);

            canvas.drawText (10,60, MinecraftFont.Font,time);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private class LocalDate {
    }
}
