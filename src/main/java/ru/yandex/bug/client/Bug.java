package ru.yandex.bug.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Bug implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel root = RootPanel.get();
        Predicate<Bug> p = Bug::getTrue;
        if (check(p.apply(new Bug()))) {
            root.add(new Label("success"));
        } else {
            root.add(new Label("failed"));
        }
    }

    public boolean getTrue() {
        return true;
    }

    private static final native boolean check(boolean b) /*-{
        console.log("should be 'true': ", b);
        return b != undefined;
    }-*/;
}

interface Predicate<A> {
    boolean apply(A a);
}
