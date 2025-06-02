package org.example.encapsuladoporclase;

public class ProcesadorImpuesto {

    public static double getTasaImpuesto(String pais, String estado){

        if(pais.equals("CH")){
            return ProcesadorImpuesto.getTasaChina();
        }else if(pais.equals("US")){
            return ProcesadorImpuesto.getTasaUSA(estado);

        }else{
            return ProcesadorImpuesto.getTasaEU(pais);
        }

    }

    private static double getTasaUSA(String estado){
            if(estado.equals("MIAMI")){
                return 0.4;
            }else if(estado.equals("OHIO")){
                return 0.2;
            }
            else{
                return 0.1;
            }

    }

    private static double getTasaEU(String pais){
        if(pais.equals("ES")){
            return 0.15;
        }
        else  if(pais.equals("EN")){
            return 0.05;
        }
        else{
            return 0.25;
        }
    }

    private static double getTasaChina(){
        return 0.03;
    }

}
