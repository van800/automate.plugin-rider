package jezzsantos.automate.plugin.infrastructure.ui.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import icons.RiderIcons;
import jezzsantos.automate.plugin.application.IAutomateApplication;
import jezzsantos.automate.plugin.infrastructure.AutomateBundle;
import org.jetbrains.annotations.NotNull;

public class ToggleAuthoringModeToolbarAction extends ToggleAction {
    private final Runnable onPerformed;
    private boolean selected;

    public ToggleAuthoringModeToolbarAction(@NotNull Runnable onPerformed) {
        super();
        this.onPerformed = onPerformed;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {

        var project = e.getProject();
        if (project != null) {
            var application = IAutomateApplication.getInstance(project);
            this.selected = application.isAuthoringMode();
        }

        super.update(e);

        SetPresentation(e);
    }

    @Override
    public boolean isSelected(@NotNull AnActionEvent anActionEvent) {
        return this.selected;
    }

    @Override
    public void setSelected(@NotNull AnActionEvent e, boolean selected) {
        this.selected = !this.selected;

        SetPresentation(e);

        var project = e.getProject();
        if (project != null) {
            var application = IAutomateApplication.getInstance(project);
            application.setAuthoringMode(this.selected);
        }
        this.onPerformed.run();
    }

    @SuppressWarnings("DialogTitleCapitalization")
    private void SetPresentation(@NotNull AnActionEvent e) {
        var message = AutomateBundle.message("action.ToggleAuthoringMode.Title");
        var presentation = e.getPresentation();
        presentation.setDescription(message);
        presentation.setText(message);
        presentation.setIcon(this.selected ? RiderIcons.AltEnter.MenuToggleOn : RiderIcons.AltEnter.MenuToggleOff);

        var project = e.getProject();
        if (project != null) {
            var application = IAutomateApplication.getInstance(project);
            var isAuthoringMode = application.isAuthoringMode();
            presentation.setEnabledAndVisible(isAuthoringMode);
        }
    }
}
