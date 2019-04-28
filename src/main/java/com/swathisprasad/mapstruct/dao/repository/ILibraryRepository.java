package com.swathisprasad.mapstruct.dao.repository;

import com.swathisprasad.mapstruct.dao.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ILibraryRepository extends JpaRepository<Library, UUID> {

}
