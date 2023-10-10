package org.example.primera_evaluacion.unidad2.ejercicio220.piscina;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendingOutputStream extends ObjectOutputStream {
    public AppendingOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        return;
    }
}
