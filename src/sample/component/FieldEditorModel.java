package sample.component;

/**
 * Created by alex on 4/17/17.
 */
public interface FieldEditorModel {
    void setHeader(String header);

    String getHeader();

    void setName(String name);

    String getName();

    void setDescription(String description);

    String getDescription();

    boolean isManadatory();

    void setManadatory(boolean mandatory);
}
