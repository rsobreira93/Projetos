/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Modelo.ModeloUsuario;
import Modelo.Produto;
import Modelo.Venda;
import ModeloConection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Romulo Sobreira
 */
public class VendaDao {
     private Connection con;
    
    public VendaDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean add(Venda u){
        try {
            String sql = "INSERT INTO vendas(precovenda, descontovenda, datavenda, formapagamento, produtovendido, cliente) VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setFloat(1, u.getPrecoVenda());
            stmt.setFloat(2, u.getDescontoVenda());
            stmt.setString(3, u.getDataVenda());
            stmt.setBoolean(4, u.getFormaPagamento());
            stmt.setLong(5, u.getProdutoVendido().getCod());
            stmt.setLong(6, u.getCliente().getCod());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda!\n"+ex.getMessage()); 
            return false;
        }
    }
    public boolean delete(Venda u){
        try {
            String sql = "DELETE FROM vendas WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, u.getCodVenda());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Venda excluida com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir venda!\n"+ex.getMessage()); 
            return false;
        }
    }
    
    public List<Venda> getList(){
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM vendas;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Venda  u  = new Venda();
                Produto p = new Produto();
                ModeloUsuario m = new ModeloUsuario();
                
                u.setCodVenda((rs.getInt("id")));//Essa string é de acordo com o nome da coluna no BD
                u.setPrecoVenda(rs.getFloat("precovenda"));
                u.setDescontoVenda(rs.getFloat("descontovenda"));
                u.setFormaPagamento(rs.getBoolean("formapagamento"));
                u.setDataVenda(rs.getString("datavenda"));
                p.setCod(rs.getLong("id_prod"));
                u.setProdutoVendido(p);
                m.setCod(rs.getLong("id_cli"));
                u.setCliente(m);               
                vendas.add(u);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return vendas;
    }
}

