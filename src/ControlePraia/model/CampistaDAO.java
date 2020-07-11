package ControlePraia.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para Entidade de Campista.
 * @author joaocabraldev
 */
public class CampistaDAO {
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;

    public CampistaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public List<Campista> listarPorCPF(String cpf) throws SQLException {
        
        String sql = " SELECT * FROM tbcampista WHERE CpfCamp LIKE ?%";
        List<Campista> listaCampistas = new ArrayList<>();
        
        pst = conexao.prepareStatement(sql);
        pst.setString(1, cpf);
        rs = pst.executeQuery();
        
        while(rs.next()) {
            Campista campista = new Campista();
            
            campista.setIdCamp(rs.getInt(1));
            campista.setNomeCamp(rs.getString(2));
            campista.setEndcamp(rs.getString(3));
            campista.setCpfCamp(rs.getString(4));
            campista.setTelefoneCamp(rs.getString(5));
            campista.setPlacaCamp(rs.getString(6));
            campista.setObservacoes(rs.getString(7));
            campista.setEmbarca(rs.getString(8));
            campista.setTipo(rs.getString(9));
            campista.setPerfil(rs.getString(10));
            
            listaCampistas.add(campista);
        }
        
        return listaCampistas;
        
    }
    
    public boolean adicionar(Campista campista) throws SQLException {
        
        String sql = "INSERT INTO tbcampista "
                + "(Nomecamp,endcamp,cpfcamp,TelefoneCamp,PlacaCamp,observacoes,Enbarca,Tipo,Perfil)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
               
        pst = conexao.prepareStatement(sql);
        pst.setString(1, campista.getNomeCamp());
        pst.setString(2, campista.getEndcamp());
        pst.setString(3, campista.getCpfCamp());
        pst.setString(4, campista.getTelefoneCamp());
        pst.setString(5, campista.getPlacaCamp());
        pst.setString(6, campista.getObservacoes());
        pst.setString(7, campista.getEmbarca());
        pst.setString(8, campista.getTipo());
        pst.setString(9, campista.getPerfil());
        
        return pst.executeUpdate() > 0;
        
    }
    
    public boolean alterar(Campista campista) throws SQLException {
        
        String sql = "UPDATE tbcampista SET NomeCamp=?,endcamp=?,CpfCamp=?,TelefoneCamp=?,PlacaCamp=?,observacoes=?,"
                + "Enbarca=?,Tipo=?, Perfil=? WHERE IdCamp=?";
        
        pst = conexao.prepareStatement(sql);
        pst.setString(1, campista.getNomeCamp());
        pst.setString(2, campista.getEndcamp());
        pst.setString(3, campista.getCpfCamp());
        pst.setString(4, campista.getTelefoneCamp());
        pst.setString(5, campista.getPlacaCamp());
        pst.setString(6, campista.getObservacoes());
        pst.setString(7, campista.getEmbarca());
        pst.setString(8, campista.getTipo());
        pst.setString(9, campista.getPerfil());
        pst.setInt(10, campista.getIdCamp());
        
        return pst.executeUpdate() > 0;
        
    }
    
    public boolean excluir(Integer id) throws SQLException {
        
        String sql = "DELETE FROM tbcampista WHERE IdCamp=?";
        
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        
        return pst.executeUpdate() > 0;
        
    }
    
}
