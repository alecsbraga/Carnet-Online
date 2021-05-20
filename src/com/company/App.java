package com.company;

import javax.swing.*;
import java.sql.*;

public class App extends JFrame{
    private static JFrame frame;
    private JButton logginButton;
    private JPanel rootPanel;
    private JTextField idField;
    private JPasswordField passField;
    private JComboBox comboBox1;

    public static void main(String[] args){
        frame = new JFrame();
        frame.setContentPane(new App().rootPanel);
        frame.setSize(400,500);
        frame.setTitle("Carnet Online");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public App() {

        logginButton.addActionListener(e -> {
            Connection connection =  null;
            String databaseName = "carnet_online";
            String url = "jdbc:mysql://localhost:3306/"+databaseName;
            String username = "root";
            String password = "alecs2972";

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            Statement connLogg = null;
            try {
                assert connection != null;
                connLogg = connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            ResultSet resConnLogg = null;
            String ID = String.valueOf(comboBox1.getSelectedItem());
            if(ID.equals("Elev")){
            try {
                assert connLogg != null;
                resConnLogg= connLogg.executeQuery("select * from ELEVI;");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            }
            else if(ID.equals("Profesor")){
                try {
                    assert connLogg != null;
                    resConnLogg = connLogg.executeQuery("select * from PROFESORI;");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            else
            {
                try {
                    assert connLogg != null;
                    resConnLogg = connLogg.executeQuery("select * from DIRIGINTI;");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            boolean OkLogging = false;
            try {
                while(true)
                {
                    assert resConnLogg != null;
                    if (!resConnLogg.next()) break;
                    if(resConnLogg.getString(2).equals(idField.getText()) && resConnLogg.getString(3).equals(passField.getText()))
                        OkLogging = true;

                }
                if(OkLogging)
                {
                    JOptionPane.showMessageDialog(null,"Successfully loged, "+idField.getText()+"!");
                    rootPanel.setVisible(false);
                    String name = idField.getText() + " " + passField.getText();
                    if(ID.equals("Elev")) {

                        frame.setContentPane(new AppElev(name, frame).getElevPanel());
                    }
                    else
                    {
                        frame.setContentPane(new AppProfesor(name, frame).getPanelProf());
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong data!");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

}
