package com.hrms.hrms.entity.cv;

import com.hrms.hrms.entity.BaseEntity;
import com.hrms.hrms.entity.users.Candidate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cvs")
public class Cv extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private String photo;
    private String coverLetter;
    private String gitHub;
    private String linkedin;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
    private List<ForeignLanguage> foreignLanguages;

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
    private List<Skill> skills;

    public Cv(Candidate candidate,
              String photo,
              String coverLetter,
              String gitHub,
              String linkedin,
              LocalDateTime createdDate){
        this.candidate = candidate;
        this.photo = photo;
        this.coverLetter = coverLetter;
        this.gitHub = gitHub;
        this.linkedin = linkedin;
        this.createdDate = createdDate;
    }
}
