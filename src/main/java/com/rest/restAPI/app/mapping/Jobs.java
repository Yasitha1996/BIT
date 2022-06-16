package com.rest.restAPI.app.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer job_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "deliverer_id")
    private Deliverer deliverer;

    @Column(name = "job_status")
    private String job_status;

    @Column(name = "job_taken_date")
    private String job_taken_date;

    @Column(name = "job_finished_date")
    private String job_finished_date;


}
