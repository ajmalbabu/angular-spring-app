package org.angular.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.angular.spring.example.model.Facility;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: ajmal
 * Date: 12/21/12
 * Time: 12:21 AM
 */
@Service("facilityService")
public class FacilityServiceImpl implements FacilityService {
    private static List<Facility> facilityList = new ArrayList<Facility>();
    private static Long id = 0L;

   // @Override
    public List<Facility> getAllFacilitys() {
        return facilityList;
    }

    //@Override
    public Facility getFacilityById(Long id) {
        return findFacilityById(id);
    }

    //@Override
    public void addFacility(Facility facility) {
        facility.setId(++id);
        facilityList.add(facility);
    }

    //@Override
    public void deleteFacilityById(Long id) {
        Facility foundFacility = findFacilityById(id);
        if (foundFacility != null) {
            facilityList.remove(foundFacility);
            id--;
        }
    }

    //@Override
    public void deleteAll() {
        facilityList.clear();
        id = 0L;
    }

    //@Override
    public void updateFacility(Facility facility) {
        Facility foundFacility = findFacilityById(facility.getId());
        if (foundFacility != null) {
            facilityList.remove(foundFacility);
            facilityList.add(facility);
        }
    }

    private Facility findFacilityById(Long id) {
        for (Facility facility : facilityList) {
            if (facility.getId() == id) {
                return facility;
            }
        }

        return null;
    }
}
