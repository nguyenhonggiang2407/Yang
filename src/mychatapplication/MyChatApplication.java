    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mychatapplication;

import Chat.Chat_Client;
import Chat.Chat_Server;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MyChatApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String role;
        if (args.length == 0 && !GraphicsEnvironment.isHeadless()) {
            int[] choice = new int[1];
            EventQueue.invokeAndWait(() -> choice[0] = JOptionPane.showOptionDialog(
                    null, "Mở Server trước, sau đó chạy lại để mở Client.",
                    "Java Swing TCP Chat", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, new String[] {"Server", "Client"}, "Server"));
            if (choice[0] < 0) return;
            role = choice[0] == 0 ? "server" : "client";
        } else {
            role = args.length == 1 ? args[0] : "--help";
        }
        switch (role) {
            case "server" -> Chat_Server.main(new String[0]);
            case "client" -> Chat_Client.main(new String[0]);
            default -> System.out.println("Usage: MyChatApplication [server|client]. Start server first.");
        }
    }
    
}
