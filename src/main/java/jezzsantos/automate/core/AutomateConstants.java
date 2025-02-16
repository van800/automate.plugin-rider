package jezzsantos.automate.core;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AutomateConstants {

    public static final String PatternNameRegex = "^[a-zA-Z\\d_\\.\\-]+$";
    public static final String DraftNameRegex = "^[a-zA-Z\\d_\\.\\-]+$";
    public static final String AttributeNameRegex = "^[a-zA-Z\\d_\\.\\-]+$";
    public static final List<AutomateConstants.AttributeDataType> AttributeDataTypes =
      List.of(AttributeDataType.STRING, AttributeDataType.BOOLEAN, AttributeDataType.INTEGER, AttributeDataType.FLOAT, AttributeDataType.DATETIME);
    public static final String OutputStructuredShorthand = "--os";
    public static final List<String> OutputStructuredAliases = List.of(OutputStructuredShorthand, "--output-structured");
    public static String ExecutableName = "automate";
    public static String ToolkitFileExtension = "toolkit";
    public static String MinimumSupportedVersion = "1.0.2";
    public static List<String> ReservedAttributeNames = List.of("Id", "DisplayName", "Description", "ConfigurePath", "Schema", "Items");
    public static String InstallationInstructionsUrl = "https://jezzsantos.github.io/automate/installation/#jetbrains-ide-plugin";

    public enum SchemaType {
        @SerializedName("None")
        NONE("None", "None"),
        @SerializedName("Pattern")
        PATTERN("Pattern", "Pattern"),
        @SerializedName("Element")
        ELEMENT("Element", "Element"),
        @SerializedName("EphemeralCollection")
        EPHEMERALCOLLECTION("EphemeralCollection", "Collection"),
        @SerializedName("CollectionItem")
        COLLECTIONITEM("CollectionItem", "Collection Item"),
        @SerializedName("Attribute")
        ATTRIBUTE("Attribute", "Attribute");
        private final String value;
        private final String displayName;

        SchemaType(String value, String displayName) {

            this.value = value;
            this.displayName = displayName;
        }

        @SuppressWarnings("unused")
        public String getDisplayName() {return this.displayName;}

        public String getValue() {return this.value;}

        @Override
        public String toString() {

            return this.displayName;
        }
    }

    public enum ElementCardinality {
        @SerializedName("One")
        ONE,
        @SerializedName("ZeroOrOne")
        ZERO_OR_ONE,
        @SerializedName("ZeroOrMany")
        ZERO_OR_MANY,
        @SerializedName("OneOrMany")
        ONE_OR_MANY,
    }

    public enum AttributeDataType {
        @SerializedName("string")
        STRING("string", "string"),
        @SerializedName("bool")
        BOOLEAN("bool", "boolean"),
        @SerializedName("int")
        INTEGER("int", "integer"),
        @SerializedName("float")
        FLOAT("float", "number"),
        @SerializedName("datetime")
        DATETIME("datetime", "date and time");
        private final String displayName;
        private final String value;

        AttributeDataType(String value, String displayName) {

            this.value = value;
            this.displayName = displayName;
        }

        public String getValue() {return this.value;}

        public String getDisplayName() {return this.displayName;}

        @Override
        public String toString() {

            return this.displayName;
        }
    }

    public enum AutomationType {
        @SerializedName("CodeTemplateCommand")
        CODE_TEMPLATE_COMMAND("CodeTemplate Command"),
        @SerializedName("CliCommand")
        CLI_COMMAND("CLI Command"),
        @SerializedName("CommandLaunchPoint")
        COMMAND_LAUNCH_POINT("LaunchPoint");
        private final String displayName;

        AutomationType(String displayName) {

            this.displayName = displayName;
        }

        public String getDisplayName() {return this.displayName;}

        @Override
        public String toString() {

            return this.displayName;
        }
    }

    public enum CommandExecutionLogItemType {

        @SerializedName("Succeeded")
        SUCCEEDED("Succeeded"),
        @SerializedName("Warning")
        WARNING("Warning"),
        @SerializedName("Failed")
        FAILED("Failed");
        private final String displayName;

        CommandExecutionLogItemType(String displayName) {

            this.displayName = displayName;
        }

        @Override
        public String toString() {

            return this.displayName;
        }
    }
}
