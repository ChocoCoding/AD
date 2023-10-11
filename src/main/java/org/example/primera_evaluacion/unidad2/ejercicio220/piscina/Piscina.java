package org.example.primera_evaluacion.unidad2.ejercicio220.piscina;

import java.io.*;

public class Piscina implements Serializable {

    private double largoPiscina;
    private double anchoVaso;
    private double largoParcela;
    private double anchoParcela;

    public Piscina(double largoPiscina, double anchoVaso, double largoParcela, double anchoParcela) {
        this.largoPiscina = largoPiscina;
        this.anchoVaso = anchoVaso;
        this.largoParcela = largoParcela;
        this.anchoParcela = anchoParcela;
    }

    public double getLargoPiscina() {
        return largoPiscina;
    }

    public void setLargoPiscina(double largoPiscina) {
        this.largoPiscina = largoPiscina;
    }

    public double getAnchoVaso() {
        return anchoVaso;
    }

    public void setAnchoVaso(double anchoVaso) {
        this.anchoVaso = anchoVaso;
    }

    public double getLargoParcela() {
        return largoParcela;
    }

    public void setLargoParcela(double largoParcela) {
        this.largoParcela = largoParcela;
    }

    public double getAnchoParcela() {
        return anchoParcela;
    }

    public void setAnchoParcela(double anchoParcela) {
        this.anchoParcela = anchoParcela;
    }

    public static void write(Piscina object, String ruta){
        File file = new File(ruta);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (file.length() == 0) {
        try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        } else {
            try(AppendingOutputStream aos = new AppendingOutputStream(fos)){
                aos.writeObject(object);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Piscina read(String ruta){
        File file = new File(ruta);
        ObjectInputStream ois = null;
        Piscina piscina = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true){
                piscina = (Piscina) ois.readObject();
                System.out.println(piscina);
            }
        }catch (EOFException eof){
            return piscina;
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Piscina{");
        sb.append("largoPiscina=").append(largoPiscina);
        sb.append(", anchoVaso=").append(anchoVaso);
        sb.append(", largoParcela=").append(largoParcela);
        sb.append(", anchoParcela=").append(anchoParcela);
        sb.append('}');
        return sb.toString();
    }
}
