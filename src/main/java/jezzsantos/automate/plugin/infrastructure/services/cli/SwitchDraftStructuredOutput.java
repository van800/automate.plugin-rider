package jezzsantos.automate.plugin.infrastructure.services.cli;

import com.jetbrains.rd.util.UsedImplicitly;
import jezzsantos.automate.plugin.application.interfaces.drafts.DraftLite;

import java.util.ArrayList;
import java.util.List;

class SwitchDraft {

    public String Name;
    public String DraftId;

    @SuppressWarnings("unused")
    public String ToolkitName;
    public String ToolkitId;
    public String Version;
}

public class SwitchDraftStructuredOutput extends StructuredOutput<SwitchDraft> {

    @UsedImplicitly
    public SwitchDraftStructuredOutput() {

        super(new ArrayList<>(List.of(new StructuredOutputOutput<>() {{
            this.Values = new SwitchDraft();
        }})));
    }

    @SuppressWarnings("UnusedReturnValue")
    public DraftLite getDraft() {

        var values = this.Output.get(0).Values;
        return new DraftLite(values.DraftId, values.Name, values.ToolkitId, values.Version, true);
    }
}
