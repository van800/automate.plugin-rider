package jezzsantos.automate.plugin.infrastructure.settings;

import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.Project;
import jezzsantos.automate.plugin.infrastructure.AutomateBundle;
import jezzsantos.automate.plugin.infrastructure.AutomateService;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

public class ProjectSettingsConfigurable implements SearchableConfigurable {
    private final Project project;
    private ProjectSettingsComponent settingsComponent;

    public ProjectSettingsConfigurable(Project project) {
        this.project = project;
    }

    @SuppressWarnings("DialogTitleCapitalization")
    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return AutomateBundle.message("settings.Title");
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {
        return settingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        var automateService = new AutomateService();
        settingsComponent = new ProjectSettingsComponent(this.project, automateService);
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        ProjectSettingsState settings = ProjectSettingsState.getInstance(project);
        var modified = settingsComponent.getDeveloperMode() != settings.developerMode.getValue();
        modified |= !Objects.equals(settingsComponent.getPathToAutomateExecutable(), settings.pathToAutomateExecutable.getValue());
        return modified;
    }

    @Override
    public void apply() {
        ProjectSettingsState settings = ProjectSettingsState.getInstance(project);
        settings.developerMode.setValue(settingsComponent.getDeveloperMode());
        settings.pathToAutomateExecutable.setValue(settingsComponent.getPathToAutomateExecutable());
    }

    @Override
    public void reset() {
        ProjectSettingsState settings = ProjectSettingsState.getInstance(project);
        settingsComponent.setDeveloperMode(settings.developerMode.getValue());
        settingsComponent.setPathToAutomateExecutable(settings.pathToAutomateExecutable.getValue());
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }

    @Override
    public @NotNull
    @NonNls String getId() {
        return "jezzsantos.automate.infrastructure.settings.ProjectSettingsConfigurable";
    }
}
