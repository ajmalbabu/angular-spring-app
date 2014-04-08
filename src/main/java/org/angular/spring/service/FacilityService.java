package org.angular.spring.service;

import java.util.List;

import org.angular.spring.example.model.Facility;

/**
 * Created with IntelliJ IDEA.
 * User: ajmal
 * Date: 12/21/12
 * Time: 12:20 AM
 */
public interface FacilityService {
    public List<Facility> getAllFacilitys();

    public Facility getFacilityById(Long id);

    public void addFacility(Facility facility);

    public void deleteFacilityById(Long id);

    public void deleteAll();

    public void updateFacility(Facility facility);
}
