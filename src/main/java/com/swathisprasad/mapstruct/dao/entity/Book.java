package com.swathisprasad.mapstruct.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (generator="uuid")
    @GenericGenerator (name="uuid", strategy="org.hibernate.id.UUIDGenerator")
    @Column (name="id", updatable=false, nullable=false)
    private UUID id;

    @NotNull
    @Column (name="name", nullable=false)
    private String name;

    @NotNull
    @Column (name="author", nullable=false)
    private String author;

    @NotNull
    @Column (name="published_date", nullable=false)
    private LocalDateTime publishedDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(optional=false)
    @JoinColumn (name="library_id", nullable=false)
    private Library library;

}

