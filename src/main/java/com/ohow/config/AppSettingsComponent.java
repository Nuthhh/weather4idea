package com.ohow.config;

import javax.swing.*;

public class AppSettingsComponent {
    private JPanel basePanel;
    private JTextField appId;
    private JTextField appSecret;
    private JLabel tips;
    private JComboBox province;
    private JComboBox city;
    private JComboBox county;
    private JButton save;
    private JButton remove;

    public JPanel getBasePanel() {
        return basePanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return appId;
    }

    public String getAppId() {
        return appId.getText();
    }


}
