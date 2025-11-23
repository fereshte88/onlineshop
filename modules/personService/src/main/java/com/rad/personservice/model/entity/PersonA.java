package com.rad.personservice.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PERSON_A")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PersonA  extends BasePerson<PersonA>{

    @Column(name = "first_Name")
    private String firstName;

    @Column(name="last_Name")
    private String lastName;

    @Column(name="national_Code")
    private String nationalCode;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "personA")
    private List<Job> jobs = new ArrayList<>();

    // Helper method to add job and maintain bidirectional relationship
    public void addJob(Job job) {
        jobs.add(job);
        job.setPersonA(this);
    }

    // Helper method to remove job and maintain bidirectional relationship
    public void removeJob(Job job) {
        jobs.remove(job);
        job.setPersonA(null);
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
