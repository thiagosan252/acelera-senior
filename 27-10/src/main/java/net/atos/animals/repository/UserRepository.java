package net.atos.animals.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.animals.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
	Optional<UserModel> findByUserName(String userName);
	
	
}
