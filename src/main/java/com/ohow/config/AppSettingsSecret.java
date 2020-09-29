package com.ohow.config;


import com.intellij.credentialStore.CredentialAttributes;
import com.intellij.credentialStore.CredentialAttributesKt;
import com.intellij.credentialStore.Credentials;
import com.intellij.ide.passwordSafe.PasswordSafe;

public class AppSettingsSecret {

    private static final String SYSTEM_NAME = "ohow weather plugin";

    public static void save(String username, String password) {
        CredentialAttributes credentialAttributes = createCredentialAttributes(username);
        Credentials credentials = new Credentials(username, password);
        PasswordSafe.getInstance().set(credentialAttributes, credentials);
    }

    public static String get(String username) {
        CredentialAttributes credentialAttributes = createCredentialAttributes(username);
        return PasswordSafe.getInstance().getPassword(credentialAttributes);
    }

    private static CredentialAttributes createCredentialAttributes(String key) {
        return new CredentialAttributes(CredentialAttributesKt.generateServiceName(SYSTEM_NAME, key));
    }
}
