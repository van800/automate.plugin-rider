package jezzsantos.automate.plugin.infrastructure.services.cli;

import com.jetbrains.rd.util.UsedImplicitly;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("unused")
public final class StructuredError {

    public ArrayList<String> Info = new ArrayList<>();
    public StructuredOutputError Error = new StructuredOutputError();
    public ArrayList<StructuredOutputOutput<HashMap<String, Object>>> Output = null;

    @UsedImplicitly
    public StructuredError() {

    }

    public String getErrorMessage() {
        return String.format("%s", Error.Message);
    }
}
