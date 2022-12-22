package Core.Helper;

import Core.Model.Graph;
import Core.Utils.GraphPanel;

import javax.swing.*;

public class InterfaceHelper {
    public static void show(Graph graph){
        GraphPanel panel = new GraphPanel(graph);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
