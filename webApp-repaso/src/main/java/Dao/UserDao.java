
package Dao;

import Model.User;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        Connection conn = Conexion.getConnection();
        String sql = "Select * from estudiantes";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User u = new User();
            u.setCedula(rs.getInt("cedula"));
            u.setNombre(rs.getString("nombre"));
            u.setApellido(rs.getString("apellido"));
            u.setDireccion(rs.getString("direccion"));
            u.setTelefono(rs.getString("telefono"));
            users.add(u);
        }

        return users;
    }

    public boolean add(User user) throws Exception {
        Connection conn = Conexion.getConnection();
        String sql = "Insert into estudiantes(cedula,nombre,apellido,direccion,telefono) values (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, user.getCedula());
        ps.setString(2, user.getNombre());
        ps.setString(3, user.getApellido());
        ps.setString(4, user.getDireccion());
        ps.setString(5, user.getTelefono());
        int rs = ps.executeUpdate();

        return rs > 0;
    }

    public boolean update(User user) throws Exception {
        Connection conn = Conexion.getConnection();
        String sql = "Update estudiantes set nombre=?,apellido=?,direccion=?,telefono=? where cedula=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(5, user.getCedula());
        ps.setString(1, user.getNombre());
        ps.setString(2, user.getApellido());
        ps.setString(3, user.getDireccion());
        ps.setString(4, user.getTelefono());
        int rs = ps.executeUpdate();

        return rs > 0;
    }

    public boolean delete(int cedula) throws Exception {
        Connection conn = Conexion.getConnection();
        String sql = "DELETE FROM ESTUDIANTES where cedula=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cedula);
        int rs = ps.executeUpdate();
        return rs > 0;
    }

    public User getByCedula(int cedula) throws Exception {
        Connection c = Conexion.getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM estudiantes WHERE cedula=?");
        ps.setInt(1, cedula);
        ResultSet rs = ps.executeQuery();
        User u = null;
        if (rs.next()) {
            u = new User(
                    rs.getInt("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
            );
        }
        c.close();
        return u;
    }
}
