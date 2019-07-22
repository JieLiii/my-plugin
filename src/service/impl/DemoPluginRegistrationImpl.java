package service.impl;

import actions.DemoPlugin;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import org.jetbrains.annotations.NotNull;
import service.DemoPluginRegistration;

public class DemoPluginRegistrationImpl implements DemoPluginRegistration {
    @NotNull
    public String getComponentName() {
        return "DemoPlugin";
    }

    public void initComponent() {
        ActionManager am = ActionManager.getInstance();
        DemoPlugin demoPlugin = new DemoPlugin();

        am.registerAction("demoPlugin", demoPlugin);

        DefaultActionGroup windowsM = (DefaultActionGroup) am.getAction("WindowMenu");

        windowsM.addSeparator();
        windowsM.add(demoPlugin);
    }

    // Disposes system resources.
    public void disposeComponent() {
    }

}
