package sample.component;

/**
 * Created by alex on 4/29/17.
 */
public class FieldConfigurationModel implements FieldEditorModel{

    private String header;
    private String nameField;
    private String descrField;
    private boolean isMandatory = true;

    public FieldConfigurationModel(String nameField, String descrField) {
        this.nameField = nameField;
        this.descrField = descrField;
    }

    public FieldConfigurationModel(String header, String nameField, String descrField) {
        this.header = header;
        this.nameField = nameField;
        this.descrField = descrField;
    }

    public FieldConfigurationModel(String header, String nameField, String descrField, boolean isMandatory) {
        this.header = header;
        this.nameField = nameField;
        this.descrField = descrField;
        this.isMandatory = isMandatory;
    }

    @Override
    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public void setName(String name) {
        nameField = name;
    }

    @Override
    public String getName() {
        return nameField;
    }

    @Override
    public void setDescription(String description) {
        descrField = description;
    }

    @Override
    public String getDescription() {
        return descrField;
    }

    @Override
    public boolean isManadatory() {
        return isMandatory;
    }

    @Override
    public void setManadatory(boolean mandatory) {
        isMandatory = mandatory;
    }
}
