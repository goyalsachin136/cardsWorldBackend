package com.example.accessingdatamysql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
public class CardSet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String gameCode;

    private String moveIds; // comma separated

    private Boolean isCurrentSet;

    private String winnerPlayerCode;
}
