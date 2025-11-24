package com.rad.personservice.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CUSTOMER")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Customer  extends BasePerson<Customer>{

    @Column(name="national_Code")
    private String nationalCode;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "customer")
    private List<Job> jobs = new ArrayList<>();

    // Helper method to add job and maintain bidirectional relationship
    public void addJob(Job job) {
        jobs.add(job);
        job.setCustomer(this);
    }

    // Helper method to remove job and maintain bidirectional relationship
    public void removeJob(Job job) {
        jobs.remove(job);
        job.setCustomer(null);
    }

    // Helper method to set jobs and maintain bidirectional relationship
    public void setJobs(List<Job> jobs) {
        this.jobs.clear();
        if (jobs != null) {
            for (Job job : jobs) {
                this.addJob(job);
            }
        }
    }
}
