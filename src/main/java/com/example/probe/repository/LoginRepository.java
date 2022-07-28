package com.example.probe.repository;

import com.example.probe.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Login, Integer>{

    @Query("Select l from Login l where l.benutzername =:benutzername and l.passwort=:passwort")
    public Login findeAnmeldung(@Param("benutzername") String benutzername, @Param("passwort") String passwort);


}