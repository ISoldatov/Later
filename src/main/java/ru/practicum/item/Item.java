package ru.practicum.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "items", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @OneToMany
    @CollectionTable(name="users", joinColumns=@JoinColumn(name="user_id"))
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "url")
    private String url;
}
