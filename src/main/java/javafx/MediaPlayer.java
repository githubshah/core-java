package javafx;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.media.*;

public class MediaPlayer
{
    public static void main( String[] args ) throws Exception {
        final JFrame frame = new JFrame("MediaPlayer");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        URL url = new URL( "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-avi-file.avi" );
        final Player player = Manager.createPlayer( url );

        player.addControllerListener( new ControllerListener() {
            public void controllerUpdate( ControllerEvent ce ) {
                if ( ce instanceof RealizeCompleteEvent )
                {
                    Component visual = player.getVisualComponent();
                    Component control = player.getControlPanelComponent();
                    if ( visual != null )
                        frame.add( visual, BorderLayout.CENTER );
                    frame.add( control, BorderLayout.SOUTH );
                    frame.pack();
                    frame.setVisible( true );
                    player.start();
                }
            }
        });

        player.realize();
    }
}