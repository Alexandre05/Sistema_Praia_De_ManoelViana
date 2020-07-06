/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sistemaPraia.DAO;
import java.sql.*;

/**
 *
 * @author Usuario
 */
public class Conexao {
    
 // metodo responsávél conexao banco
    
    public static Connection Conector (){
    
    java.sql.Connection conexao = null;
    // carrega o drive do banco sql
    String driver = "com.mysql.cj.jdbc.Driver";
    // Armazena 
    String url="jdbc:mysql://localhost:3306/controlepraia?";
    String user="root";
    String password="";
    // estabelece a concexão com o banco
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection( url,user, password);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println(e);
            return null;
        }
        
    }
    
}
