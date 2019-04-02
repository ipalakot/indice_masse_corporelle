package com.example.indicedemassegraisseuse.controleur;

import com.example.indicedemassegraisseuse.model.Profil;

public final class Controle {

    private static Controle instance = null;
    private Profil profil;

    /**
     * Constructeur Privé
     */
    private Controle() {
        super();
    }

    /**
     * Creation de l'istance
     * @return Instance
     */
    public  static final Controle getInstance(){
            if (Controle.instance == null){
                Controle.instance = new Controle();
            }
            return Controle.instance;
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
