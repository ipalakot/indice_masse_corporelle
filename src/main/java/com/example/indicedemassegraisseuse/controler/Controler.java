package com.example.indicedemassegraisseuse.controler;

import com.example.indicedemassegraisseuse.model.Profil;

public class Controler {
    private static Controler instance = null;
    private Profil profil;

    /**
     * Constructeur Privé
     */
    private Controler() {
        super();
    }

    /**
     * Creation de l'istance
     * @return Instance
     */
    public  static final Controler getInstance(){
            if (Controler.instance== null){
                Controler.instance = new Controler();
            }
            return Controler.instance;
    }

    /**
     * Creation du nouveau Profil
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public void creerProfil(Integer poids, Integer taille, Integer age,Integer sexe){
        profil = new Profil(poids,taille,age,sexe);
     }

    /**
     * Recuperation de l'IMG du Profil
     * @return IMG du Profil
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * Message lié au Profil
     * @return
     */
    public String getMessage(){
        return profil.getMessage();
    }

}
