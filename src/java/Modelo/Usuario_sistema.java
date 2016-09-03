/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Bean.BeanLogin;
import java.util.ArrayList;


/**
 *
 * @author D.A
 */
public class Usuario_sistema extends Conector {
    private String tabla = "usuario_sistema";

    
public void insertar(String usuario, String password, String idTributario) {

        idTributario = comilla + idTributario + comilla;
        usuario = comilla + usuario + comilla;
        password = comilla + password + comilla;
        String SQL = "INSERT INTO " + tabla + " (usuario_sistema, password, id_tributario) "
                + "VALUES (" + usuario + coma + password + coma + idTributario + ");";
        this.consulta_vacia(SQL);
    }
    
    public void actualizar_todas(int usuarioSistema, String usuario, String password){
        usuario = comilla + usuario + comilla;
        password = comilla + password + comilla;
        
        String SQL = "UPDATE "+tabla+" us SET us.usuario = "+usuario+coma+" us.password = "+password+
                " WHERE us.id_usuario_sistema = "+usuarioSistema+";";
        this.consulta_vacia(SQL);
        System.out.println(SQL);
    }
    
//    public String[] consultar_x_usuario(String usuario, char[] separadas){
//        String[] datos = null;
//        String[][] datosSQL = null;
//        StringBuffer unir = new StringBuffer();
//        String password = "";
//        
//        for(int i = 0; i<separadas.length;i++){
//            unir = unir.append(separadas[i]);
//            password = unir.toString();
//        }
//        
//        usuario = comilla + usuario + comilla;
//        //password = comilla + this.getHash(password) + comilla;
//        password = comilla + password + comilla;
//        String SQL = "SELECT us.usuario_sistema, us.password FROM "+tabla+" us "
//                + "WHERE us.usuario_sistema = "+usuario+" AND us.password= "+password+";";
//        datosSQL = this.consulta_registros(SQL);
//        datos = datosSQL[0];
//        return datos;
//    }
    
    //BeanLogin es el JavaBean
    public BeanLogin consultar_x_usuario(String usuario, char[] separadas){
        BeanLogin beanLogin = null;
        String[] datos = null;
        String[][] datosSQL = null;
        StringBuffer unir = new StringBuffer();
        String password = "";
        
        for(int i = 0; i<separadas.length;i++){
            unir = unir.append(separadas[i]);
            password = unir.toString();
        }
        
        usuario = comilla + usuario + comilla;
        //password = comilla + this.getHash(password) + comilla;
        password = comilla + password + comilla;
//        String SQL = "SELECT us.usuario_sistema, us.password FROM "+tabla+" us "
//                + "WHERE us.usuario_sistema = "+usuario+" AND us.password= "+password+";";
        String SQL = "CALL consultar_usuario_sistema("+usuario+coma+password+");";
        datosSQL = this.consulta_registros(SQL);
//        datos = datosSQL[0];
        if (datosSQL.length != 0) {
            datos = datosSQL[0];
            for(int i = 0; i < datos.length; i++){
                beanLogin = new BeanLogin(String.valueOf(datos[0]), String.valueOf(datos[1]));
            }
        }
        
        return beanLogin;
    }
    
        
    public void eliminar(String usuario){
        usuario = comilla+usuario+comilla;
        String SQL = "DELETE FROM "+tabla+" WHERE usuario = "+usuario+";";
        this.consulta_vacia(SQL);
        System.out.println(SQL);
    }

    
}
