package vn.minxi.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // <-- QUAN TRỌNG: Phải có annotation này!
@Table(name = "Shares")
public class Share_24162005 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShareId")
    private Integer shareId;

    @Column(name = "Emails")
    private String emails;

    @Temporal(TemporalType.DATE)
    @Column(name = "SharedDate")
    private Date sharedDate;

    @ManyToOne
    @JoinColumn(name = "Username")
    private User_24162005 user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video_24162005 video;
}