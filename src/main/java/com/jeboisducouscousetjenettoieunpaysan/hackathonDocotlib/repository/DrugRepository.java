package com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.repository;

import com.jeboisducouscousetjenettoieunpaysan.hackathonDocotlib.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

    List<Drug> findAll();

    @Query(value = "SELECT * " +
            "FROM drug " +
            "LEFT JOIN composition " +
            "ON drug.id = composition.id_drug " +
            "LEFT JOIN pillbox " +
            "ON pillbox.id = composition.id_pillbox " +
            "LEFT JOIN patient " +
            "ON patient.id = pillbox.id_patient " +
            "WHERE composition.time_of_the_day = 'matin' " +
            "AND patient.id = 1 " +
            "AND composition.day = 'Lundi' ",
            nativeQuery = true)
    List<Drug> findAllMorningDrugs();

    @Query(value = "SELECT * " +
            "FROM drug " +
            "LEFT JOIN composition " +
            "ON drug.id = composition.id_drug " +
            "LEFT JOIN pillbox " +
            "ON pillbox.id = composition.id_pillbox " +
            "LEFT JOIN patient " +
            "ON patient.id = pillbox.id_patient " +
            "WHERE composition.time_of_the_day = 'midi' " +
            "AND patient.id = 1 " +
            "AND composition.day = 'Lundi' ",
            nativeQuery = true)
    List<Drug> findAllMiddayDrugs();

      @Query(value = "SELECT * " +
            "FROM drug " +
            "LEFT JOIN composition " +
            "ON drug.id = composition.id_drug " +
            "LEFT JOIN pillbox " +
            "ON pillbox.id = composition.id_pillbox " +
            "LEFT JOIN patient " +
            "ON patient.id = pillbox.id_patient " +
            "WHERE composition.time_of_the_day = 'avant le couché' " +
            "AND patient.id = 1 " +
            "AND composition.day = 'Lundi' ",
            nativeQuery = true)
    List<Drug> findAllNightDrugs();

    @Query(value = "SELECT * " +
            "FROM drug " +
            "LEFT JOIN composition " +
            "ON drug.id = composition.id_drug " +
            "LEFT JOIN pillbox " +
            "ON pillbox.id = composition.id_pillbox " +
            "LEFT JOIN patient " +
            "ON patient.id = pillbox.id_patient " +
            "WHERE composition.time_of_the_day = 'si besoin' " +
            "AND patient.id = 1 " +
            "AND composition.day = 'Lundi' ",
            nativeQuery = true)
    List<Drug> findAllIfNecessaryDrugs();
}
