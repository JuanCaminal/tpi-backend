package tp.backend.agencia.util;

import java.util.List;

import tp.backend.agencia.models.Agency;
import tp.backend.agencia.models.RestrictedArea;

public class GeoChecker {
    private static final double EARTH_RADIUS_KM = 6371.01;

    // Haversine distance calculation
    public static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c;
    }

    // Check if a point is inside a rectangle defined by northwest and southeast corners
    public static boolean isPointInRectangle(double lat, double lon, 
                                             double nwLat, double nwLon, 
                                             double seLat, double seLon) {
        return lat <= nwLat && lat >= seLat && lon >= nwLon && lon <= seLon;
    }

    // Main check: If a point is allowed based on radius and restricted areas
    public static boolean isAllowedPoint(double pointLat, double pointLon, 
                                         Agency agency, 
                                         List<RestrictedArea> restrictedAreas) {
        // Check if the point is within the agency's radius
        if (haversineDistance(pointLat, pointLon, agency.getLatitude(), agency.getLongitude()) > agency.getAllowedRadius()) {
            return false;
        }

        // Check if the point lies in any restricted area
        for (RestrictedArea area : restrictedAreas) {
            if (isPointInRectangle(pointLat, pointLon, 
                                   area.getNorthwestLatitude(), area.getNorthwestLongitude(),
                                   area.getSoutheastLatitude(), area.getSoutheastLongitude())) {
                return false; // The point is in a restricted area
            }
        }

        // Point is allowed
        return true;
    }
}
