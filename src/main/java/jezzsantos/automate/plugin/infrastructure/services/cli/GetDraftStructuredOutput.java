package jezzsantos.automate.plugin.infrastructure.services.cli;

import com.jetbrains.rd.util.UsedImplicitly;
import jezzsantos.automate.plugin.application.interfaces.drafts.DraftConfiguration;
import jezzsantos.automate.plugin.application.interfaces.drafts.DraftDetailed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class GetDraftStructuredOutput extends StructuredOutput<DraftDetailed> {

    @UsedImplicitly
    public GetDraftStructuredOutput() {
    }

    @TestOnly
    public GetDraftStructuredOutput(@NotNull String id, @NotNull String name, @NotNull DraftConfiguration configuration) {
        super(new ArrayList<>(List.of(new StructuredOutputOutput<>() {{
            Values = new DraftDetailed(id, name, configuration);
        }})));
    }

    public DraftDetailed getDraft() {
        return this.Output.get(0).Values;
    }
}
