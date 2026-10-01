package vn.minxi.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // <-- Đảm bảo Favorite cũng có @Entity
@Table(name = "Favorites")
public class Favorite_24162005 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteId")
    private Integer favoriteId;

    @Temporal(TemporalType.DATE)
    @Column(name = "LikedDate")
    private Date likedDate;

    @ManyToOne
    @JoinColumn(name = "Username")
    private User_24162005 user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video_24162005 video;
}