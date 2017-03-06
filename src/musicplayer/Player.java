package musicplayer;

import java.io.PrintStream;
import java.util.Map;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;


public class Player implements BasicPlayerListener{
    private PrintStream out = null;//Stream para el debugging
    BasicPlayer player = new BasicPlayer();//Instancia
    
    public Player(){
        player.addBasicPlayerListener(this);//Añado el "escuchador" de eventos
        out = System.out;
    }
    
    BasicController control = (BasicController)player;//Controlador para el player
    
    @Override
    public void opened(Object stream, Map properties) {
        display("opened:"  + properties.toString());//Muestra en consola los datos del archivo abierto
    }

    @Override
    public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {
        display("progress:" + properties.toString());
    }

    @Override
    public void stateUpdated(BasicPlayerEvent event) {
        display("stateUpdate:" + event.toString());
    }

    @Override
    public void setController(BasicController controller) {
        display("setController:" + controller);
    }
    
    public void display(String msg){
        if(out != null){
            out.println(msg);
        }
    }
}
