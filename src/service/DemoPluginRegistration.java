package service;

import com.intellij.openapi.components.ServiceManager;

public interface DemoPluginRegistration {
    static DemoPluginRegistration getInstance() {
        return ServiceManager.getService(DemoPluginRegistration.class);
    }
}
