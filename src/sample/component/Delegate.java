package sample.component;

import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;

/**
 * Created by alex on 4/29/17.
 */
public interface Delegate {

    EventHandler onCloseBtnAction();

    EventHandler onDragBtnAction();

    ChangeListener onNameFieldChange();

    ChangeListener onDescrFieldChange();

    EventHandler onStateBoxChange();




}
