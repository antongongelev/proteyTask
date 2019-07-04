package com.application.Data.DTO;

import com.application.Data.Enum.Status;

public class IdAndStatusesDTO {

    private Long id;
    private Status previousStatus;
    private Status newStatus;

    public IdAndStatusesDTO() {
    }

    public IdAndStatusesDTO(Long id, Status previousStatus, Status newStatus) {
        this.id = id;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(Status previousStatus) {
        this.previousStatus = previousStatus;
    }

    public Status getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Status newStatus) {
        this.newStatus = newStatus;
    }
}
