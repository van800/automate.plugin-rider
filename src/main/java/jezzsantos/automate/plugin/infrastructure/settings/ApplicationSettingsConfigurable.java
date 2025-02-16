package jezzsantos.automate.plugin.infrastructure.settings;

import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.serviceContainer.NonInjectable;
import com.jetbrains.rd.util.UsedImplicitly;
import jezzsantos.automate.plugin.application.services.interfaces.IApplicationConfiguration;
import jezzsantos.automate.plugin.common.AutomateBundle;
import jezzsantos.automate.plugin.infrastructure.IOsPlatform;
import jezzsantos.automate.plugin.infrastructure.OsPlatform;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.util.Objects;

public class ApplicationSettingsConfigurable implements SearchableConfigurable {

    @NotNull
    private final IApplicationConfiguration configuration;
    private final IOsPlatform platform;
    private ApplicationSettingsComponent settingsComponent;

    @UsedImplicitly
    public ApplicationSettingsConfigurable() {

        this(IApplicationConfiguration.getInstance(), new OsPlatform());
    }

    @NonInjectable
    @TestOnly
    public ApplicationSettingsConfigurable(@NotNull IApplicationConfiguration configuration, @NotNull IOsPlatform platform) {

        this.configuration = configuration;
        this.platform = platform;
    }

    @SuppressWarnings("DialogTitleCapitalization")
    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {

        return AutomateBundle.message("settings.Title");
    }

    @Nullable
    @Override
    public JComponent createComponent() {

        this.settingsComponent = new ApplicationSettingsComponent(this.platform);
        return this.settingsComponent.getPanel();
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {

        return this.settingsComponent.getPreferredFocusedComponent();
    }

    @Override
    public boolean isModified() {

        var modified = this.settingsComponent.getAuthoringMode() != this.configuration.getAuthoringMode();
        modified |= !Objects.equals(this.settingsComponent.getExecutablePath(), this.configuration.getExecutablePath());
        modified |= !Objects.equals(this.settingsComponent.getViewCliLog(), this.configuration.getViewCliLog());
        modified |= !Objects.equals(this.settingsComponent.getCliInstallPolicy(), this.configuration.getCliInstallPolicy());
        return modified;
    }

    @Override
    public void apply() {

        this.configuration.setAuthoringMode(this.settingsComponent.getAuthoringMode());
        this.configuration.setExecutablePath(this.settingsComponent.getExecutablePath());
        this.configuration.setViewCliLog(this.settingsComponent.getViewCliLog());
        this.configuration.setCliInstallPolicy(this.settingsComponent.getCliInstallPolicy());
    }

    @Override
    public void reset() {

        this.settingsComponent.setAuthoringMode(this.configuration.getAuthoringMode());
        this.settingsComponent.setExecutablePath(this.configuration.getExecutablePath());
        this.settingsComponent.setViewCliLog(this.configuration.getViewCliLog());
        this.settingsComponent.setCliInstallPolicy(this.configuration.getCliInstallPolicy());
    }

    @Override
    public void disposeUIResources() {

        this.settingsComponent = null;
    }

    @Override
    public @NotNull
    @NonNls String getId() {

        return "jezzsantos.automate.infrastructure.settings.ApplicationSettingsConfigurable";
    }
}
