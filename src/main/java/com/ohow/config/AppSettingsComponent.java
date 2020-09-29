package com.ohow.config;

import javax.swing.*;

public class AppSettingsComponent {
    private JPanel basePanel;
    /**
     * 用户id
     */
    private JTextField appId;
    /**
     * 用户secret
     */
    private JTextField appSecret;
    private JLabel tips;
    /**
     * 获取城市，省
     */
    private JComboBox province;
    /**
     * 获取城市，市
     */
    private JComboBox city;
    /**
     * 获取城市，县
     */
    private JComboBox county;
    /**
     * 添加城市
     */
    private JButton save;
    /**
     * 移除城市
     */
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
