package com.mycompany.catalogozapatos.good;

public class Calzado {

    private String estilo;

    private ICierre cierre;
    private IMaterial material;


    public Calzado(String estilo, ICierre cierre, IMaterial material) {
        this.estilo=estilo;
        this.cierre = cierre;
        this.material = material;

    }

    public ICierre getCierre() {
        return cierre;
    }

    public void setCierre(ICierre cierre) {
        this.cierre = cierre;
    }

    public IMaterial getMaterial() {
        return material;
    }

    public void setMaterial(IMaterial material) {
        this.material = material;
    }

    public String getDescripcion() {
        return this.estilo + "\n" +
                this.getMaterial().getDescripcionMaterial() + "\n"
                + this.getCierre().getDescripcionCierre();
    }
}
