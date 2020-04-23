package com.pfe.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DemandeVoiture {

@Id
@GeneratedValue
private long id;
@OneToOne
private Employe emp;
}
