package com.sap.sfsf.reshuffle.comparison.backend.model;

import java.io.Serializable;

public class CandidateId implements Serializable {
    private static final long serialVersionUID = -5911229364264345941L;

    private String caseID;
    private String candidateID;
    private String positionID;

    public String getCandidateID() {
        return this.candidateID;
    }
    
    public String getCaseID() {
        return this.caseID;
    }

    public String getPositionID() {
        return this.positionID;
    }
}