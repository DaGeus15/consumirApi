/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Controllers.Facades.FacadeEstudiante;
import Models.Estudiante;

/**
 *
 * @author garci
 */
public class Prueba {

    public static void main(String[] args) {
        String path = "http://localhost/SOA/controllers/apiRest.php";
        FacadeEstudiante fa= new FacadeEstudiante(path);
        for (Estudiante est : fa.getEstudiantes()) {
            System.out.println(est.toString());
        }

    }
}
