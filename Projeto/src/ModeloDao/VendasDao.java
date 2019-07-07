package ModeloDao;

import ModeloConection.ConnectionFactory;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
public class VendasDao {

    private Connection con;

    public VendasDao() {
        this.con = new ConnectionFactory().getConnection();
    }
    public void gerarRelatorio(){
            try {
            String sql = " SELECT"
                    + "     clientes.\"id\" AS clientes_id,"
                    + "     produto.\"id\" AS produto_id,"
                    + "     produto.\"referenci\" AS produto_referenci,"
                    + "     venda.\"id\" AS venda_id,"
                    + "     venda.\"referencia\" AS venda_referencia,"
                    + "     venda.\"valordavenda\" AS venda_valordavenda,"
                    + "     venda.\"valordedesconto\" AS venda_valordedesconto,"
                    + "     venda.\"datavenda\" AS venda_datavenda,"
                    + "     venda.\"referenciaProduto\" AS venda_referenciaProduto,"
                    + "     venda.\"cliente\" AS venda_cliente,"
                    + "     produto.\"precocusto\" AS produto_precocusto"
                    + "FROM"
                    + "     \"public\".\"clientes\" clientes INNER JOIN \"public\".\"venda\" venda ON clientes.\"id\" = venda.\"cliente\"\n"
                    + "     INNER JOIN \"public\".\"produto\" produto ON venda.\"referencia\" = produto.\"id\"";
             PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            JRResultSetDataSource jr= new JRResultSetDataSource(rs);
            InputStream caminho = this.getClass().getClassLoader().getResourceAsStream("Relatorio/RelatorioAnaMary.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminho,new HashMap(),jr);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/João Victor Queiroz/Documents/GitHub/Projetos/Projeto/rel/Relatorio.pdf");
            File file = new File("C:/Users/João Victor Queiroz/Documents/GitHub/Projetos/Projeto/rel/Relatorio.pdf");
            try{
                Desktop.getDesktop().open(file);    
            }catch(IOException e){
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
            } catch (JRException | SQLException ex) {
                Logger.getLogger(VendasDao.class.getName()).log(Level.SEVERE, null, ex);
            }   
}
}