/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import appmoraqui.Locatario;
import appmoraqui.Locator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcello
 */
public class UsuarioDao {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    public boolean LoginLocatario(String cpf,String senha){
        boolean status = false;
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from locatario where CPF = ?");
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if(rs.getString("senha").equals(senha))
                    status=true;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
        }
        return status;
    }
    
    public boolean LoginLocator(String cpf,String senha){
        boolean status = false;
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from locato where CPF = ?");
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if(rs.getString("senha").equals(senha))
                    status=true;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
        }
        return status;
    }
    
    public String LoginGerenciador(String cpf,String senha){
        String status = null;
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from gerenciador where CPF = ?");
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if(rs.getString("senha").equals(senha))
                    status=rs.getString("Nome");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
        }
        return status;
    }
    
    public int Cadastrar(Locatario novo){
        int status = 1;
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from locatario where CPF = ?");
            stmt.setString(1, novo.getCpf());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                status=-1;//cpf já cadastrado
            }else{
                stmt = con.prepareStatement("insert into locatario (Nome,RG,CPF,DataNasc,Endereço,"
                        + "CEP,Sexo,Senha,Aprovado,Fumante,Alergias) values (?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, novo.getNome());
                stmt.setString(2, novo.getRg());
                stmt.setString(3, novo.getCpf());
                stmt.setString(4, "16-10-10");
                stmt.setString(5, novo.getEnd());
                stmt.setString(6, novo.getCep());
                stmt.setString(7, novo.getSexo());
                stmt.setString(8, novo.getSenha());                
                stmt.setBoolean(9, novo.isAprovado());                
                stmt.setBoolean(10, novo.isFumante());
                stmt.setString(11, novo.getAlergias());
                stmt.execute();
            }            
            rs.close();
            stmt.close();
            con.close();
        }catch (SQLException e) {
            status=-2;
        }
        return status;
    }
    
    public int Cadastrar(Locator novo){
        int status = 1;
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from locato where CPF = ?");
            stmt.setString(1, novo.getCpf());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                status=-1;//cpf já cadastrado
            }else{
                stmt = con.prepareStatement("insert into locato (Nome,RG,CPF,DataNasc,Endereço,"
                        + "CEP,Sexo,Senha,Aprovado) values (?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, novo.getNome());
                stmt.setString(2, novo.getRg());
                stmt.setString(3, novo.getCpf());
                stmt.setString(4, "16-10-10");
                stmt.setString(5, novo.getEnd());
                stmt.setString(6, novo.getCep());
                stmt.setString(7, novo.getSexo());
                stmt.setString(8, novo.getSenha());                
                stmt.setBoolean(9, novo.isAprovado());
                stmt.execute();
            }            
            rs.close();
            stmt.close();
            con.close();
        }catch (SQLException e) {
            status=-2;
        }
        return status;
    }
    
    public List<Locatario> LocatarioPendentes(){
        List<Locatario> lista = new ArrayList<>();
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from locatario where Aprovado = false");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Locatario tupla = new Locatario();
                tupla.setCodUsuario(rs.getInt("CodUsuario"));
                tupla.setNome(rs.getString("Nome"));
                tupla.setRg(rs.getString("RG"));
                tupla.setCpf(rs.getString("CPF"));
                tupla.setDataNasc(rs.getDate("DataNasc"));
                tupla.setEnd(rs.getString("Endereço"));
                tupla.setCep(rs.getString("CEP"));
                tupla.setSexo(rs.getString("Sexo"));
                tupla.setAprovado(rs.getBoolean("Aprovado"));
                tupla.setFumante(rs.getBoolean("Fumante"));
                tupla.setAlergias(rs.getString("Alergias"));
                lista.add(tupla);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Locator> LocatorPendentes(){
        List<Locator> lista = new ArrayList<>();
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from locato where Aprovado = false");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Locator tupla = new Locator();
                tupla.setCodUsuario(rs.getInt("CodUsuario"));
                tupla.setNome(rs.getString("Nome"));
                tupla.setRg(rs.getString("RG"));
                tupla.setCpf(rs.getString("CPF"));
                tupla.setDataNasc(rs.getDate("DataNasc"));
                tupla.setEnd(rs.getString("Endereço"));
                tupla.setCep(rs.getString("CEP"));
                tupla.setSexo(rs.getString("Sexo"));
                tupla.setAprovado(rs.getBoolean("Aprovado"));
                lista.add(tupla);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public void AprovarLocatario(int id){
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("update locatario set Aprovado=? where CodUsuario=?");
            stmt.setBoolean(1,true);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
        }        
    }
    
    public void AprovarLocator(int id){
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("update locato set Aprovado=? where CodUsuario=?");
            stmt.setBoolean(1,true);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
        }        
    }

    public void RemoverLocatario(int codUsuario) {
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from locatario where CodUsuario=?");
            stmt.setInt(1, codUsuario);
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
        }
    }

    public void RemoverLocator(int codUsuario) {
        try {
            Connection con =  connectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from locato where CodUsuario=?");
            stmt.setInt(1, codUsuario);
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
        }
    }
    
}
