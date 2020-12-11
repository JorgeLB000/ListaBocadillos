package org.jlariob.listabocadillos.dummy;

public class Bocadillo {
    private String nombre;
    private String urlPhoto;
    private float valoracion;

    public Bocadillo(String nombre, String urlPhoto, float valoracion) {
        this.nombre = nombre;
        this.urlPhoto = urlPhoto;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
}

