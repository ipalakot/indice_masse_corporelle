package com.example.indicedemassegraisseuse.model;

public class Profil {


    // Constantes
    private static final Integer minFemme = 15; // Maigre si au dessous
    private static final Integer maxFemme = 30; // Gros si au dessou
    private static final Integer minHomme = 10; // Maigre si au dessous
    private static final Integer maxHomme = 25; // Gros si au dessou

    // Variable
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private String message;
    private Float img;

    /**
     * Constructeur
     *
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculImg();
        this.resulImg();
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }
    public String getMessage() {
        return message;
    }

    public Float getImg() {

        return img;
    }

    /**
     *
     */
    private void calculImg(){

        float tailleM = ((float)taille) / 100;
        this.img = (float)((1.2*poids / (tailleM*tailleM))*(0.23*age)-(10.83*sexe) - 5.4);
    }

    /**
     *
     */
    public void resulImg(){
        Integer min;
        Integer max;

        if (sexe == 0) {//Le cas d'une Femme
            min = minFemme;
        max = maxFemme;

        } else  { // / Le cas d'un homme
            min = minHomme;
            max= maxHomme;
            }

    // Gestion  des Messages
        message = "normal";
        if (img < min){
            message ="trop maigre";
        } else {
            if (img > max) {
                message = "bien Gros!";
            }
            }
    }
}
