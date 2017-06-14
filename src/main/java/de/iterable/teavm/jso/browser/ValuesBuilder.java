package de.iterable.teavm.jso.browser;

import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSString;

public class ValuesBuilder {

    private JSArray<JSObject> args = JSArray.create();

    public ValuesBuilder() {
    }

    public ValuesBuilder val(String... values) {
        for (String value : values)
            val(value);
        return this;
    }

    public ValuesBuilder val(String value) {
        args.push(JSString.valueOf(value));
        return this;
    }

    public JSArray<JSObject> build() {
        return this.args;
    }
}
