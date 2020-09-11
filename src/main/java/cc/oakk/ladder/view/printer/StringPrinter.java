package cc.oakk.ladder.view.printer;

import cc.oakk.ladder.view.printer.impl.StandardPrinter;

public abstract class StringPrinter<T> implements Printer<T> {
    protected final Printer<String> stringPrinter;

    public StringPrinter() {
        this.stringPrinter = StandardPrinter.getInstance();
    }

    public StringPrinter(Printer<String> stringPrinter) {
        if (stringPrinter == null) {
            throw new IllegalArgumentException("stringPrinter is null!");
        }

        this.stringPrinter = stringPrinter;
    }
}