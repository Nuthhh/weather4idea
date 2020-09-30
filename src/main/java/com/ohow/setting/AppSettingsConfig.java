package com.ohow.setting;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AppSettingsConfig implements SearchableConfigurable {

    private AppSettingsComponent myAppSettingsComponent;


    @Override
    public @NotNull String getId() {
        return null;
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "Weather Config";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return myAppSettingsComponent.getPreferredFocusedComponent();
    }

    @Override
    public @Nullable JComponent createComponent() {
        myAppSettingsComponent = new AppSettingsComponent();
        return myAppSettingsComponent.getBasePanel();
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.setAppId(myAppSettingsComponent.getAppId());


    }

    @Override
    public void reset() {
        // 通过该方法加载值
    }
}
