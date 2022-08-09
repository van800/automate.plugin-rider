package jezzsantos.automate.plugin.infrastructure.settings;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.DarculaColors;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.FormBuilder;
import com.intellij.util.ui.UIUtil;
import jezzsantos.automate.core.AutomateConstants;
import jezzsantos.automate.plugin.infrastructure.AutomateBundle;
import jezzsantos.automate.plugin.infrastructure.IAutomateService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProjectSettingsComponent {

    private final JPanel minPanel;
    private final JBCheckBox developerMode = new JBCheckBox(AutomateBundle.message("settings.DeveloperMode.Label.Title"));
    private final TextFieldWithBrowseButton pathToAutomateExecutable = new TextFieldWithBrowseButton();
    private final JBLabel testPathToAutomateResult = new JBLabel();

    public ProjectSettingsComponent(Project project, IAutomateService automateService) {
        pathToAutomateExecutable.setPreferredSize(new Dimension(380, pathToAutomateExecutable.getHeight()));
        var testPathToAutomatePanel = new JPanel();
        testPathToAutomatePanel.setLayout(new BorderLayout());
        testPathToAutomatePanel.add(pathToAutomateExecutable, BorderLayout.LINE_START);
        var testPathToAutomate = new JButton(AutomateBundle.message("settings.TestPathToAutomateExecutable.Label.Title"));
        testPathToAutomatePanel.add(testPathToAutomate, BorderLayout.LINE_END);
        pathToAutomateExecutable.addBrowseFolderListener(AutomateBundle.message("settings.PathToAutomateExecutable.Picker.Title"), null, project, FileChooserDescriptorFactory.createSingleFileOrExecutableAppDescriptor());
        testPathToAutomate.addActionListener(e -> this.onTestPathToAutomate(e, automateService));

        minPanel = FormBuilder.createFormBuilder()
                .addComponent(developerMode, 1)
                .addLabeledComponent(new JBLabel(AutomateBundle.message("settings.PathToAutomateExecutable.Label.Title")), testPathToAutomatePanel, 1, false)
                .addComponentToRightColumn(testPathToAutomateResult)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }


    public JPanel getPanel() {
        return minPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return developerMode;
    }

    public boolean getDeveloperMode() {
        return developerMode.isSelected();
    }

    public void setDeveloperMode(boolean value) {
        developerMode.setSelected(value);
    }

    public String getPathToAutomateExecutable() {
        return pathToAutomateExecutable.getText();
    }

    public void setPathToAutomateExecutable(String value) {
        pathToAutomateExecutable.setText(value);
    }

    private void onTestPathToAutomate(ActionEvent e, IAutomateService automateService) {

        var version = automateService.tryGetExecutableVersion(pathToAutomateExecutable.getText());
        if (version == null) {
            testPathToAutomateResult.setForeground(DarculaColors.RED);
            testPathToAutomateResult.setText(String.format("%s is not installed on this machine!", AutomateConstants.ExecutableName));
        } else {
            testPathToAutomateResult.setFontColor(UIUtil.FontColor.NORMAL);
            testPathToAutomateResult.setText(String.format("%s version is %s", AutomateConstants.ExecutableName, version));
        }

    }
}
