package com.clientui.beans;

public class ExpeditionBean {

    private int id;

    private Integer idCommande;

    private Integer etat;

    private String etatLibelle;

    private String etatLibelleClass;

    private static final String EXPEDITION_NO_INFO = "Pas d'information";
    private static final String EXPEDITION_EN_PREPARATION = "En préparation";
    private static final String EXPEDITION_EXPEDIEE = "Expédiée";
    private static final String EXPEDITION_LIVREE = "Livrée";

    private static final String EXPEDITION_CLASS_NO_INFO = "text-danger";
    private static final String EXPEDITION_CLASS_EXPEDIEE = "text-success";
    private static final String EXPEDITION_CLASS_LIVREE = "text-success";
    private static final String EXPEDITION_CLASS_EN_PREPARATION = "text-warning";


    public ExpeditionBean() {
    }

    public ExpeditionBean(int id, Integer idCommande, Integer etat, String etatLibelle, String etatLibelleClass) {
        this.id = id;
        this.idCommande = idCommande;
        this.etat = etat;
        this.etatLibelle = etatLibelle;
        this.etatLibelleClass = etatLibelleClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {

        this.etat = etat;

        switch (etat) {
            case 0:
                setEtatLibelle(EXPEDITION_EN_PREPARATION);
                setEtatLibelleClass(EXPEDITION_CLASS_EN_PREPARATION);
                break;
            case 1:
                setEtatLibelle(EXPEDITION_EXPEDIEE);
                setEtatLibelleClass(EXPEDITION_CLASS_EXPEDIEE);
                break;
            case 2:
                setEtatLibelle(EXPEDITION_LIVREE);
                setEtatLibelleClass(EXPEDITION_CLASS_LIVREE);
                break;
            default:
                setEtatLibelle(EXPEDITION_NO_INFO);
                setEtatLibelleClass(EXPEDITION_CLASS_NO_INFO);
                break;
        }
    }

    public String getEtatLibelle() {
        return etatLibelle;
    }

    public void setEtatLibelle(String etatLibelle) {
        this.etatLibelle = etatLibelle;
    }

    public String getEtatLibelleClass() {
        return etatLibelleClass;
    }

    public void setEtatLibelleClass(String etatLibelleClass) {
        this.etatLibelleClass = etatLibelleClass;
    }
}
